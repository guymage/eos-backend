package net.guymage.model.map.observable.perso;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe d'un personnage
 *
 * @author guymage
 */
@Entity
@Table(name="classe")
public final class ClassePerso {

	@Id
	private Long id;

	private String nom;

	private String path;

	/*
	 * Getters & setters
	 */

	/**
	 * @return Nom de la classe.
	 */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return Id de la classe.
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Path de l'image de la classe.
	 */
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
