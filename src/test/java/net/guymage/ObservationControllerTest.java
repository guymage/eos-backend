package net.guymage;

import java.util.Date;

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
import net.guymage.model.map.terrain.CaseEntity;
import net.guymage.model.map.terrain.TextureEntity;
import net.guymage.model.race.RaceEntity;
import net.guymage.repository.joueur.JoueurRepository;
import net.guymage.repository.map.CaseRepository;
import net.guymage.repository.map.ObservationRepository;
import net.guymage.repository.map.TextureRepository;
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
		JoueurEntity joueur = joueurRepository.findOne(1L);
		TextureEntity texture1 = textureRepository.findOne(101L);
		RaceEntity royaume = raceRepository.findOne(1L);

		// Création observation
		ObservationEntity observationEntity = new ObservationEntity();
		observationEntity.setIdRoyaume(royaume.getId());
		observationEntity.setRace(royaume);
		observationEntity.setLaCase(case1);
		observationEntity.setObservateur(joueur);
		observationEntity.setTexture(texture1);
		observationEntity.setDateObservation(new Date());
		observationEntity = observationRepository.saveAndFlush(observationEntity);

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
		Assert.assertEquals(observationEntity.getId(), responseEntity.getBody()[0].getId());
	}


}
