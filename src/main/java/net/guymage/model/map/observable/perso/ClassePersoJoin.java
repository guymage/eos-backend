package net.guymage.model.map.observable.perso;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Entité représentant le lien entre un personnage et une classe
 *
 * @author guymage
 */
@Embeddable
public class ClassePersoJoin implements Serializable{

	private static final long serialVersionUID = -7755362987427324088L;

	@OneToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name = "idclasse")
	private ClassePerso classePerso;

	@Column(name="dateobservation")
	private Date dateObservation;

	/*
	 * Getters & setters
	 */

	public ClassePerso getClassePerso() {
		return classePerso;
	}

	public void setClassePerso(ClassePerso classePerso) {
		this.classePerso = classePerso;
	}

	public Date getDateObservation() {
		return dateObservation;
	}

	public void setDateObservation(Date dateObservation) {
		this.dateObservation = dateObservation;
	}

}
