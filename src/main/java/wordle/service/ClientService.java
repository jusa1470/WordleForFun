package wordle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wordle.exception.ClientNotFoundException;
import wordle.model.Client;
import wordle.repository.ClientRepo;

@Service
@Transactional
public class ClientService {
	private final ClientRepo clientRepo;
	
	@Autowired
	public ClientService(ClientRepo clientRepo) {
		this.clientRepo = clientRepo;
	}
	
	public Client addClient(Client client) {
		return clientRepo.save(client);
	}
	
	public Client findClientByUsername(String username) {
		return clientRepo.findClientByUsername(username).orElseThrow(() -> new ClientNotFoundException("Client with username " + username + " was not found."));
	}
}
