package net.guymage.repository.map.observable;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.map.observable.ArmeSiegeEntity;

public interface ArmeSiegeRepository extends CrudRepository<ArmeSiegeEntity, Long> {

	ArmeSiegeEntity findById(Long id);

}
