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

import net.guymage.api.model.race.Race;
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

	@Before
	public void setUp() {
	}

	@Test
	public void testFindAll() {

		ResponseEntity<Race[]> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/race", Race[].class);

		Assert.assertNotNull(responseEntity);
		Assert.assertNotNull(responseEntity.getBody());
		Assert.assertEquals(12, responseEntity.getBody().length);
	}

	@Test
	public void testFindOne() {

		ResponseEntity<Race> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/race/troll", Race.class);

		Assert.assertNotNull(responseEntity);
		Assert.assertNotNull(responseEntity.getBody());
		Assert.assertEquals("Troll", responseEntity.getBody().getDescription());
	}

}
