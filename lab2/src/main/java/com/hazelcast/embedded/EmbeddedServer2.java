package com.hazelcast.embedded;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.stream.IntStream;

public class EmbeddedServer2 {

    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

        IMap<Integer, String> labMap = hazelcastInstance.getMap("lab-test");
        IntStream.range(0, 100000).forEach(id -> labMap.put(id, "value-"+id));
    }
}
