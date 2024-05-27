package com.pro.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessager {
	@Autowired
	private KafkaTemplate<String, Object> template;
	
	public void sendMessage(String message) {
		CompletableFuture<SendResult<String,Object>>future = template.send("javaPartition ",message);
	
		future.whenComplete((result,ex)->{
			if(ex==null) {
				System.out.println("sent message "+message+" "+result.getRecordMetadata().offset());
			}else {
				System.out.println("not able");
			}
		});
	}
}
