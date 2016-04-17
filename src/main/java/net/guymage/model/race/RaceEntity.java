package net.guymage.model.race;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import model.race.Race;

/**
 * Entité représentant une race
 *
 * @author guymage
 *
 */
@Entity
@Table(name = "race")
public class RaceEntity {

	@Id
	private Long id;

	@NotNull
	private String nom;

	@Column(name = "descr", nullable = false)
	private String description;

	private Integer capitaleX;

	private Integer capitaleY;

	@NotNull
	private Integer colorR;

	@NotNull
	private Integer colorG;

	@NotNull
	private Integer colorB;

	/**
	 * @return Conversion en {@link Race}
	 */
	public Race toRace(){
		return Race.race()
				.withId(id)
				.withNom(nom)
				.withDescription(description)
				.withCapitaleX(capitaleX)
				.withCapitaleY(capitaleY)
				.withColorR(colorR)
				.withColorG(colorG)
				.withColorB(colorB)
				.build();
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String descr) {
		this.description = descr;
	}

	public Integer getCapitaleX() {
		return capitaleX;
	}

	public void setCapitaleX(Integer capitaleX) {
		this.capitaleX = capitaleX;
	}

	public Integer getCapitaleY() {
		return capitaleY;
	}

	public void setCapitaleY(Integer capitaleY) {
		this.capitaleY = capitaleY;
	}

	public Integer getColorR() {
		return colorR;
	}

	public void setColorR(Integer colorR) {
		this.colorR = colorR;
	}

	public Integer getColorG() {
		return colorG;
	}

	public void setColorG(Integer colorG) {
		this.colorG = colorG;
	}

	public Integer getColorB() {
		return colorB;
	}

	public void setColorB(Integer colorB) {
		this.colorB = colorB;
	}
}
