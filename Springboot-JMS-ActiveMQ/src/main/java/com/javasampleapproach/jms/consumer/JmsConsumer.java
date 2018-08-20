package com.javasampleapproach.jms.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	public String receive(String destinationQueue){
		return (String)jmsTemplate.receiveAndConvert(destinationQueue); 
	}
}
