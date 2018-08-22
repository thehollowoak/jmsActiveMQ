package com.javasampleapproach.jms.consumer;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;
import static org.easymock.EasyMock.*;

public class JmsConsumerTest {
	private String destinationQueue;	
	private JmsConsumer consumer;
	
	private JmsTemplate mockTemplate;
	
	@Before
	public void before() throws Exception {
		mockTemplate=createMock(JmsTemplate.class);
		consumer = new JmsConsumer();
		consumer.jmsTemplate = mockTemplate;
		destinationQueue = "test-queue";
	}
	
	@After
	public void after() throws Exception {
		verify(mockTemplate);
	}

	@Test
	public void testReceive() {
		String testMessage = "Test Message";
		expect(mockTemplate.receiveAndConvert(destinationQueue)).andReturn(testMessage);
		replay(mockTemplate);
		String response = consumer.receive(destinationQueue);
		assertEquals(testMessage, response);
	}

}
