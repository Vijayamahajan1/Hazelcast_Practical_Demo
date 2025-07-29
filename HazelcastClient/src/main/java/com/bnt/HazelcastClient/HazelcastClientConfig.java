package com.bnt.HazelcastClient;

import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MaxSizePolicy;
import com.hazelcast.config.NearCacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

@Configuration
public class HazelcastClientConfig {
    
    @Bean
    public HazelcastInstance hazelcastInstance(){
        ClientConfig config = new ClientConfig();
        config.setClusterName("my-first-cluster");
        config.getNetworkConfig().addAddress("localhost:5701" ,"localhost:5702");


        NearCacheConfig nearCacheConfig = new NearCacheConfig();
        nearCacheConfig.setInvalidateOnChange(true);
        nearCacheConfig.setName("employeeMap");
        nearCacheConfig.setTimeToLiveSeconds(0);

        config.addNearCacheConfig(nearCacheConfig);

        return HazelcastClient.newHazelcastClient(config);
    }
}
