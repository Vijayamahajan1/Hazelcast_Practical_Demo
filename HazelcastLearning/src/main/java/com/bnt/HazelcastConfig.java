//package com.bnt;
//
//import com.hazelcast.config.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//
//import com.bnt.mapstore.EmployeeMapstore;
//import com.hazelcast.core.Hazelcast;
//import com.hazelcast.core.HazelcastInstance;
//
//@Configuration
//public class HazelcastConfig {
//    @Bean
//    @Lazy
//    public HazelcastInstance hazelcastInstance(EmployeeMapstore employeeMapstore){
//        Config config = new Config();
//        config.setInstanceName("my-first-hz-instance");
//        config.setClusterName("my-first-cluster");
//
//
//        NetworkConfig network = config.getNetworkConfig();
//		JoinConfig join = network.getJoin();
//
//		join.getMulticastConfig().setEnabled(false);
//		join.getTcpIpConfig().setEnabled(true)
//		.addMember("localhost:5701")
//		.addMember("localhost:5702");
//
//        network.setPortCount(2);
//
//        MapConfig myMapConfig = new MapConfig();
//        myMapConfig.setName("myMap");
//        MapConfig demoMapconfig = new MapConfig();
//        demoMapconfig.setName("demoMap");
//
//        demoMapconfig.setTimeToLiveSeconds(10);
//
//        demoMapconfig.setMaxIdleSeconds(5);
//
//
//       MapStoreConfig empMapStoreConfig = new MapStoreConfig();
//       empMapStoreConfig.setImplementation(employeeMapstore).setWriteDelaySeconds(90)
//                                        .setInitialLoadMode(MapStoreConfig.InitialLoadMode.EAGER).setWriteCoalescing(false);
//
//
//       MapConfig employeeMapConfig = new MapConfig();
//       employeeMapConfig.setMapStoreConfig(empMapStoreConfig).setName("employeeMap");
//
//       EvictionConfig evictionConfig = new EvictionConfig();
//
//       evictionConfig.setEvictionPolicy(EvictionPolicy.LFU)
//                    .setMaxSizePolicy(MaxSizePolicy.PER_NODE)
//                    .setSize(5);
//
//       employeeMapConfig.setEvictionConfig(evictionConfig);
//
//
//        config.addMapConfig(employeeMapConfig);
//        config.addMapConfig(demoMapconfig);
//
//        return Hazelcast.newHazelcastInstance(config);
//    }
//}
