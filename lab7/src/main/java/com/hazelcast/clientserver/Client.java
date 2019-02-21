package com.hazelcast.clientserver;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.monitor.NearCacheStats;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Client {

    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient();
        int offset = 0;
        IMap<Integer, String> labMap = hazelcastInstance.getMap("lab-test-client");
        IntStream.range(0, 100000).forEach(id -> labMap.put(id+offset, "value-"+id+offset));

        int max = 100000;
        while(true)
        {
            try
            {
                IntStream.range(0, 1000).forEach(id ->
                {
                    int ind = ThreadLocalRandom.current().nextInt(max);
                    labMap.put(ind, "value-"+ind);
                });

                System.out.print("sleeping...");
                Thread.sleep(15000);
                System.out.println(" now awake.");

                IntStream.range(0, 1000).forEach(id ->
                {
                    int ind = ThreadLocalRandom.current().nextInt(max);
                    labMap.get(ind);
                });

                NearCacheStats stats = labMap.getLocalMapStats().getNearCacheStats();
                System.out.println(stats.toString());
            }
            catch (InterruptedException e)
            {
                System.exit(0);
            }
        }
    }
}
