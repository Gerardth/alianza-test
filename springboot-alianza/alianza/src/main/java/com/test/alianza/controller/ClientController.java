package com.test.alianza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.alianza.delegate.ClientDelegate;
import com.test.alianza.dto.ClientDto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientDelegate clientDelegate;

	/**
	 * Method to get clients list
	 * @return List<ClientDto>
	 * @author grangel
	 */
	@GetMapping(value = "/list-clients")
	@ApiOperation(value = "Get list of clients", notes = "Get list of clients")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfull request"),
			@ApiResponse(code = 400, message = "Bad request", response = String.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = String.class) })
	public ResponseEntity<List<ClientDto>> getListClients() {
		return ResponseEntity.status(HttpStatus.OK).body(clientDelegate.getListClients());
	}

	/**
	 * Method to get info of a client
	 * @param search String
	 * @return List<ClientDto>
	 * @author grangel
	 */
	@GetMapping(value = "/info-client")
	@ApiOperation(value = "Get info of a client", notes = "Get info of a client")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfull request"),
			@ApiResponse(code = 400, message = "Bad request", response = String.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = String.class) })
	public ResponseEntity<List<ClientDto>> getInfoClient(
			@RequestParam(value = "search", defaultValue = "") String search) {
		return ResponseEntity.status(HttpStatus.OK).body(clientDelegate.getInfoClient(search));
	}

	/**
	 * Method to create a client
	 * @param client ClientDto
	 * @return Boolean
	 * @author grangel
	 */
	@PostMapping(value = "/create-client")
	@ApiOperation(value = "Create a client", notes = "Create a client")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfull request"),
			@ApiResponse(code = 400, message = "Bad request", response = String.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = String.class) })
	public ResponseEntity<Boolean> createClient(@RequestBody ClientDto client) {
		return ResponseEntity.status(HttpStatus.OK).body(clientDelegate.createClient(client));
	}

}
