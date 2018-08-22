package com.javasampleapproach.jms.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jms.queue.destination1}")
	String destinationQueue;

	@Value("${jms.queue.destination2}")
	String returnQueue;

	public String receive(String destinationQueue){
		return (String)jmsTemplate.receiveAndConvert(destinationQueue); 
	}

	public void send(String msg){
		jmsTemplate.convertAndSend(returnQueue, msg);
	}
}
