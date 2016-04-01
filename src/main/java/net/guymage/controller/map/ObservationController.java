package net.guymage.controller.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.guymage.dao.map.ObservationRepository;
import net.guymage.model.map.ObservationEntity;

@RestController
@RequestMapping("/observation")
public class ObservationController {

	@Autowired
	private ObservationRepository observationRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<ObservationEntity> findByCoordonnees(
			@RequestParam("xMin") int xMin,
			@RequestParam("xMin") int xMax,
			@RequestParam("xMin") int yMin,
			@RequestParam("xMin") int yMax) {
		return observationRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ObservationEntity findById(@PathVariable Long id) {
		return observationRepository.findById(id);
	}

}
