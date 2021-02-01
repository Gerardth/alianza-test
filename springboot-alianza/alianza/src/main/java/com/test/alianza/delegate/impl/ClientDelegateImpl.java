package com.test.alianza.delegate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.alianza.delegate.ClientDelegate;
import com.test.alianza.dto.ClientDto;
import com.test.alianza.service.ClientService;

@Service
public class ClientDelegateImpl implements ClientDelegate {

	@Autowired
	private ClientService clientService;

	@Override
	public List<ClientDto> getListClients() {
		return clientService.getListClients();
	}

	@Override
	public List<ClientDto> getInfoClient(String search) {
		return clientService.getInfoClient(search);
	}

	@Override
	public boolean createClient(ClientDto client) {
		return clientService.createClient(client);
	}

}
