package com.test.alianza.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.test.alianza.dto.ClientDto;
import com.test.alianza.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	private static boolean initialize = false;
	private List<ClientDto> clientsList;

	private static final Logger logger = LogManager.getLogger(ClientServiceImpl.class);

	@Override
	public List<ClientDto> getListClients() {
		if (!initialize) {
			initializeData();
		}
		return clientsList;
	}

	@Override
	public List<ClientDto> getInfoClient(String search) {
		List<ClientDto> response = new ArrayList<>();
		if (search.equals("")) {
			response = getListClients();
			logger.log(Level.INFO, "shared key not sended");
		} else {
			ClientDto obj = clientsList.stream().filter(c -> c.getSharedKey().equals(search)).findFirst().orElse(null);

			if (Objects.nonNull(obj)) {
				response.add(obj);
				logger.log(Level.INFO, "data found for shared key %s", search);
			} else {
				logger.log(Level.INFO, "data not found for shared key %s", search);
			}
		}
		return response;
	}

	@Override
	public boolean createClient(ClientDto client) {
		clientsList.add(client);
		logger.log(Level.INFO, "Client with shared key {} created", client.getSharedKey());

		return true;
	}

	/**
	 * Method to initialize array of data
	 * @author grangel
	 */
	private void initializeData() {
		clientsList = new ArrayList<>();
		clientsList.add(new ClientDto("jgutierrez", "Juliana Gutierrez", "jgutierrez@gmail.com", 3219876543L,
				new Date(), new Date()));
		clientsList.add(new ClientDto("mmartinez", "Manuel Martinez", "mmartinez@gmail.com", 3219876543L, new Date(),
				new Date()));
		clientsList.add(new ClientDto("aruiz", "Ana Ruiz", "aruiz@gmail.com", 3219876543L, new Date(), new Date()));
		clientsList.add(
				new ClientDto("ogarcia", "Oscar Garcia", "ogarcia@gmail.com", 3219876543L, new Date(), new Date()));
		clientsList
				.add(new ClientDto("tramos", "Tania Ramos", "tramos@gmail.com", 3219876543L, new Date(), new Date()));

		logger.log(Level.INFO, "data initialized");

		initialize = true;
	}

}
