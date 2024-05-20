package com.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.service.KafkaMessager;

@RestController
@RequestMapping("/producer-app")
public class Eventcontroller {

	@Autowired
	private KafkaMessager messager;

	@GetMapping("/getmessage/{message}")
	public ResponseEntity<?> publishMessage(@PathVariable String message){
		try {
			for(int i=0;i<1000;i++) {
				messager.sendMessage(message+" : "+i);
			}
			return ResponseEntity.ok("done");
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
