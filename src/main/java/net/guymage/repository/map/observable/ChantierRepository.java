package net.guymage.repository.map.observable;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.map.observable.ChantierEntity;

public interface ChantierRepository extends CrudRepository<ChantierEntity, Long> {

	ChantierEntity findById(Long id);

}
