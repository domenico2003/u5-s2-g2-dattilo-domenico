package it.epicode.be.prenotazioni.common.util;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.be.prenotazioni.model.Citta;
import it.epicode.be.prenotazioni.model.Edificio;
import it.epicode.be.prenotazioni.model.Postazione;
import it.epicode.be.prenotazioni.model.Role;
import it.epicode.be.prenotazioni.model.RoleType;
import it.epicode.be.prenotazioni.model.TipoPostazione;
import it.epicode.be.prenotazioni.model.User;
import it.epicode.be.prenotazioni.repository.CittaRepository;
import it.epicode.be.prenotazioni.repository.EdificioRepository;
import it.epicode.be.prenotazioni.repository.PostazioneRepository;
import it.epicode.be.prenotazioni.repository.RoleRepository;
import it.epicode.be.prenotazioni.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AppStartupRunner implements CommandLineRunner {

	@Autowired
	CittaRepository cittaRepository;

	@Autowired
	EdificioRepository edificioRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PostazioneRepository postazioneRepository;

	@Override
	public void run(String... args) throws Exception {

	}

	private List<Role> initRole() {

		Role role = new Role();
		role.setRoleType(RoleType.ROLE_ADMIN);
		roleRepository.save(role);

		role.setRoleType(RoleType.ROLE_USER);

		return null;
	}

	private List<Postazione> initPostazione(List<Edificio> edificioList) {

		Postazione post = new Postazione();

		post.setTipo(TipoPostazione.PRIVATO);
		postazioneRepository.save(post);

		return null;

	}

	private User initUser(List<Role> roles) {
		User user = new User();

		user.setRoles(new HashSet<Role>(roles));
		userRepository.save(user);

		return user;
	}

	private List<Edificio> initEdificio(Citta initCitta) {

		Edificio edificio = new Edificio();

		edificioRepository.save(edificio);

		return null;

	}

	private Citta initCitta() {
		Citta citta = new Citta();

		cittaRepository.save(citta);

		return citta;

	}
}