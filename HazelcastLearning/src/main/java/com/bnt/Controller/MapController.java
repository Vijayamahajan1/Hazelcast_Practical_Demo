package com.bnt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

@RestController
@RequestMapping("/map")
public class MapController {

    @Autowired
    HazelcastInstance hazelcastInstance;
    
    @GetMapping("/{key}")
    public String getMapData(@PathVariable (name = "key")String key){
       IMap<String , String> mapData = hazelcastInstance.getMap("myMap");
       String value = mapData.get(key);
       return value;
    }
    
    @PostMapping
    public String putData(@RequestParam (name = "key") String key , @RequestParam (name = "value") String value){
      IMap<String,String> demoMapData = hazelcastInstance.getMap("demoMap");
      demoMapData.put(key, value);
      return "Added  " + key  + "  value  " + value;
    }

    @GetMapping("/demoMapData/{key}")
    public String getDemoMapData(@PathVariable (name = "key")String key){
       IMap<String , String> mapData = hazelcastInstance.getMap("demoMap");
       String value = mapData.get(key);
       return value;
    }
    
}
