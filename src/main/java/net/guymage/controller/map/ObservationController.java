package net.guymage.controller.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.guymage.criteria.map.ObservationCriteria;
import net.guymage.model.joueur.JoueurEntity;
import net.guymage.model.map.ObservationEntity;
import net.guymage.repository.map.ObservationRepository;
import net.guymage.util.EOSUtil;

@RestController
@RequestMapping("/observation")
public class ObservationController {

	@Autowired
	private ObservationRepository observationRepository;

	@Autowired
	private EOSUtil eosUtil;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<ObservationEntity> findByCoordonnees(
			@RequestParam("xMin") int xMin,
			@RequestParam("xMax") int xMax,
			@RequestParam("yMin") int yMin,
			@RequestParam("yMax") int yMax) {

		JoueurEntity je = eosUtil.getCurrentUser();
		ObservationCriteria criteria = new ObservationCriteria();
		criteria.setIdRoyaume(je.getRace().getId());
		criteria.setxMin(xMin);
		criteria.setxMax(xMax);
		criteria.setyMin(yMin);
		criteria.setyMax(yMax);

		Iterable<ObservationEntity> entities = observationRepository.findAll(criteria);

		return entities;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ObservationEntity findById(@PathVariable Long id) {
		return observationRepository.findById(id);
	}

}
