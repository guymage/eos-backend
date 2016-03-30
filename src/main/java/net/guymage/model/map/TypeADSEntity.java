package net.guymage.model.map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entité représentant un type d'arme de siège
 *
 * @author guymage
 */
@Entity
@Table(name = "typearmesiege")
public class TypeADSEntity {

	@Id
	private Long id;

	private String nom;

	/*
	 * Getters & setters
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
