package com.javasampleapproach.jms.consumer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;

public class JmsConsumerTest {
	private String destinationQueue;	
	private JmsConsumer consumer;
	
	private JmsTemplate mockTemplate;
	
	@Before
	public void before() {
		consumer = new JmsConsumer();
		destinationQueue = "test-queue";
		mockTemplate = mock(JmsTemplate.class);
		consumer.jmsTemplate = mockTemplate;
		consumer.destinationQueue = destinationQueue;
	}
	
	@After
	public void after() {
		verify(mockTemplate);
	}
	
	@Test
	public void testReceive() {
		String testMsg = "Test message.";
		when(mockTemplate.receiveAndConvert(destinationQueue)).thenReturn(testMsg);
		String response = consumer.receive();
		assertEquals(testMsg, response);
		
	}
	

}
