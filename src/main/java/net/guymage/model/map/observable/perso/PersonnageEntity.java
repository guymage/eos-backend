package net.guymage.model.map.observable.perso;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.guymage.model.joueur.JoueurEntity;

/**
 * Classe représentant un personnage sur la carte
 *
 * @author Guymage
 */
@Entity
@Table(name="t_personnage")
public class PersonnageEntity  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="idroyaume")
	private Long idRoyaume;

	@OneToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name = "idjoueur")
	private JoueurEntity joueur;

	@ElementCollection(targetClass = ClassePersoJoin.class, fetch = FetchType.EAGER)
	@CollectionTable(name="t_classepersonnage", joinColumns = @JoinColumn( name="idpersonnage"))
	private List<ClassePersoJoin> listeClasses;

	@Column(name="level")
	private String compLevel;

	@Column(name="melee")
	private String compMelee;

	@Column(name="distance")
	private String compDistance;

	@Column(name="esquive")
	private String compEsquive;

	@Column(name="blocage")
	private String compBlocage;

	@Column(name="incantation")
	private String compIncantation;

	@Column(name="magievie")
	private String compMagieVie;

	@Column(name="magieelem")
	private String compMagieElem;

	@Column(name="magiemort")
	private String compMagieMort;

	private boolean dead;

	@Column(name="datedeath")
	private Date dateDeath;


	/*
	 * Getters & setters
	 */

	/**
	 * @return true si le personnage est mort, false sinon.
	 */
	public boolean isDead() {
		return dead;
	}

	public void setDead(final boolean dead) {
		this.dead = dead;
	}


	/**
	 * @return (facultatif) le niveau du joueur
	 */
	public String getCompLevel() {
		return compLevel;
	}

	public void setCompLevel(String compLevel) {
		this.compLevel = compLevel;
	}

	/**
	 * @return (facultatif) la niveau de mêlée du joueur
	 */
	public String getCompMelee() {
		return compMelee;
	}

	public void setCompMelee(String compMelee) {
		this.compMelee = compMelee;
	}

	/**
	 * @return (facultatif) le niveau de distance  du joueur
	 */
	public String getCompDistance() {
		return compDistance;
	}

	public void setCompDistance(String compDistance) {
		this.compDistance = compDistance;
	}

	/**
	 * @return (facultatif) le niveau d'esquive du joueur
	 */
	public String getCompEsquive() {
		return compEsquive;
	}

	public void setCompEsquive(String compEsquive) {
		this.compEsquive = compEsquive;
	}

	/**
	 * @return (facultatif) le niveau de blocage du joueur
	 */
	public String getCompBlocage() {
		return compBlocage;
	}

	public void setCompBlocage(String compBlocage) {
		this.compBlocage = compBlocage;
	}

	/**
	 * @return (facultatif) le niveau d'incantation du joueur
	 */
	public String getCompIncantation() {
		return compIncantation;
	}

	public void setCompIncantation(String compIncantation) {
		this.compIncantation = compIncantation;
	}

	/**
	 * @return (facultatif) le niveau de magie de la vie du joueur
	 */
	public String getCompMagieVie() {
		return compMagieVie;
	}

	public void setCompMagieVie(String compMagieVie) {
		this.compMagieVie = compMagieVie;
	}

	/**
	 * @return (facultatif) le niveau de magie élémentaire du joueur
	 */
	public String getCompMagieElem() {
		return compMagieElem;
	}

	public void setCompMagieElem(String compMagieElem) {
		this.compMagieElem = compMagieElem;
	}

	/**
	 * @return (facultatif) le niveau de magie de la mort du joueur
	 */
	public String getCompMagieMort() {
		return compMagieMort;
	}

	public void setCompMagieMort(String compMagieMort) {
		this.compMagieMort = compMagieMort;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdRoyaume() {
		return idRoyaume;
	}

	public void setIdRoyaume(Long idRoyaume) {
		this.idRoyaume = idRoyaume;
	}

	public JoueurEntity getJoueur() {
		return joueur;
	}

	public void setJoueur(JoueurEntity joueur) {
		this.joueur = joueur;
	}

	public List<ClassePersoJoin> getListeClasses() {
		return listeClasses;
	}

	public void setListeClasses(List<ClassePersoJoin> listeClasses) {
		this.listeClasses = listeClasses;
	}

	public Date getDateDeath() {
		return dateDeath;
	}

	public void setDateDeath(Date dateDeath) {
		this.dateDeath = dateDeath;
	}


}
