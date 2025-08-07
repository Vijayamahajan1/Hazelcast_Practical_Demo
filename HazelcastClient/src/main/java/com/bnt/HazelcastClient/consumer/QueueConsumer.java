package com.bnt.HazelcastClient.consumer;

import com.hazelcast.collection.IQueue;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    public void startConsumer() {
        new Thread(() -> {
            try {
                IQueue<String> queue = hazelcastInstance.getQueue("my-queue");
                while (true) {
                    String task = queue.take();
                    System.out.println("Task received by consumer 1: " + task);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

}
