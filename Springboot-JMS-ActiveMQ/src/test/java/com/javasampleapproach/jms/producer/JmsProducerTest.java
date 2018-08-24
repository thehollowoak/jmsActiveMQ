package com.javasampleapproach.jms.producer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;

import com.javasampleapproach.jms.producer.JmsProducer;

public class JmsProducerTest {
	private String returnQueue;	
	private JmsProducer producer;
	
	private JmsTemplate mockTemplate;
	
	@Before
	public void before() {
		producer = new JmsProducer();
		returnQueue = "test-queue";
		mockTemplate = mock(JmsTemplate.class);
		producer.jmsTemplate = mockTemplate;
		producer.returnQueue = returnQueue;
	}
	
	@After
	public void after() {
		verify(mockTemplate).receiveAndConvert(returnQueue);
	}
	
	@Test
	public void testReceive() {
		String testMsg = "Test message.";
		when(mockTemplate.receiveAndConvert(returnQueue)).thenReturn(testMsg);
		String response = producer.receive();
		assertEquals(testMsg, response);
		
	}
	
	@Test
	public void testSend() {
		String testMsg= "test message";
		producer.send(testMsg);
		when(mockTemplate.receiveAndConvert(returnQueue)).thenReturn(testMsg);
		String response = producer.receive();
		assertEquals(testMsg, response);
	}

}
