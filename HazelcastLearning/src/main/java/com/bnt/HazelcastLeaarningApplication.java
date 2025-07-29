package com.bnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;



@SpringBootApplication
public class HazelcastLeaarningApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazelcastLeaarningApplication.class, args);
		// HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        // System.out.println("Hazelcast Node Started");
        // System.out.println("Cluster Members: " + hz.getCluster().getMembers());
	}

}
