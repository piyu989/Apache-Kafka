package com.consumer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.consumer.entity.Customer;

@Service
public class KafkaPublisher {
	@Autowired
	private KafkaTemplate<String, Object> template;
	
	public void sendMessage(String message) {
		CompletableFuture<SendResult<String,Object>> future = template.send("java2", message);
	
		future.whenCompleteAsync((result,ex) -> {
			if(ex==null) {
				System.out.println("sent message=["+message+"] with offset=["+result.getRecordMetadata().offset()+"]");
			}else {
				System.out.println("unable to send message");
			}
		});
	}
	
	public void sendEventMessage(Customer customer) {
		CompletableFuture<SendResult<String,Object>> future = template.send("java3", customer);
		
		try {
			future.whenCompleteAsync((result,ex) -> {
				if(ex==null) {
					System.out.println("sent message=["+customer+"] with offset=["+result.getRecordMetadata().offset()+"]");
				}else {
					System.out.println("unable to send message");
				}
			});
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
