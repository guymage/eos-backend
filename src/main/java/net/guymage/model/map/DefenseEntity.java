package net.guymage.model.map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.guymage.model.ImageEntity;
import net.guymage.model.race.RaceEntity;

/**
 * Entité représentant une défense
 *
 * @author Guymage
 */
@Entity
@Table(name = "defense")
public class DefenseEntity {

	@Id
	private Long id;

	private int hp;

	@OneToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name = "idrace")
	private RaceEntity race;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idimage")
	private ImageEntity image;

	/*
	 * Getters & setters
	 */

	public int getHp() {
		return hp;
	}

	public void setHp(final int hp) {
		this.hp = hp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RaceEntity getRace() {
		return race;
	}

	public void setRace(RaceEntity race) {
		this.race = race;
	}

	public ImageEntity getImage() {
		return image;
	}

	public void setImage(ImageEntity image) {
		this.image = image;
	}

}
