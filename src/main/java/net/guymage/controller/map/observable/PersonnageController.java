package net.guymage.controller.map.observable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.guymage.model.map.observable.perso.PersonnageEntity;
import net.guymage.repository.map.observable.PersonnageRepository;

@RestController
@RequestMapping("/pers")
public class PersonnageController {

	@Autowired
	private PersonnageRepository personnageDAO;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<PersonnageEntity> findAll() {
		return personnageDAO.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public PersonnageEntity findById(@PathVariable Long id) {
		return personnageDAO.findById(id);
	}

}
