package net.guymage.model.map.observable;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.guymage.model.race.RaceEntity;

/**
 * Entité représentant un chantier
 *
 * @author Guymage
 */
@Entity
// TODO renommer la table en chantier
@Table(name = "flag")
public class ChantierEntity {

	@Id
	private Long id;

	// TODO disponible ?
	//private int hp;

	@OneToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name = "idrace")
	private RaceEntity race;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idimage")
	private ImageEntity image;

	// TODO Migrer les données
	//	@Enumerated(EnumType.STRING)
	//	private CodeTypeChantier typeChantier;

	@Column(name="datefin")
	private Date dateFin;

	/*
	 * Getters & setters
	 */

	//	public int getHp() {
	//		return hp;
	//	}
	//
	//	public void setHp(final int hp) {
	//		this.hp = hp;
	//	}

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

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
