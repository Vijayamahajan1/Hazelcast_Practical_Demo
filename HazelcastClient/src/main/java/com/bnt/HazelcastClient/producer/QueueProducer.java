package com.bnt.HazelcastClient.producer;

import com.hazelcast.collection.IQueue;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QueueProducer {

    @Autowired
    HazelcastInstance hazelcastInstance;

    public void sendTask(String task) {
        IQueue<String> queue = hazelcastInstance.getQueue("my-queue");
        boolean result = queue.offer(task);
        log.info("Was insert successful? " + result);
        log.info("Task sent: " + task);
    }
}
