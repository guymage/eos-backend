package net.guymage.controller.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.guymage.dao.map.BatimentDAO;
import net.guymage.model.map.BatimentEntity;

@RestController
@RequestMapping("/batiment")
public class BatimentController {

	@Autowired
	private BatimentDAO batimentDAO;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<BatimentEntity> findAll() {
		return batimentDAO.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public BatimentEntity findById(@PathVariable Long id) {
		return batimentDAO.findById(id);
	}

}
