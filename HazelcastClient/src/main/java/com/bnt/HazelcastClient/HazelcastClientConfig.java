package com.bnt.HazelcastClient;

import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MaxSizePolicy;
import com.hazelcast.config.NearCacheConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class HazelcastClientConfig {

    @Value("${hazelcast.cluster.name:my-first-cluster}")
    private String clusterName;

    @Value("${hazelcast.near.cache:employeeMap}")
    private String nearCacheName;

    @Bean
    public HazelcastInstance hazelcastInstance() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("hazelcast.cluster.name", clusterName);
        properties.setProperty("hazelcast.near.cache", nearCacheName);

        XmlClientConfigBuilder builder = new XmlClientConfigBuilder("hazelcast-client-config.xml");
        builder.setProperties(properties); // inject values

        ClientConfig config = builder.build();
        return HazelcastClient.newHazelcastClient(config);
    }
}
