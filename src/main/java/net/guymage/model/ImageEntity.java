package net.guymage.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entité représentant une image
 *
 * @author guymage
 */
@Entity
@Table(name="image")
public class ImageEntity {

	@Id
	private Long id;

	@NotNull
	private String nom;

	@NotNull
	private String path;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
