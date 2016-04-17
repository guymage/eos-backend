package net.guymage;

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

import model.race.Race;
import net.guymage.model.race.RaceEntity;
import net.guymage.repository.race.RaceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EosBackendApplication.class)
@WebIntegrationTest()
public class RaceControllerTest {

	@Autowired
	RaceRepository raceRepository;

	// This will hold the port number the server was started on
	@Value("${local.server.port}")
	int port;

	private final RestTemplate restTemplate = new TestRestTemplate("Test", "password");

	private RaceEntity raceEdb;

	@Before
	public void setUp() {
		raceEdb = new RaceEntity();
		raceEdb.setNom("edb");
		raceEdb.setDescription("Elfe des bois");
		raceEdb.setId(2L);
		raceEdb.setColorR(1);
		raceEdb.setColorG(3);
		raceEdb.setColorB(5);
		raceEdb.setCapitaleX(23);
		raceEdb.setCapitaleY(45);

		raceRepository.save(raceEdb);
	}

	@Test
	public void testFindAll() {

		ResponseEntity<Race[]> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/race", Race[].class);

		Assert.assertNotNull(responseEntity);
		Assert.assertNotNull(responseEntity.getBody());
		Assert.assertEquals(3, responseEntity.getBody().length);
	}

	@Test
	public void testFindOne() {

		ResponseEntity<Race> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/race/"+raceEdb.getNom(), Race.class);

		Assert.assertNotNull(responseEntity);
		Assert.assertNotNull(responseEntity.getBody());
		Assert.assertEquals(raceEdb.getId(), responseEntity.getBody().getId());
	}

}
