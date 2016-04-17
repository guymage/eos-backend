package net.guymage.criteria;

/**
 * 
 * Type possible pour les recherche.
 * LIKE_IGNORECASE: ignore les majuscule/minuscule et les accents. permet d'utiliser le joker *
 * EGAL: sensible à la casse et ne permet pas d'utiliser le joker *.
 */
public enum SearchType {
	EGAL,
	LIKE_IGNORECASE,
	INF,
	INFEGAL,
	SUP,
	SUPEGAL,
	DIFF,
	LIKE,
	EGAL_DATE_WITH_HOURS,
	INF_DATE_WITH_HOURS,
	INFEGAL_DATE_WITH_HOURS,
	SUP_DATE_WITH_HOURS,
	SUPEGAL_DATE_WITH_HOURS,
	DIFF_DATE_WITH_HOURS
}
