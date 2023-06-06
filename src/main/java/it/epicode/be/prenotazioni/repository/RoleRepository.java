package it.epicode.be.prenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.prenotazioni.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
