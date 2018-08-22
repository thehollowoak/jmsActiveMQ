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
	JmsConsumer jmsConsumer;
	
	@Autowired
	JmsProducer jmsProducer;

	@RequestMapping(value="/produce")
	public String produce(@RequestParam("msg")String msg){
		jmsProducer.send(msg);
		return "Done";
	}
	
	@RequestMapping(value="/receive")
	public String receive(){
		String msg = jmsConsumer.receive();
		msg += ", received";
		jmsConsumer.send(msg);
		return "Done";
	}
	
	@RequestMapping(value="/return")
	public String returnMsg(){
		return jmsProducer.receive();
	}
}
