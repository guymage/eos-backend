package net.guymage.repository.map.observable;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.map.observable.PnjEntity;

public interface PnjRepository extends CrudRepository<PnjEntity, Long> {

	PnjEntity findById(Long id);

}
