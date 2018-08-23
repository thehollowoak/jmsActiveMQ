package com.javasampleapproach.jms.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.easymock.EasyMock.*;

import com.javasampleapproach.jms.consumer.JmsConsumer;
import com.javasampleapproach.jms.producer.JmsProducer;

public class WebControllerTest {
	
	JmsProducer mockProducer;
	JmsConsumer mockConsumer;
	
	WebController controller;
	
	@Before
	public void before() {
		controller = new WebController();
		mockProducer = mock(JmsProducer.class);
		mockConsumer = mock(JmsConsumer.class);
		controller.jmsProducer = mockProducer;
		controller.jmsConsumer = mockConsumer;
	}
	
	@After
	public void after() {
//		verify(mockProducer);
//		verify(mockConsumer);
	}
	
	@Test
	public void testProduce() {
		String testMsg = "test message";
		String response = controller.produce(testMsg);
		String expectedResponse = "Done";
		assertEquals(expectedResponse, response);
	}
	

}
