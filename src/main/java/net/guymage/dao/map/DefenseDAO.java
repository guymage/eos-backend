package net.guymage.dao.map;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.map.DefenseEntity;

public interface DefenseDAO extends CrudRepository<DefenseEntity, Long> {

	DefenseEntity findById(Long id);

}
