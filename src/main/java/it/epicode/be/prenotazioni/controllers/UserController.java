package it.epicode.be.prenotazioni.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.prenotazioni.exceptions.LanguageException;
import it.epicode.be.prenotazioni.model.Postazione;
import it.epicode.be.prenotazioni.service.PrenotazioniService;

@RestController
@RequestMapping("/esercizi")
public class UserController {
	@Autowired
	PrenotazioniService ps;

	@GetMapping("/infoprenotazioni")
	@ResponseStatus(HttpStatus.OK)
	public String getinfo(@RequestParam String lingua) {

		if (lingua.contains("italiano")) {
			return "per effettuare la prenotazione inserire l'utente, la postazione desiderata ,la data prenotata e ladata di prenotazione";
		} else if (lingua.contains("inglese")) {
			return "to make a reservation enter the user, the desired station, the date booked and the date of booking";
		} else {
			throw new LanguageException(lingua);
		}

	}

	@GetMapping("/prenotazioni")
	@ResponseStatus(HttpStatus.OK)
	public List<Postazione> cercaPrenotazioni(@RequestParam String città, @RequestParam String tipopostazione)
			throws Exception {
		return ps.getByTipoAndCitta(tipopostazione, città);
	}
}
