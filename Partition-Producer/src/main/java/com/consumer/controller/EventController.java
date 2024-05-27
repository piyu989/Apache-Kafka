package com.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.entity.Customer;
import com.consumer.service.KafkaPublisherService;

@RestController
@RequestMapping("/producer-app")
public class EventController {
	
	@Autowired
	public KafkaPublisherService service;
	
	@GetMapping("/getmessage/{msg}")
	public ResponseEntity<?> publishMessage(@PathVariable String msg){
		try {
			for(int i=0;i<10000;i++) {				
				service.sendMessage(msg);
			}
			
			return ResponseEntity.ok("Done..");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}
	
	@PostMapping("/getmessage")
	public ResponseEntity<?> publishMessage(@RequestBody Customer cust){
		service.sendMessage(cust);
		return ResponseEntity.ok("Done....");
	}
	
}
