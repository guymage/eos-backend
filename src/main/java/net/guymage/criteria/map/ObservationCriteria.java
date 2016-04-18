package net.guymage.criteria.map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import net.guymage.criteria.SearchSpecifications;
import net.guymage.criteria.SearchType;
import net.guymage.model.map.ObservationEntity;
import net.guymage.model.map.terrain.CaseEntity;

public class ObservationCriteria implements Specification<ObservationEntity>{

	private Integer xMin;

	private Integer xMax;

	private Integer yMin;

	private Integer yMax;

	private Long idRoyaume;

	@Override
	public Predicate toPredicate(Root<ObservationEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		SearchSpecifications<ObservationEntity> spObs = new SearchSpecifications<>();

		// Id royaume
		Specifications<ObservationEntity> specIdRoyaume = Specifications
				.where(spObs.search(SearchType.EGAL, ObservationEntity.PROPERTYNAME_IDROYAUME, idRoyaume != null ? idRoyaume.toString() : null));
		Predicate prIdRoyaume = specIdRoyaume.toPredicate(root, query, cb);

		Predicate pred = cb.and(prIdRoyaume);

		Join<ObservationEntity, CaseEntity> joinCase = root.join(ObservationEntity.PROPERTYNAME_CASE);
		// xMin
		if(xMin != null){
			Predicate prXMin = cb.greaterThanOrEqualTo(joinCase.<String>get(CaseEntity.PROPERTYNAME_X), xMin.toString());
			pred = cb.and(pred, prXMin);
		}

		// xMax
		if(xMax != null){
			Predicate prXMin = cb.lessThanOrEqualTo(joinCase.<String>get(CaseEntity.PROPERTYNAME_X), xMax.toString());
			pred = cb.and(pred, prXMin);
		}

		// yMin
		if(yMin != null){
			Predicate prXMin = cb.greaterThanOrEqualTo(joinCase.<String>get(CaseEntity.PROPERTYNAME_Y), yMin.toString());
			pred = cb.and(pred, prXMin);
		}

		// yMax
		if(yMax != null){
			Predicate prXMin = cb.lessThanOrEqualTo(joinCase.<String>get(CaseEntity.PROPERTYNAME_Y), yMax.toString());
			pred = cb.and(pred, prXMin);
		}

		// Optimisation de la requête afin d'obtenir des inner join plutôt que des requêtes N+1
		root.fetch(ObservationEntity.PROPERTYNAME_TEXTURE, JoinType.INNER);
		root.fetch(ObservationEntity.PROPERTYNAME_CASE, JoinType.INNER);

		return pred;

	}

	public Integer getxMin() {
		return xMin;
	}

	public void setxMin(Integer xMin) {
		this.xMin = xMin;
	}

	public Integer getxMax() {
		return xMax;
	}

	public void setxMax(Integer xMax) {
		this.xMax = xMax;
	}

	public Integer getyMin() {
		return yMin;
	}

	public void setyMin(Integer yMin) {
		this.yMin = yMin;
	}

	public Integer getyMax() {
		return yMax;
	}

	public void setyMax(Integer yMax) {
		this.yMax = yMax;
	}

	public Long getIdRoyaume() {
		return idRoyaume;
	}

	public void setIdRoyaume(Long idRoyaume) {
		this.idRoyaume = idRoyaume;
	}

	/*
	 * Getters & setters
	 */

}
