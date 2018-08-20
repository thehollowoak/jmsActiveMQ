package com.javasampleapproach.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.jms.client.JmsClient;

@RestController
public class WebController {
	
	@Autowired
	JmsClient jsmClient;

	@Value("${jms.queue.destination1}")
	String destinationQueue;

	@Value("${jms.queue.destination2}")
	String returnQueue;
	
	@RequestMapping(value="/produce")
	public String produce(@RequestParam("msg")String msg){
		jsmClient1.send(destinationQueue, msg);
		return "Done";
	}
	
	@RequestMapping(value="/receive")
	public String receive(){
		String msg = jsmClient.receive(destinationQueue);
		msg += ", received";
		jsmClient.send(returnQueue, msg);
		return "Done";
	}
	
	@RequestMapping(value="/return")
	public String returnMsg(){
		return jsmClient.receive(returnQueue);
	}
}
