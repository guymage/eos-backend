package net.guymage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import net.guymage.model.joueur.JoueurEntity;
import net.guymage.model.map.ObservationEntity;
import net.guymage.model.map.observable.perso.PersonnageEntity;
import net.guymage.model.map.terrain.CaseEntity;
import net.guymage.model.map.terrain.TextureEntity;
import net.guymage.model.race.RaceEntity;
import net.guymage.repository.joueur.JoueurRepository;
import net.guymage.repository.map.ObservationRepository;
import net.guymage.repository.map.terrain.CaseRepository;
import net.guymage.repository.map.terrain.TextureRepository;
import net.guymage.repository.race.RaceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EosBackendApplication.class)
@WebIntegrationTest()
public class ObservationControllerTest {

	@Autowired
	private ObservationRepository observationRepository;

	@Autowired
	private JoueurRepository joueurRepository;

	@Autowired
	private CaseRepository caseRepository;

	@Autowired
	private TextureRepository textureRepository;

	@Autowired
	private RaceRepository raceRepository;

	// This will hold the port number the server was started on
	@Value("${local.server.port}")
	int port;

	private final RestTemplate restTemplate = new TestRestTemplate("Test", "password");

	@Before
	public void setUp() {
	}

	@Test
	public void testFindByCoordonnees() {

		/*
		 * Contexte
		 */
		CaseEntity case1 = caseRepository.findOne(1L);
		CaseEntity case2 = caseRepository.findOne(2L);
		JoueurEntity joueur = joueurRepository.findOne(1L);
		TextureEntity texture1 = textureRepository.findOne(101L);
		RaceEntity royaume = raceRepository.findOne(1L);

		// Création observation 1
		RaceEntity raceTroll = raceRepository.findByNom("troll");
		JoueurEntity joueurTroll = createAndSaveJoueur(raceTroll);
		PersonnageEntity persoTroll = createPerso(royaume.getId(), joueurTroll, joueur);

		createAndSaveObservation(royaume.getId(), royaume, case2, joueur, texture1,
				persoTroll);

		// Création observation 2
		RaceEntity raceEdb = raceRepository.findByNom("elfebois");
		JoueurEntity joueurEdb = createAndSaveJoueur(raceEdb);
		PersonnageEntity persoEdb = createPerso(royaume.getId(), joueurEdb, joueur);

		RaceEntity raceScav = raceRepository.findByNom("scavenger");
		JoueurEntity joueurScav = createAndSaveJoueur(raceScav);
		PersonnageEntity persoScav = createPerso(royaume.getId(), joueurScav, joueur);

		ObservationEntity obs2 = createAndSaveObservation(royaume.getId(), royaume, case1, joueur, texture1,
				persoEdb, persoScav);

		/*
		 * Appel
		 */
		String url = "http://localhost:" + port + "/observation?xMin=1&xMax=1&yMin=1&yMax=1";
		ResponseEntity<ObservationEntity[]> responseEntity = restTemplate.getForEntity(url, ObservationEntity[].class);

		/*
		 * Vérifs
		 */
		Assert.assertNotNull(responseEntity);
		Assert.assertNotNull(responseEntity.getBody());
		Assert.assertEquals(1, responseEntity.getBody().length);
		Assert.assertEquals(obs2.getId(), responseEntity.getBody()[0].getId());
		Assert.assertEquals(2, responseEntity.getBody()[0].getPersonnages().size());
	}

	private JoueurEntity createAndSaveJoueur(RaceEntity race) {
		JoueurEntity joueur = new JoueurEntity();
		joueur.setRace(race);
		joueur.setNom("un_" + race.getNom());
		joueur.setActive(true);
		joueur.setInvisible(false);
		return joueurRepository.save(joueur);
	}

	private PersonnageEntity createPerso(Long idRoyaume, JoueurEntity joueur, JoueurEntity updater) {
		PersonnageEntity perso = new PersonnageEntity();
		perso.setJoueur(joueur);
		perso.setIdRoyaume(idRoyaume);
		perso.setUpdated(new Date());
		perso.setUpdatedBy(updater);
		return perso;
	}

	private ObservationEntity createAndSaveObservation(Long idRoyaume, RaceEntity race, CaseEntity laCase,
			JoueurEntity joueur, TextureEntity texture, PersonnageEntity... personnages) {
		ObservationEntity observationEntity = new ObservationEntity();
		observationEntity.setIdRoyaume(idRoyaume);
		observationEntity.setRace(race);
		observationEntity.setLaCase(laCase);
		observationEntity.setObservateur(joueur);
		observationEntity.setTexture(texture);
		observationEntity.setDateObservation(new Date());

		if (personnages != null && personnages.length > 0) {
			List<PersonnageEntity> persos = new ArrayList<>();
			for (PersonnageEntity pers : personnages) {
				persos.add(pers);
			}
			observationEntity.setPersonnages(persos);
		}

		return observationRepository.saveAndFlush(observationEntity);
	}

}
