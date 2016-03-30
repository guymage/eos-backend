package net.guymage.dao.race;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.race.RaceEntity;

@Transactional
public interface RaceDAO extends CrudRepository<RaceEntity, Long> {

}
