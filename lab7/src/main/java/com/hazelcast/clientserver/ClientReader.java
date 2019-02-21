package com.hazelcast.clientserver;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientClasspathXmlConfig;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.monitor.NearCacheStats;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class ClientReader {

    public static void main(String[] args) {
        ClientConfig config = new ClientClasspathXmlConfig("hazelcast-client.xml");
        config.setInstanceName("client-reader");

        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient(config);
        IMap<Integer, String> labMap = hazelcastInstance.getMap("lab-test-client");

        int max = 1000;
        while(true)
        {
            try
            {
                System.out.println(" now awake.");

                IntStream.range(0, max).forEach(id ->
                {
                    int ind = ThreadLocalRandom.current().nextInt(max);
                    labMap.get(ind);
                });

                NearCacheStats stats = labMap.getLocalMapStats().getNearCacheStats();
                System.out.println(stats.toString());
                System.out.print("sleeping...");
                Thread.sleep(15000);
            }
            catch (InterruptedException e)
            {
                System.exit(0);
            }
        }
    }
}
