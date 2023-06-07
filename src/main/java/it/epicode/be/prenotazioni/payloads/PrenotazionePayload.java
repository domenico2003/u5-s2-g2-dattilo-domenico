package it.epicode.be.prenotazioni.payloads;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class PrenotazionePayload {

	long idUtente;
	long idPostazione;
	LocalDate dataPrenotata;
}
