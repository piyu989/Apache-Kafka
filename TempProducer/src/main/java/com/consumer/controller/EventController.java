package com.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.entity.Customer;
import com.consumer.service.KafkaPublisher;

@RestController
@RequestMapping("/producer-app")
public class EventController {
	
	@Autowired
	public KafkaPublisher publisher;

	@GetMapping("/getmessage/{message}")
	public ResponseEntity<?> publishMessage(@PathVariable String message){
		
		try {
			
			for(int i=0;i<10000;i++) {
				publisher.sendMessage(message);			
			}
			return ResponseEntity.ok("all done");
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/event")
	public void getCustomer(@RequestBody Customer customer) {
		publisher.sendEventMessage(customer);
	}
}
