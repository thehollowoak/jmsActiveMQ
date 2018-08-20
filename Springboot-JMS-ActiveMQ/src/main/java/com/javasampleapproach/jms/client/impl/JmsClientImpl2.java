package com.javasampleapproach.jms.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.jms.client.JmsClient;
import com.javasampleapproach.jms.consumer.JmsConsumer;
import com.javasampleapproach.jms.producer.JmsProducer;

@Service
public class JmsClientImpl2 implements JmsClient{

	@Autowired
	JmsConsumer1 jmsConsumer;
	
	@Autowired
	JmsProducer2 jmsProducer;
	
	@Override
	public void send(String msg) {
		jmsProducer.send(msg);
	}

	@Override
	public String receive() {
		return jmsConsumer.receive();
	}

}
