package net.guymage.dao.map;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.guymage.model.map.ObservationEntity;

public interface ObservationRepository extends CrudRepository<ObservationEntity, Long> {

	/**
	 * Recherche une observation à partir de son id
	 *
	 * @param id de l'observation
	 * @return l'observation, <code>null</code> si no result
	 */
	ObservationEntity findById(Long id);

	/**
	 * Rercherche des observation à partir de leur coordonnées
	 *
	 * @param xMin
	 * @param xMax
	 * @param yMin
	 * @param yMax
	 * @return
	 */
	List<ObservationEntity> findByCoordonnees(int xMin, int xMax, int yMin, int yMax);

}
