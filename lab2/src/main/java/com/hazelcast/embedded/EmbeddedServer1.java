package com.hazelcast.embedded;

import com.hazelcast.core.Hazelcast;

public class EmbeddedServer1 {

    public static void main(String[] args) {
        Hazelcast.newHazelcastInstance();
        Hazelcast.newHazelcastInstance();
    }
}
