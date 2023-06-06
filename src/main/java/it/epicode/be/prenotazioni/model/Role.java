package it.epicode.be.prenotazioni.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "auth_roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auth_roles_generator")
	@SequenceGenerator(name = "auth_roles_generator", sequenceName = "auth_roles_seq")
	private Long id;

	@Enumerated(EnumType.STRING)
	private RoleType roleType;

}