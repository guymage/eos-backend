package net.guymage.dao.map;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.map.observable.ArmeSiegeEntity;

public interface ArmeSiegeDAO extends CrudRepository<ArmeSiegeEntity, Long> {

	ArmeSiegeEntity findById(Long id);

}
