package com.bnt.HazelcastClient.controller;

import com.bnt.HazelcastClient.consumer.QueueConsumer;
import com.bnt.HazelcastClient.producer.QueueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class    QueueController {

    @Autowired
    QueueProducer queueProducer;

    @Autowired
    private QueueConsumer consumer;

    @GetMapping("/start-consumer")
    public String start() {
        consumer.startConsumer();
        return "Consumer started";
    }

    @PostMapping("/{task}")
    public  String send(@PathVariable String task) {
        queueProducer.sendTask(task);
        return task;
    }
}
