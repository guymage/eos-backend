package net.guymage.model.map.terrain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe représentant une case de la carte
 *
 * @author Guymage
 */
@Entity
@Table(name="t_case")
public class CaseEntity {

	@Id
	private Long id;

	private int x;

	private int y;

	@Column(name="dateconquete")
	private Date dateConquete;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idnature")
	private NatureTerrainEntity natureTerrain;

	/*
	 * Getters & setters
	 */

	/**
	 * @return Id de la case
	 */
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @return La position X de la case
	 */
	public int getX() {
		return x;
	}

	public void setX(final int x) {
		this.x = x;
	}

	/**
	 * @return La position Y de la case
	 */
	public int getY() {
		return y;
	}

	public void setY(final int y) {
		this.y = y;
	}

	public Date getDateConquete() {
		return dateConquete;
	}

	public void setDateConquete(Date dateConquete) {
		this.dateConquete = dateConquete;
	}

	public NatureTerrainEntity getNatureTerrain() {
		return natureTerrain;
	}

	public void setNatureTerrain(NatureTerrainEntity natureTerrain) {
		this.natureTerrain = natureTerrain;
	}

}
