package com.javasampleapproach.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void send(String destinationQueue, String msg){
		jmsTemplate.convertAndSend(destinationQueue, msg);
	}
}