package com.cons.consuming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListiner {

	Logger logger=LoggerFactory.getLogger(KafkaMessageListiner.class);
	
	@KafkaListener(topics = "Demo-2",groupId = "jt-group-2")
	public void consume(String message) {
		logger.info("consumer1 consume the message {}",message);
	}
	@KafkaListener(topics = "Demo-2",groupId = "jt-group-2")
	public void consume1(String message) {
		logger.info("consumer2 consume the message {}",message);
	}@KafkaListener(topics = "Demo-2",groupId = "jt-group-2")
	public void consume2(String message) {
		logger.info("consumer3 consume the message {}",message);
	}
	
}
