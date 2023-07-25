package wordle.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wordle.model.Client;
import wordle.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	private final ClientService clientService;
	
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping("/find/{username}")
	public ResponseEntity<Client> getClientByUsername(@PathVariable("username") String username) {
		Client client = clientService.findClientByUsername(username);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Client> addClient(@RequestBody Client client) {
		Client newClient = clientService.addClient(client);
		return new ResponseEntity<>(newClient, HttpStatus.CREATED);
	}
}
