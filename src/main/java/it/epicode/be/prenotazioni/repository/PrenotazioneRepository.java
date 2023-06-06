package it.epicode.be.prenotazioni.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.prenotazioni.model.Prenotazione;
import it.epicode.be.prenotazioni.model.User;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	public Page<Prenotazione> findByUserAndDataPrenotata(User user, LocalDate dataPrenotata, Pageable pageable);

	public Page<Prenotazione> findByUser(User user, Pageable pageable);

}
