package wordle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import wordle.model.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {
	Optional<Client> findClientByUsername(String username);
}
