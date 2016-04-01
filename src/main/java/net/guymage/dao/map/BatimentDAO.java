package net.guymage.dao.map;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.map.observable.BatimentEntity;

public interface BatimentDAO extends CrudRepository<BatimentEntity, Long> {

	BatimentEntity findById(Long id);

}
