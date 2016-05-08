package net.guymage.controller.race;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.guymage.api.model.race.Race;
import net.guymage.controller.EosEndPoints;
import net.guymage.model.race.RaceEntity;
import net.guymage.repository.race.RaceRepository;

@RestController
@RequestMapping(EosEndPoints.RACE)
public class RaceController {

	@Autowired
	RaceRepository raceRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Race> findAll() {
		Iterable<RaceEntity> entities = raceRepository.findAll();

		List<Race> convertis = new ArrayList<>();
		for(RaceEntity entity : entities){
			convertis.add(entity.toRace());
		}

		return convertis;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{nom}")
	public Race findByNom(@PathVariable String nom) {
		RaceEntity entity = raceRepository.findByNom(nom);
		if(entity != null){
			return entity.toRace();
		}
		else return null;
	}

}
