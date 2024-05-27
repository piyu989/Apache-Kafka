package com.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.consumer.entity.Customer;

@Service
public class KafkaMessageConsumer {
	
	Logger log=LoggerFactory.getLogger(KafkaMessageConsumer.class);

	@KafkaListener(topics = "javaPartition", groupId = "jt-customer")
	public void consumer(Customer customer) {
		log.info("consume message succesfully "+customer.toString());
	}
	
//	@KafkaListener(topics = "java2", groupId = "jt-1")
//	public void KafkaMessageListener1(String message) {
//		log.info("consumer1 consume the message");
//	}
//	@KafkaListener(topics = "java2", groupId = "jt-1")
//	public void KafkaMessageListener2(String message) {
//		log.info("consumer2 consume the message");
//	}
//	@KafkaListener(topics = "java2", groupId = "jt-1")
//	public void KafkaMessageListener3(String message) {
//		log.info("consume3 consume the message");
//	}
//	@KafkaListener(topics = "java2", groupId = "jt-1")
//	public void KafkaMessageListener4(String message) {
//		log.info("consumer4 consume the message");
//	}
//	@KafkaListener(topics = "java2", groupId = "jt-1")
//	public void KafkaMessageListener5(String message) {
//		log.info("consumer5 consume the message");
//	}
//	@KafkaListener(topics = "java2", groupId = "jt-1")
//	public void KafkaMessageListener6(String message) {
//		log.info("consumer6 consume the message");
//	}
	
}
