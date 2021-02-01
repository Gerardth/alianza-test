package com.test.alianza;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.alianza.controller.ClientController;
import com.test.alianza.delegate.ClientDelegate;
import com.test.alianza.service.ClientService;

@SpringBootTest
class AlianzaApplicationTests {

	@Autowired
	private ClientController clientController;

	@Autowired
	private ClientDelegate clientDelegate;

	@Autowired
	private ClientService clientService;

	@Test
	void contextLoads() {
		assertThat(clientController).isNotNull();
	}

	@Test
	void delegateLoads() {
		assertThat(clientDelegate).isNotNull();
	}

	@Test
	void serviceLoads() {
		assertThat(clientService).isNotNull();
	}

}
