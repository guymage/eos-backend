package net.guymage.controller.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.guymage.dao.map.ChantierDAO;
import net.guymage.model.map.ChantierEntity;

@RestController
@RequestMapping("/chantier")
public class ChantierController {

	@Autowired
	private ChantierDAO chantierDAO;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<ChantierEntity> findAll() {
		return chantierDAO.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ChantierEntity findById(@PathVariable Long id) {
		return chantierDAO.findById(id);
	}

}
