package com.javasampleapproach.jms.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.javasampleapproach.jms.consumer.JmsConsumer;
import com.javasampleapproach.jms.producer.JmsProducer;

public class WebControllerTest {
	
	JmsProducer mockProducer;
	JmsConsumer mockConsumer;
	String destinationQueue, returnQueue;
	
	WebController controller;
	
	@Before
	public void before() {
		controller = new WebController();
		mockProducer = mock(JmsProducer.class);
		mockConsumer = mock(JmsConsumer.class);
		controller.jmsProducer = mockProducer;
		controller.jmsConsumer = mockConsumer;
	}
	
	
	@Test
	public void testProduce() {
		String testMsg = "test message";
		String response = controller.produce(testMsg);
		String expectedResponse = "MESSAGE SENT: "+testMsg;
		assertEquals(expectedResponse, response);
	}
	
	@Test
	public void testReceive() {
		String testMsg = "test message";
		String expectedResponse = "MESSAGE RECEIVED: "+testMsg;
		when(mockConsumer.receive()).thenReturn(testMsg);
		String response = controller.receive();
		assertEquals(expectedResponse, response);
	}
	
	@Test
	public void testReturn() {
		String testMsg = "MESSAGE RECEIVED: test message";
		String expectedResponse = "ACKNOWLEDGEMENT RECEIVED: MESSAGE RECEIVED: test message";
		when(mockProducer.receive()).thenReturn(testMsg);
		String response = controller.returnMsg();
		assertEquals(expectedResponse, response);
	}


}
