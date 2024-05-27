package com.consumer.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.consumer.entity.Customer;

@Configuration
public class KafkaConfiguration {

	@Bean
	public Map<String, Object> consumerConfig(){
		Map<String,Object> hm=new HashMap<>();
		
		hm.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		hm.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		hm.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		hm.put(JsonDeserializer.TRUSTED_PACKAGES,"*");
		
		return hm;
	}
	
	@Bean
	public ConsumerFactory<String, Object>consumerFactory(){
		return new DefaultKafkaConsumerFactory<>(consumerConfig());
	}
	
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Customer>> kafkaListener(){
		ConcurrentKafkaListenerContainerFactory<String, Customer> fact=new ConcurrentKafkaListenerContainerFactory<>();
		fact.setConsumerFactory(consumerFactory());
		return fact;
	}
	
}
