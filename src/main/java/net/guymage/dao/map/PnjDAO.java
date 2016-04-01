package net.guymage.dao.map;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.map.observable.PnjEntity;

public interface PnjDAO extends CrudRepository<PnjEntity, Long> {

	PnjEntity findById(Long id);

}
