package net.guymage.repository.map.observable;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.map.observable.DefenseEntity;

public interface DefenseRepository extends CrudRepository<DefenseEntity, Long> {

	DefenseEntity findById(Long id);

}
