package net.guymage.controller.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.guymage.dao.map.PnjDAO;
import net.guymage.model.map.observable.PnjEntity;

@RestController
@RequestMapping("/pnj")
public class PnjController {

	@Autowired
	private PnjDAO pnjDAO;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<PnjEntity> findAll() {
		return pnjDAO.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public PnjEntity findById(@PathVariable Long id) {
		return pnjDAO.findById(id);
	}

}
