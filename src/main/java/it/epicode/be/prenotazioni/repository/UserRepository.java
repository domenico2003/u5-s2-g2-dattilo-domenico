package it.epicode.be.prenotazioni.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.prenotazioni.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Page<User> findByNome(String nome, Pageable pageable);

	Optional<User> findByUsername(String nome);

}
