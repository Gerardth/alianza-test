package com.test.alianza.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.test.alianza.dto.ClientDto;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    private ClientService clientService;
    
    @Before
    public void setup() {
    	clientService = mock(ClientService.class);
    }
    
	@Test
	public void shouldReturnClientList() {
		ClientDto juliana = new ClientDto("jgutierrez", "Juliana Gutierrez", "jgutierrez@gmail.com", 3219876543L,
				new Date(), new Date());
		ClientDto manuel = new ClientDto("mmartinez", "Manuel Martinez", "mmartinez@gmail.com", 3219876543L, new Date(),
				new Date());
		ClientDto ana = new ClientDto("aruiz", "Ana Ruiz", "aruiz@gmail.com", 3219876543L, new Date(), new Date());
		ClientDto oscar = new ClientDto("ogarcia", "Oscar Garcia", "ogarcia@gmail.com", 3219876543L, new Date(), new Date());
		ClientDto tania = new ClientDto("tramos", "Tania Ramos", "tramos@gmail.com", 3219876543L, new Date(), new Date());
		
		List<ClientDto> originalClientsList = Arrays.asList(juliana, manuel, ana, oscar, tania);
		
		when(clientService.getListClients()).thenReturn(originalClientsList);

		List<ClientDto> returnTest = clientService.getListClients();
		
		assertEquals(returnTest, originalClientsList);
	}
	
	@Test
	public void shouldGetClientInfo() {
		String sharedKey = "ogarcia";
		clientService.getListClients();

		List<ClientDto> originalClientInfo = Arrays.asList(new ClientDto("ogarcia", "Oscar Garcia", "ogarcia@gmail.com", 3219876543L, new Date(), new Date()));
		
		when(clientService.getInfoClient(sharedKey)).thenReturn(originalClientInfo);
		
		List<ClientDto> clientsFound = clientService.getInfoClient(sharedKey);
		assertEquals(clientsFound, originalClientInfo);
	}
	
	@Test
	public void shouldCreateClient() {
		clientService.getListClients();
		ClientDto test = new ClientDto("a", "juan ramirez", "a@a.com", 3000000000L, new Date(), new Date());
		when(clientService.createClient(test)).thenReturn(true);

		boolean creation = clientService.createClient(test);
		
		assertTrue(creation);
	}

}
