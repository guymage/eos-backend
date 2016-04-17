package net.guymage.repository.race;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.race.RaceEntity;

@Transactional
public interface RaceRepository extends CrudRepository<RaceEntity, Long> {

	public RaceEntity findByNom(String nom);

}
