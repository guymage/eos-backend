-- nature du terrain
alter table texture drop column typeId;
alter table `case` add column `idNature` INTEGER NULL;

CREATE TABLE `natureTerrain` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(250) NOT NULL,
  `descr` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`)
) COMMENT='nature d''une case';
ALTER TABLE `natureTerrain` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

insert into natureTerrain (nom, descr) values
('plaine', 'Plaine'),
('foret', 'Forêt'),
('desert', 'Désert'),
('glace', 'Glace'),
('eau', 'Eau'),
('montagne', 'Montagne'),
('marais', 'Marais'),
('route', 'Route'),
('objet', 'Bâtiment'),
('terre_maudite ', 'Terre maudite'),
('donjon', 'Donjon'),
('mur_donjon', 'Mur de Donjon'),
('mer', 'Zone inondée'),
('taverne_donjon', 'Repère des renégats'),
('donjon_aqua_level_1', 'Donjon Aqua Level 1');


ALTER TABLE `case` ADD FOREIGN KEY (idNature) REFERENCES `natureTerrain` (`id`);

ALTER TABLE `favoris` CHANGE `nom` `nom` VARCHAR( 25 );

-- Gestion des pointeurs
CREATE TABLE `pointeur` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `idCaseSrc` INTEGER NOT NULL,
  `idCaseDest` INTEGER NOT NULL,
  `idRoyaume` INTEGER NOT NULL,
  `commentaire` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `pointeur` ADD FOREIGN KEY (idCaseSrc) REFERENCES `case` (`id`);
ALTER TABLE `pointeur` ADD FOREIGN KEY (idCaseDest) REFERENCES `case` (`id`);
ALTER TABLE `pointeur` ADD FOREIGN KEY (idRoyaume) REFERENCES `race` (`id`);
ALTER TABLE `pointeur` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

RENAME TABLE `case` TO t_case;

CREATE TABLE `t_personnage` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `idJoueur` INTEGER NOT NULL,
  `idRoyaume` INTEGER NOT NULL,
  `updated` DATETIME NOT NULL,
  `updatedBy` INTEGER NOT NULL,
  `classe` VARCHAR(50) NULL DEFAULT NULL,
  `level` INTEGER NULL DEFAULT NULL,
  `melee` INTEGER NULL DEFAULT NULL,
  `distance` INTEGER NULL DEFAULT NULL,
  `esquive` INTEGER NULL DEFAULT NULL,
  `blocage` INTEGER NULL DEFAULT NULL,
  `incantation` INTEGER NULL DEFAULT NULL,
  `magieVie` INTEGER NULL DEFAULT NULL,
  `magieElem` INTEGER NULL DEFAULT NULL,
  `magieMort` INTEGER NULL DEFAULT NULL,
  `isCache` INTEGER NOT NULL DEFAULT 0,
  `dead` INTEGER NOT NULL DEFAULT 0,
  `dateDeath` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);
ALTER TABLE `t_personnage` ADD FOREIGN KEY (idJoueur) REFERENCES `joueur` (`id`);
ALTER TABLE `t_personnage` ADD FOREIGN KEY (updatedBy) REFERENCES `joueur` (`id`);
ALTER TABLE `t_personnage` ADD FOREIGN KEY (idRoyaume) REFERENCES `race` (`id`);

INSERT INTO `t_personnage` (`idJoueur`, `idRoyaume`,`updated`,`updatedBy`,`classe`,`level`,`melee`,`distance`,`esquive`,`blocage`,`incantation`,`magieVie`,`magieElem`,`magieMort`,`isCache`,`dead`,`dateDeath`)
SELECT `id`, `idRoyaume`, `updated`, `updatedBy`, `classe`, `level`, `melee`, `distance`, `esquive`, `blocage`, `incantation`, `magieVie`, `magieElem`, `magieMort`, `isCache`, 0, `dateDead` 
FROM `personnage`;

alter table joueurObs DROP PRIMARY KEY;
alter table joueurObs add `idPersonnage` INTEGER;
ALTER TABLE joueurObs ADD FOREIGN KEY (idPersonnage) REFERENCES `t_personnage` (`id`);
update joueurObs jo set idPersonnage = (
	select p.id from t_personnage p, observation o
	where p.idJoueur = jo.idJoueur
	and o.id = jo.idObservation
	and o.idRoyaume = p.idRoyaume
);
-- Vérifier que toutes les lignes sont affectées
alter table joueurObs modify `idPersonnage` INTEGER NOT NULL;
alter table joueurObs add PRIMARY KEY (idPersonnage, idObservation);
alter table joueurObs DROP COLUMN idJoueur;
alter table joueurObs DROP COLUMN isDead;
drop table personnage;

alter table t_personnage drop column `classe`;
CREATE TABLE `t_classeJoueur` (
  `idPersonnage` INTEGER,
  `idClasse` INTEGER NOT NULL,
  `idRoyaume` INTEGER NOT NULL,
  `idJoueur` INTEGER NOT NULL,
  `dateObservation` DATETIME NOT NULL
) ;

insert into t_classeJoueur(`idPersonnage`, `idClasse`, `idRoyaume`, `idJoueur`, `dateObservation`)
select NULL, `idClasse`, `idRoyaume`, `idJoueur`, dateObservation from classeJoueur;
-- non testée
update t_classeJoueur cj set idPersonnage = (
	select p.id from t_personnage p
	where p.idjoueur = cj.idJoueur
	and p.idRoyaume = cj.idRoyaume
);

alter table t_classeJoueur drop column idRoyaume;
alter table t_classeJoueur drop column idJoueur;
alter table t_classeJoueur modify `idPersonnage` INTEGER not null;
alter table t_classeJoueur add PRIMARY KEY (`idPersonnage`, `idClasse`);

RENAME TABLE t_classeJoueur TO t_classePersonnage;
