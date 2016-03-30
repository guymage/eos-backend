package net.guymage.controller.race;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guymage.dao.race.RaceDAO;
import net.guymage.model.race.RaceEntity;

@RestController
public class RaceController {

	@Autowired
	RaceDAO raceDAO;

	@RequestMapping("/race")
	public Iterable<RaceEntity> findAll() {
		return raceDAO.findAll();
	}

}
