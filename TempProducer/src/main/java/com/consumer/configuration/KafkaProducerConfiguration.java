package com.consumer.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfiguration {

	@Bean
	public NewTopic createTopic() {
		return new NewTopic("java3", 3, (short)1);
	}
}
