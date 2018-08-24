package com.javasampleapproach.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.jms.consumer.JmsConsumer;
import com.javasampleapproach.jms.producer.JmsProducer;

@RestController
public class WebController {
	
	@Autowired
	JmsConsumer jmsConsumer;
	
	@Autowired
	JmsProducer jmsProducer;

	@RequestMapping(value="/produce")
	public String produce(@RequestParam("msg")String msg){
		jmsProducer.send(msg);
		return "MESSAGE SENT: "+msg;
	}
	
	@RequestMapping(value="/receive")
	public String receive(){
		String msg = "MESSAGE RECEIVED: "+jmsConsumer.receive();
		jmsConsumer.send(msg);
		return msg;
	}
	
	@RequestMapping(value="/return")
	public String returnMsg(){
		String msg = jmsProducer.receive();
		return "ACKNOWLEDGEMENT RECEIVED: "+msg;
	}
}
