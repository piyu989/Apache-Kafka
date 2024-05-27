package com.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.consumer.entity.Customer;

@Service
public class KafkaMessageConsumer {

	Logger log=LoggerFactory.getLogger(KafkaMessageConsumer.class);
	
//	@KafkaListener(topics = "javaPartition", groupId = "jt-1",topicPartitions = {@TopicPartition(topic = "javaPartition",partitions = {"1"})})
//	@KafkaListener(topics="javaPartition",groupId="jt-1")
	@KafkaListener(
		    topics = "javaPartition",
		    groupId = "jt-1",
		    topicPartitions = @TopicPartition(topic = "javaPartition", partitions = {"1"})
		)
	public void consume(String message) {
		log.info("message consumed "+message);
	}
	
//	@KafkaListener(topics = "javaPartition", groupId="jt-1", topicPartitions = {@TopicPartition(topic="javaPartition",partitions = {"2"})})
//	@KafkaListener(topics="javaPartition",groupId="jt-1")
	@KafkaListener(
		    topics = "javaPartition",
		    groupId = "jt-1",
		    topicPartitions = @TopicPartition(topic = "javaPartition", partitions = {"1"})
		)
	public void consume(Customer cust) {
		log.info("customer consumed "+cust.toString());
	}
	
}
