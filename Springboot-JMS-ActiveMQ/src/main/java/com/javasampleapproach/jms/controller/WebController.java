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
	JmsClient jmsClient;

	@Value("${jms.queue.destination1}")
	String destinationQueue;

	@Value("${jms.queue.destination2}")
	String returnQueue;
	
	@RequestMapping(value="/produce")
	public String produce(@RequestParam("msg")String msg){
		jmsClient.send(destinationQueue, msg);
		return "Done";
	}
	
	@RequestMapping(value="/receive")
	public String receive(){
		String msg = jmsClient.receive(destinationQueue);
		msg += ", received";
		jmsClient.send(returnQueue, msg);
		return "Done";
	}
	
	@RequestMapping(value="/return")
	public String returnMsg(){
		return jmsClient.receive(returnQueue);
	}
}
