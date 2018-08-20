package com.javasampleapproach.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer2 {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jms.queue.destination2}")
	String destinationQueue;
	
	public void send(String msg){
		jmsTemplate.convertAndSend(destinationQueue, msg);
	}
}