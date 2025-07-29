package com.bnt;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import jakarta.annotation.PostConstruct;

@Component
public class IMapClass {
    @Autowired
    HazelcastInstance hazelcastInstance;

    @PostConstruct
    public void initData(){
        IMap<String , String> map = hazelcastInstance.getMap("myMap");
        System.out.println("Preloaded data into IMap");
        map.put("fruit", "apple");
        map.put("color", "blue");
    }
}
