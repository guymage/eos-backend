package net.guymage.controller.joueur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.guymage.model.joueur.JoueurEntity;
import net.guymage.repository.joueur.JoueurRepository;

@RestController
@RequestMapping("/joueur")
public class JoueurController {

	@Autowired
	private JoueurRepository joueurRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<JoueurEntity> findAll() {
		return joueurRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{nom}")
	public JoueurEntity findByNom(@PathVariable String nom) {
		return joueurRepository.findByNom(nom);
	}

}
