package com.hazelcast.clientserver;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.stream.IntStream;

public class Client {

    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient();

        IMap<Integer, String> labMap = hazelcastInstance.getMap("lab-test-client");
        IntStream.range(0, 100000).forEach(id -> labMap.put(id, "value-"+id));
    }
}
