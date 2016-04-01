package net.guymage.model.map.observable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entité représentant un Pnj
 *
 * @author Guymage
 */
@Entity
@Table(name = "pnj")
public class PnjEntity {

	@Id
	private Long id;

	private String nom;

	@Column(name="image")
	private String imagePath;

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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
