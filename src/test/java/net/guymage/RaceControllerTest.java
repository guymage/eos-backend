package net.guymage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.guymage.dao.race.RaceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EosBackendApplication.class)
public class RaceControllerTest {

	@Autowired
	RaceRepository raceRepository;

	@Before
	public void setUp() {
		// Nada
	}

	@Test
	public void testFindAll() {
		raceRepository.findAll();
	}

}
