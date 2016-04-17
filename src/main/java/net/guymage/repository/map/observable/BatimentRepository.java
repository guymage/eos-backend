package net.guymage.repository.map.observable;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.map.observable.BatimentEntity;

public interface BatimentRepository extends CrudRepository<BatimentEntity, Long> {

	BatimentEntity findById(Long id);

}
