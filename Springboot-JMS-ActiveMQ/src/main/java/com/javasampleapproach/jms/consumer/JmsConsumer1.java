package com.javasampleapproach.jms.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer1 {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jms.queue.destination1}")
	String destinationQueue;
	
	public String receive(){
		return (String)jmsTemplate.receiveAndConvert(destinationQueue); 
	}
}
