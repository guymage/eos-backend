package net.guymage.dao.joueur;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.joueur.JoueurEntity;

public interface JoueurRepository extends CrudRepository<JoueurEntity, Long> {

	JoueurEntity findByNom(String nom);

}
