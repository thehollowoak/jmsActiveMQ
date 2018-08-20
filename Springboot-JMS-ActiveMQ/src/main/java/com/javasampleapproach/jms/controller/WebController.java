package com.javasampleapproach.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.jms.client.JmsClient;

@RestController
public class WebController {
	
	@Autowired
	@Qualifier("JmsClientImpl1")
	JmsClient jsmClient1;

	@Autowired
	@Qualifier("JmsClientImpl2")
	JmsClient jsmClient2;
	
	@RequestMapping(value="/produce")
	public String produce(@RequestParam("msg")String msg){
		jsmClient1.send(msg);
		return "Done";
	}
	
	@RequestMapping(value="/receive")
	public String receive(){
		String msg = jsmClient2.receive();
		msg += ", received";
		jsmClient2.send(msg);
		return "Done";
	}
	
	@RequestMapping(value="/return")
	public String return(){
		return jsmClient1.receive();
	}
}
