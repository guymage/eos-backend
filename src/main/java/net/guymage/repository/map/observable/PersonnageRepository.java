package net.guymage.repository.map.observable;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.map.observable.perso.PersonnageEntity;

public interface PersonnageRepository extends CrudRepository<PersonnageEntity, Long> {

	PersonnageEntity findById(Long id);

}
