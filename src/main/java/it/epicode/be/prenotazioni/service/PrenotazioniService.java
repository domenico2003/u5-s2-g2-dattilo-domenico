package it.epicode.be.prenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.prenotazioni.model.Citta;
import it.epicode.be.prenotazioni.model.Postazione;
import it.epicode.be.prenotazioni.model.TipoPostazione;
import it.epicode.be.prenotazioni.repository.CittaRepository;
import it.epicode.be.prenotazioni.repository.PostazioneRepository;

@Service
public class PrenotazioniService {
	@Autowired
	PostazioneRepository pr;

	@Autowired
	CittaRepository cr;

	public List<Postazione> getByTipoAndCitta(String tp, String citta) throws Exception {
		Citta city = findCittaById(citta);
		List<Postazione> postazioni = pr.findByEdificioCittaAndTipo(city, TipoPostazione.valueOf(tp));
		return postazioni;
	}

	public Citta findCittaById(String id) throws Exception {

		if (cr.findById(Long.parseLong(id)).isPresent()) {
			return cr.findById(Long.parseLong(id)).get();
		} else {
			throw new Exception("citta non trovata");
		}

	}
}
