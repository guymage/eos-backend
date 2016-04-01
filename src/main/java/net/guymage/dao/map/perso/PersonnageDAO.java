package net.guymage.dao.map.perso;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.map.observable.perso.PersonnageEntity;

public interface PersonnageDAO extends CrudRepository<PersonnageEntity, Long> {

	PersonnageEntity findById(Long id);

}
