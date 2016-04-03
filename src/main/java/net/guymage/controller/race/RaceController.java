package net.guymage.controller.race;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guymage.controller.EosEndPoints;
import net.guymage.dao.race.RaceRepository;
import net.guymage.model.race.RaceEntity;

@RestController
@RequestMapping(EosEndPoints.RACE)
public class RaceController {

	@Autowired
	RaceRepository raceRepository;

	public Iterable<RaceEntity> findAll() {
		return raceRepository.findAll();
	}

}
