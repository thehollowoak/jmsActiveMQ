package com.javasampleapproach.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jms.queue.destination1}")
	String destinationQueue;
	
	@Value("${jms.queue.destination2}")
	String returnQueue;

	public void send(String msg){
		jmsTemplate.convertAndSend(destinationQueue, msg);
	}

	public String receive(String destinationQueue){
		return (String)jmsTemplate.receiveAndConvert(destinationQueue); 
	}
}