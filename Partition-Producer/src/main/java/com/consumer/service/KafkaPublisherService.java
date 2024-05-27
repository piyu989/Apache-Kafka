package com.consumer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.consumer.entity.Customer;

@Service
public class KafkaPublisherService {
	@Autowired
	private KafkaTemplate<String, Object>template;
	
	public void sendMessage(String message) {
		CompletableFuture<SendResult<String,Object>>future=template.send("javaPartition",2,null,message);
		
		future.whenCompleteAsync((result,ex) -> {
			if(ex==null) {
				System.out.println("message sent.... with offset "+result.getRecordMetadata().offset());
			}else {
				System.out.println("not sent......");
			}
		});
	}
	
	public void sendMessage(Customer message) {
		CompletableFuture<SendResult<String,Object>>future=template.send("javaPartition",message);
		
		future.whenCompleteAsync((result,ex) -> {
			if(ex==null) {
				System.out.println("message sent.... with offset "+result.getRecordMetadata().offset());
			}else {
				System.out.println("not sent......");
			}
		});
	}
	
	
}
