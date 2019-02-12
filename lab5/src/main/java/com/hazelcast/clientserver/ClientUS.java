package com.hazelcast.clientserver;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientClasspathXmlConfig;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.stream.IntStream;

public class ClientUS {

    public static void main(String[] args) {
        ClientConfig config = new ClientClasspathXmlConfig("hazelcast-client-us.xml");
        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient(config);

        IMap<Integer, String> labMap = hazelcastInstance.getMap("my-shared-map");
        IntStream.range(0, 100000).forEach(id -> labMap.put(id, "value-"+id));

        IMap<Integer, String> testMap = hazelcastInstance.getMap("my-map");
        IntStream.range(0, 100000).forEach(id -> testMap.put(id, "value-"+id));

    }
}
