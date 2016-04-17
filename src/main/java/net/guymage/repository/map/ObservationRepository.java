package net.guymage.repository.map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import net.guymage.model.map.ObservationEntity;

public interface ObservationRepository extends JpaRepository<ObservationEntity, Long>, JpaSpecificationExecutor<ObservationEntity> {

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
	//List<ObservationEntity> findByCoordonnees(int xMin, int xMax, int yMin, int yMax);

}
