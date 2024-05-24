package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class NewConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewConsumerApplication.class, args);
	}
	
	@KafkaListener(topics = "test", groupId = "group1")
    public void listen1(String in) {
        System.out.println("Message received: " + in);
    }

    @KafkaListener(topics = "test", groupId = "group1")
    public void listen2(String in){
        System.out.println("Message received: " + in);
    }

}
