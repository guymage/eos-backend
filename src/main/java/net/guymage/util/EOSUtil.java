package net.guymage.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import exception.EosException;
import net.guymage.model.joueur.JoueurEntity;
import net.guymage.repository.joueur.JoueurRepository;

@Component
public class EOSUtil {

	@Autowired
	private JoueurRepository joueurRepository;

	public JoueurEntity getCurrentUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if(auth != null){
			return joueurRepository.findByNom(auth.getName());
		}

		throw new EosException("joueur connecté introuvable");
	}
}
