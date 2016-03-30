package net.guymage.dao.map;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.map.ChantierEntity;

public interface ChantierDAO extends CrudRepository<ChantierEntity, Long> {

	ChantierEntity findById(Long id);

}
