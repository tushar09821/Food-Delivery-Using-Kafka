package com.dobby.order_service.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaConfig {
    @Bean
    public KafkaAdmin admin(){
        Map<String,Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:29092,localhost:29093");
        return new KafkaAdmin(configs);
    }


    public KafkaAdmin.NewTopics createTopic(){
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("order-event").partitions(3).replicas(2).build()
        );
    }
}
