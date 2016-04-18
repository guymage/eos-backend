package net.guymage.model.map;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.guymage.model.joueur.JoueurEntity;
import net.guymage.model.map.observable.ArmeSiegeEntity;
import net.guymage.model.map.observable.BatimentEntity;
import net.guymage.model.map.observable.ChantierEntity;
import net.guymage.model.map.observable.DefenseEntity;
import net.guymage.model.map.observable.PnjEntity;
import net.guymage.model.map.observable.perso.PersonnageEntity;
import net.guymage.model.map.terrain.CaseEntity;
import net.guymage.model.map.terrain.TextureEntity;
import net.guymage.model.race.RaceEntity;

/**
 * Entité représentant une observation
 *
 * @author guymage
 */
@Entity
@Table(name="observation")
public class ObservationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "idroyaume")
	private Long idRoyaume;
	public static final String PROPERTYNAME_IDROYAUME = "idRoyaume";

	@OneToOne(optional=false)
	@JoinColumn(name = "idcase")
	private CaseEntity laCase;
	public static final String PROPERTYNAME_CASE = "laCase";

	@OneToOne(optional=false)
	@JoinColumn(name = "idtexture")
	private TextureEntity texture;
	public static final String PROPERTYNAME_TEXTURE = "texture";

	@OneToOne
	@JoinColumn(name = "idrace")
	private RaceEntity race;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idbatiment")
	private BatimentEntity batiment;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idpnj")
	private PnjEntity pnj;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idflag")
	private ChantierEntity chantier;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idarmesiege")
	private ArmeSiegeEntity armeSiege;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "iddefense")
	private DefenseEntity defense;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="joueurobs",
	joinColumns=@JoinColumn(name="idobservation"),
	inverseJoinColumns=@JoinColumn(name="idpersonnage"))
	private List<PersonnageEntity> personnages;

	@OneToOne
	@JoinColumn(name = "idobservateur")
	private JoueurEntity observateur;

	@Column(name="dateobservation")
	private Date dateObservation;

	private boolean obsolete;

	/*
	 * Getters & setters
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CaseEntity getLaCase() {
		return laCase;
	}

	public void setLaCase(CaseEntity laCase) {
		this.laCase = laCase;
	}

	public TextureEntity getTexture() {
		return texture;
	}

	public void setTexture(TextureEntity texture) {
		this.texture = texture;
	}

	public RaceEntity getRace() {
		return race;
	}

	public void setRace(RaceEntity race) {
		this.race = race;
	}

	public BatimentEntity getBatiment() {
		return batiment;
	}

	public void setBatiment(BatimentEntity batiment) {
		this.batiment = batiment;
	}

	public PnjEntity getPnj() {
		return pnj;
	}

	public void setPnj(PnjEntity pnj) {
		this.pnj = pnj;
	}

	public ChantierEntity getChantier() {
		return chantier;
	}

	public void setChantier(ChantierEntity chantier) {
		this.chantier = chantier;
	}

	public ArmeSiegeEntity getArmeSiege() {
		return armeSiege;
	}

	public void setArmeSiege(ArmeSiegeEntity armeSiege) {
		this.armeSiege = armeSiege;
	}

	public DefenseEntity getDefense() {
		return defense;
	}

	public void setDefense(DefenseEntity defense) {
		this.defense = defense;
	}

	public JoueurEntity getObservateur() {
		return observateur;
	}

	public void setObservateur(JoueurEntity observateur) {
		this.observateur = observateur;
	}

	public Date getDateObservation() {
		return dateObservation;
	}

	public void setDateObservation(Date dateObservation) {
		this.dateObservation = dateObservation;
	}

	public boolean isObsolete() {
		return obsolete;
	}

	public void setObsolete(boolean obsolete) {
		this.obsolete = obsolete;
	}

	public Long getIdRoyaume() {
		return idRoyaume;
	}

	public void setIdRoyaume(Long idRoyaume) {
		this.idRoyaume = idRoyaume;
	}

	public List<PersonnageEntity> getPersonnages() {
		return personnages;
	}

	public void setPersonnages(List<PersonnageEntity> personnages) {
		this.personnages = personnages;
	}

}
