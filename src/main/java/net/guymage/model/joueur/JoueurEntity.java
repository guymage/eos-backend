package net.guymage.model.joueur;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import model.joueur.CodeHabilitation;
import net.guymage.model.race.RaceEntity;

/**
 * Entité représentant un joueur
 *
 * @author guymage
 */
@Entity
@Table(name = "joueur")
public class JoueurEntity implements Serializable {

	private static final long serialVersionUID = 1815873878335191078L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nom;

	@Column(name = "passwd")
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idrace")
	private RaceEntity race;

	@Column(name = "isactive")
	private Boolean active;

	@Column(name = "lastconnection")
	private Date lastConnection;

	private String mail;

	private Boolean invisible;

	@Column(name = "invisiblevalidite")
	private Date invisibleValidite;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="habilitation", joinColumns = @JoinColumn( name="idjoueur"))
	@Column(name = "habilitation")
	@Enumerated(EnumType.STRING)
	private List<CodeHabilitation> habilitations;

	/*
	 * getters & setters
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RaceEntity getRace() {
		return race;
	}

	public void setRace(RaceEntity race) {
		this.race = race;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(Date lastConnection) {
		this.lastConnection = lastConnection;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Boolean getInvisible() {
		return invisible;
	}

	public void setInvisible(Boolean invisible) {
		this.invisible = invisible;
	}

	public Date getInvisibleValidite() {
		return invisibleValidite;
	}

	public void setInvisibleValidite(Date invisibleValidite) {
		this.invisibleValidite = invisibleValidite;
	}

	public List<CodeHabilitation> getHabilitations() {
		return habilitations;
	}

	public void setHabilitations(List<CodeHabilitation> habilitations) {
		this.habilitations = habilitations;
	}

}
