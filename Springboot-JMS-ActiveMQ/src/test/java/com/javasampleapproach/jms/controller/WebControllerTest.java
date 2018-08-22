package com.javasampleapproach.jms.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.easymock.EasyMock.*;

import com.javasampleapproach.jms.client.JmsClient;

public class WebControllerTest {
	
	JmsClient mockClient;
	WebController controller;
	
	@Before
	public void before() {
		mockClient = createMock(JmsClient.class);
		controller = new WebController();
		controller.jmsClient = mockClient;
	}
	
	
	@Test
	public void testProduce() {
		String response = controller.produce("test message");
		assertEquals("Done", response);
	}


}
