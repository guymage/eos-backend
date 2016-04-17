package net.guymage.criteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class SearchSpecifications <T> {

	public static final String CARACT_AVEC_ACCENT	= "ÉÈÊËÀÁÂÄÇÌÍÎÏÑÓÒÔÖÚÙÛÜŸéèêëàáâäçìíîïñóòôöúùûüÿ";
	public static final String CARACT_SANS_ACCENT	= "EEEEAAAACIIIINOOOOUUUUYeeeeaaaaciiiinoooouuuuy";
	public static final String[] TRANSLATE_CHAR = { "'" + CARACT_AVEC_ACCENT +  "'", "'" + CARACT_SANS_ACCENT + "'" };

	/**
	 * Renvoie la spécification de la recherche.
	 * @param type de la recherche {@link SearchType}
	 * @param property propriétée
	 * @param contenu
	 * @return Specification
	 */
	public Specification<T> search(SearchType type, String property, String contenu) {
		switch (type) {
		case EGAL:
			return egal(property, contenu);
		case LIKE_IGNORECASE:
			return likeIgnoreCase(property, contenu);
		case LIKE:
			return like(property, contenu);
		default:
			throw new IllegalArgumentException("Recherche via '" + type + "' non supportée pour l'instant. Merci de l'implémenter.");
		}
	}

	/**
	 * Permet de faire une recherche sur le contenu d'un champ .
	 *
	 * @param property Le nom de la propriété dans l'objet. Permet de trouver le champ sur lequel filtré. Non null.
	 * @param contenu Le contenu à rechercher. Si null ou vide cette méthode retourne <code>null</code>.
	 */
	private Specification<T> likeIgnoreCase(final String property, final String contenu) {
		if (StringUtils.isNotBlank(contenu)) {
			return new Specification<T>() {
				@Override
				public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					return cb.like(ignoreAccent(cb, cb.upper(root.<String>get(property))),
							ignoreAccent(cb, cb.upper(cb.literal(StringUtils.replace(contenu,"*", "%"))))
							);
				}
			};
		}
		return null;
	}
	
	/**
	 * Permet de faire une recherche sur le contenu d'un champ en ignorant les accents et la casse.
	 *
	 * @param property Le nom de la propriété dans l'objet. Permet de trouver le champ sur lequel filtré. Non null.
	 * @param contenu Le contenu à rechercher. Si null ou vide cette méthode retourne <code>null</code>.
	 */
	private Specification<T> like(final String property, final String contenu) {
		if (StringUtils.isNotBlank(contenu)) {
			return new Specification<T>() {
				@Override
				public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					return cb.like(root.<String>get(property),
							cb.literal(StringUtils.replace(contenu,"*", "%"))
							);
				}
			};
		}
		return null;
	}

	/**
	 * Permet de faire une recherche exacte sur le contenu d'un champ (sert pour les identifiants ou les dates par exemple)
	 *
	 * @param property Le nom de la propriété dans l'objet. Permet de trouver le champ sur lequel filtré. Non null.
	 * @param contenu Le contenu à rechercher. Si null ou vide cette méthode retourne <code>null</code>.
	 */
	private Specification<T> egal(final String property, final String value) {
		if(StringUtils.isNotBlank(value)){
			return new Specification<T>() {
				@Override
				public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					return cb.equal(root.<String>get(property), value);
				}
			};
		}
		return null;
	}

	/**
	 * Permet d'avoir une {@link Expression} ignorant les accents.
	 */
	private static Expression<String> ignoreAccent(CriteriaBuilder cb, Expression<String> expression) {
		return translate(cb, expression, TRANSLATE_CHAR[0], TRANSLATE_CHAR[1]);
	}

	/**
	 * Permet d'utiliser la fonction SQL <code>translate</code>.
	 */
	private static Expression<String> translate(CriteriaBuilder cb, Expression<String> expression, String from, String to) {
		return cb.function("translate", String.class, expression, cb.literal(from), cb.literal(to));
	}
}

