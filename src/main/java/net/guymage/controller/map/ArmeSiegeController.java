package net.guymage.controller.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.guymage.dao.map.ArmeSiegeDAO;
import net.guymage.model.map.observable.ArmeSiegeEntity;

@RestController
@RequestMapping("/ads")
public class ArmeSiegeController {

	@Autowired
	private ArmeSiegeDAO armeSiegeDAO;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<ArmeSiegeEntity> findAll() {
		return armeSiegeDAO.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ArmeSiegeEntity findById(@PathVariable Long id) {
		return armeSiegeDAO.findById(id);
	}

}
