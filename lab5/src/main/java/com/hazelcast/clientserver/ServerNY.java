package com.hazelcast.clientserver;

import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;

public class ServerNY {
    public static void main(String[] args) {
        Config config = new ClasspathXmlConfig("hazelcast-ny.xml");
        Hazelcast.newHazelcastInstance(config);
    }
}
