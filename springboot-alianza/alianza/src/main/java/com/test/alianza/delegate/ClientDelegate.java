package com.test.alianza.delegate;

import java.util.List;

import com.test.alianza.dto.ClientDto;

public interface ClientDelegate {

	/**
	 * Method to get clients list
	 * 
	 * @return List<ClientDto>
	 * @author grangel
	 */
	public List<ClientDto> getListClients();

	/**
	 * Method to get info of a client
	 * 
	 * @param search String
	 * @return List<ClientDto>
	 * @author grangel
	 */
	public List<ClientDto> getInfoClient(String search);

	/**
	 * Method to create a client
	 * 
	 * @param client ClientDto
	 * @return Boolean
	 * @author grangel
	 */
	public boolean createClient(ClientDto client);
}
