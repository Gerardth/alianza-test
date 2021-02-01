package com.test.alianza;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import com.test.alianza.controller.ClientController;
import com.test.alianza.delegate.ClientDelegate;
import com.test.alianza.service.ClientService;

public class AlianzaApplicationTests {

	private ClientController clientController;
	private ClientDelegate clientDelegate;
	private ClientService clientService;
	
    @Before
    public void setup() {
    	clientController = mock(ClientController.class);
    	clientDelegate = mock(ClientDelegate.class);
    	clientService = mock(ClientService.class);
    }

	@Test
	public void contextLoads() {
		assertNotNull(clientController);
	}

	@Test
	public void delegateLoads() {
		assertNotNull(clientDelegate);
	}

	@Test
	public void serviceLoads() {
		assertNotNull(clientService);
	}

}
