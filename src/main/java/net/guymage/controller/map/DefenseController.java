package net.guymage.controller.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.guymage.dao.map.DefenseDAO;
import net.guymage.model.map.observable.DefenseEntity;

@RestController
@RequestMapping("/defense")
public class DefenseController {

	@Autowired
	private DefenseDAO defenseDAO;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<DefenseEntity> findAll() {
		return defenseDAO.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public DefenseEntity findById(@PathVariable Long id) {
		return defenseDAO.findById(id);
	}

}
