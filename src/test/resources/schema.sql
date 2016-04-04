
-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
 SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'joueur'
-- 
-- ---

DROP TABLE IF EXISTS `joueur`;
		
CREATE TABLE `joueur` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(150) NOT NULL,
  `passwd` VARCHAR(150) NULL DEFAULT NULL,
  `idRace` INTEGER NOT NULL,
  `isActive` INTEGER NOT NULL,
  `lastConnection` DATETIME NULL DEFAULT NULL,
  `mail` VARCHAR(50) NULL DEFAULT NULL,
  `invisible` INTEGER NOT NULL DEFAULT 0,
  `invisibleValidite` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'batiment'
-- 
-- ---

DROP TABLE IF EXISTS `batiment`;
		
CREATE TABLE `batiment` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `idRace` INTEGER NOT NULL,
  `idImage` INTEGER NOT NULL,
  `hp` INTEGER NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'observation'
-- 
-- ---

DROP TABLE IF EXISTS `observation`;
		
CREATE TABLE `observation` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `idRoyaume` INTEGER NOT NULL,
  `idObservateur` INTEGER NOT NULL,
  `dateObservation` DATETIME NOT NULL,
  `idCase` INTEGER NOT NULL,
  `idTexture` INTEGER NULL DEFAULT NULL,
  `idRace` INTEGER NOT NULL,
  `idTypeTerrain` INTEGER NULL DEFAULT NULL,
  `idBatiment` INTEGER NULL DEFAULT NULL,
  `idFlag` INTEGER NULL DEFAULT NULL,
  `idPnj` INTEGER NULL DEFAULT NULL,
  `idArmeSiege` INTEGER NULL DEFAULT NULL,
  `idDefense` INTEGER NULL DEFAULT NULL,
  `obsolete` INTEGER NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'texture'
-- liste des textures
-- ---

DROP TABLE IF EXISTS `texture`;
		
CREATE TABLE `texture` (
  `id` INTEGER NOT NULL,
  `css` VARCHAR(20) NOT NULL,
  `path` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`)
) COMMENT='liste des textures';

-- ---
-- Table 't_case'
-- 
-- ---

DROP TABLE IF EXISTS `t_case`;
		
CREATE TABLE `t_case` (
  `id` INTEGER NOT NULL,
  `x` INTEGER NOT NULL,
  `y` INTEGER NOT NULL,
  `lastIdRace` INTEGER NOT NULL DEFAULT 0,
  `dateConquete` DATETIME NULL DEFAULT NULL,
  `idNature` INTEGER NOT NULL DEFAULT 99,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'joueurObs'
-- Table définissant les joueurs sur une case
-- ---

DROP TABLE IF EXISTS `joueurObs`;
		
CREATE TABLE `joueurObs` (
  `idPersonnage` INTEGER NOT NULL,
  `idObservation` INTEGER NOT NULL,
  PRIMARY KEY (`idObservation`, `idPersonnage`)
) COMMENT='Table définissant les joueurs sur une case';

-- ---
-- Table 'race'
-- 
-- ---

DROP TABLE IF EXISTS `race`;
		
CREATE TABLE `race` (
  `id` INTEGER NOT NULL,
  `nom` VARCHAR(25) NOT NULL,
  `descr` VARCHAR(30) NOT NULL,
  `capitaleX` INTEGER NULL DEFAULT NULL,
  `capitaleY` INTEGER NULL DEFAULT NULL,
  `colorR` INTEGER NULL DEFAULT NULL,
  `colorG` INTEGER NULL DEFAULT NULL,
  `colorB` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'classe'
-- 
-- ---

DROP TABLE IF EXISTS `classe`;
		
CREATE TABLE `classe` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `nom` VARCHAR(25) NOT NULL,
  `path` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'pnj'
-- 
-- ---

DROP TABLE IF EXISTS `pnj`;
		
CREATE TABLE `pnj` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `nom` VARCHAR(50) NOT NULL,
  `image` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'flag'
-- 
-- ---

DROP TABLE IF EXISTS `flag`;
		
CREATE TABLE `flag` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `idRace` INTEGER NOT NULL,
  `idImage` INTEGER NOT NULL,
  `dateFin` DATETIME NOT NULL,
  `type` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'favoris'
-- Raccourcis uniquement vers des cases observées.
-- ---

DROP TABLE IF EXISTS `favoris`;
		
CREATE TABLE `favoris` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `idJoueur` INTEGER NOT NULL,
  `idCase` INTEGER NOT NULL,
  `nom` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
) COMMENT='Raccourcis uniquement vers des cases observées.';

-- ---
-- Table 'infoEntity'
-- Informations sur une entité observée
-- ---

DROP TABLE IF EXISTS `infoEntity`;
		
CREATE TABLE `infoEntity` (
  `idEntite` INTEGER NOT NULL,
  `idRoyaume` INTEGER NOT NULL,
  `typeEntite` VARCHAR(10) NOT NULL,
  `updatedBy` INTEGER NULL DEFAULT NULL,
  `updated` DATETIME NULL DEFAULT NULL,
  `comment` VARCHAR(250) NULL DEFAULT NULL,
  `isRezor` INTEGER NULL DEFAULT NULL,
  `isArchi` INTEGER NULL DEFAULT NULL,
  `isTarget` INTEGER NOT NULL DEFAULT 0,
  PRIMARY KEY (`idEntite`, `idRoyaume`, `typeEntite`)
) COMMENT='Informations sur une entité observée';

-- ---
-- Table 't_classeJoueur'
-- Liste des classes d''un joueur durant ses observations
-- ---

DROP TABLE IF EXISTS `t_classeJoueur`;
		
CREATE TABLE `t_classeJoueur` (
  `idPersonnage` INTEGER NOT NULL,
  `idClasse` INTEGER NOT NULL,
  `dateObservation` DATETIME NOT NULL,
  PRIMARY KEY (`idPersonnage`, `idClasse`)
) COMMENT='Liste des classes d''un joueur durant ses observations';

-- ---
-- Table 'infoCase'
-- 
-- ---

DROP TABLE IF EXISTS `infoCase`;
		
CREATE TABLE `infoCase` (
  `idCase` INTEGER NOT NULL,
  `idRoyaume` INTEGER NOT NULL,
  `updatedBy` INTEGER NOT NULL,
  `updated` DATETIME NOT NULL,
  `comment` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`idRoyaume`, `idCase`)
);

-- ---
-- Table 'log'
-- Table des logs d''EOS
-- ---

DROP TABLE IF EXISTS `log`;
		
CREATE TABLE `log` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `idRoyaume` INTEGER NULL DEFAULT NULL,
  `date` DATETIME NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `details` VARCHAR(500) NOT NULL,
  `resume` VARCHAR(100) NOT NULL,
  `niveau` INTEGER NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) COMMENT='Table des logs d''EOS';

-- ---
-- Table 't_personnage'
-- 
-- ---

DROP TABLE IF EXISTS `t_personnage`;
		
CREATE TABLE `t_personnage` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `idJoueur` INTEGER NOT NULL,
  `idRoyaume` INTEGER NOT NULL,
  `updated` DATETIME NOT NULL,
  `updatedBy` INTEGER NOT NULL,
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

-- ---
-- Table 'armeSiege'
-- Armes de siège
-- ---

DROP TABLE IF EXISTS `armeSiege`;
		
CREATE TABLE `armeSiege` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `idType` INTEGER NOT NULL,
  `idRace` INTEGER NOT NULL,
  `idImage` INTEGER NOT NULL,
  `hp` INTEGER NOT NULL,
  `nextShoot` DATETIME NULL DEFAULT NULL,
  `shootBy` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) COMMENT='Armes de siège';

-- ---
-- Table 'logCoord'
-- Coordonnées associées aux logs
-- ---

DROP TABLE IF EXISTS `logCoord`;
		
CREATE TABLE `logCoord` (
  `idLog` INTEGER NOT NULL,
  `idCase` INTEGER NOT NULL,
  PRIMARY KEY (`idLog`, `idCase`)
) COMMENT='Coordonnées associées aux logs';

-- ---
-- Table 'defense'
-- Défense
-- ---

DROP TABLE IF EXISTS `defense`;
		
CREATE TABLE `defense` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `idRace` INTEGER NOT NULL,
  `idImage` INTEGER NOT NULL,
  `hp` INTEGER NOT NULL,
  PRIMARY KEY (`id`)
) COMMENT='Défense';

-- ---
-- Table 'image'
-- images des bâtiments du jeu
-- ---

DROP TABLE IF EXISTS `image`;
		
CREATE TABLE `image` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(100) NOT NULL,
  `path` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`)
) COMMENT='images des bâtiments du jeu';

-- ---
-- Table 'imageDisplay'
-- 
-- ---

DROP TABLE IF EXISTS `imageDisplay`;
		
CREATE TABLE `imageDisplay` (
  `idRoyaume` INTEGER NOT NULL,
  `nom` VARCHAR(50) NOT NULL,
  `date` DATETIME NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `finValidite` DATETIME NULL DEFAULT NULL,
  `idJoueur` INTEGER NULL DEFAULT NULL,
  `shared` INTEGER NOT NULL DEFAULT 0,
  PRIMARY KEY (`idRoyaume`, `nom`)
);

-- ---
-- Table 'typeArmeSiege'
-- 
-- ---

DROP TABLE IF EXISTS `typeArmeSiege`;
		
CREATE TABLE `typeArmeSiege` (
  `id` INTEGER NOT NULL,
  `nom` VARCHAR(100) NOT NULL,
  `tpsRecharge` INTEGER NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'statistique'
-- Statistiques sur l''utilisation des fonctionnalités du site
-- ---

DROP TABLE IF EXISTS `statistique`;
		
CREATE TABLE `statistique` (
  `mesure` VARCHAR(100) NOT NULL,
  `hits` INTEGER NOT NULL,
  PRIMARY KEY (`mesure`)
) COMMENT='Statistiques sur l''utilisation des fonctionnalités du site';

-- ---
-- Table 'notification'
-- 
-- ---

DROP TABLE IF EXISTS `notification`;
		
CREATE TABLE `notification` (
  `idJoueur` INTEGER NOT NULL,
  `type` VARCHAR(50) NOT NULL,
  `notified` INTEGER NOT NULL DEFAULT 0,
  PRIMARY KEY (`idJoueur`, `type`)
);

-- ---
-- Table 'habilitation'
-- 
-- ---

DROP TABLE IF EXISTS `habilitation`;
		
CREATE TABLE `habilitation` (
  `idJoueur` INTEGER NOT NULL,
  `habilitation` VARCHAR(20) NOT NULL DEFAULT 'NULL',
  PRIMARY KEY (`idJoueur`, `habilitation`)
);

-- ---
-- Table 'surveillance'
-- 
-- ---

DROP TABLE IF EXISTS `surveillance`;
		
CREATE TABLE `surveillance` (
  `idObservation` INTEGER NOT NULL,
  `idBatiment` INTEGER NOT NULL,
  PRIMARY KEY (`idObservation`, `idBatiment`)
);

-- ---
-- Table 'natureTerrain'
-- nature d''une case
-- ---

DROP TABLE IF EXISTS `natureTerrain`;
		
CREATE TABLE `natureTerrain` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(250) NOT NULL,
  `descr` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`)
) COMMENT='nature d''une case';

-- ---
-- Table 'pointeur'
-- 
-- ---

DROP TABLE IF EXISTS `pointeur`;
		
CREATE TABLE `pointeur` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `idCaseSrc` INTEGER NOT NULL,
  `idCaseDest` INTEGER NOT NULL,
  `idRoyaume` INTEGER NOT NULL,
  `commentaire` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `joueur` ADD FOREIGN KEY (idRace) REFERENCES `race` (`id`);
ALTER TABLE `batiment` ADD FOREIGN KEY (idRace) REFERENCES `race` (`id`);
ALTER TABLE `batiment` ADD FOREIGN KEY (idImage) REFERENCES `image` (`id`);
ALTER TABLE `observation` ADD FOREIGN KEY (idRoyaume) REFERENCES `race` (`id`);
ALTER TABLE `observation` ADD FOREIGN KEY (idObservateur) REFERENCES `joueur` (`id`);
ALTER TABLE `observation` ADD FOREIGN KEY (idCase) REFERENCES `t_case` (`id`);
ALTER TABLE `observation` ADD FOREIGN KEY (idTexture) REFERENCES `texture` (`id`);
ALTER TABLE `observation` ADD FOREIGN KEY (idRace) REFERENCES `race` (`id`);
ALTER TABLE `observation` ADD FOREIGN KEY (idBatiment) REFERENCES `batiment` (`id`);
ALTER TABLE `observation` ADD FOREIGN KEY (idFlag) REFERENCES `flag` (`id`);
ALTER TABLE `observation` ADD FOREIGN KEY (idPnj) REFERENCES `pnj` (`id`);
ALTER TABLE `observation` ADD FOREIGN KEY (idArmeSiege) REFERENCES `armeSiege` (`id`);
ALTER TABLE `observation` ADD FOREIGN KEY (idDefense) REFERENCES `defense` (`id`);
ALTER TABLE `t_case` ADD FOREIGN KEY (idNature) REFERENCES `natureTerrain` (`id`);
ALTER TABLE `joueurObs` ADD FOREIGN KEY (idPersonnage) REFERENCES `t_personnage` (`id`);
ALTER TABLE `joueurObs` ADD FOREIGN KEY (idObservation) REFERENCES `observation` (`id`);
ALTER TABLE `flag` ADD FOREIGN KEY (idRace) REFERENCES `race` (`id`);
ALTER TABLE `flag` ADD FOREIGN KEY (idImage) REFERENCES `image` (`id`);
ALTER TABLE `favoris` ADD FOREIGN KEY (idJoueur) REFERENCES `joueur` (`id`);
ALTER TABLE `favoris` ADD FOREIGN KEY (idCase) REFERENCES `t_case` (`id`);
ALTER TABLE `infoEntity` ADD FOREIGN KEY (idRoyaume) REFERENCES `race` (`id`);
ALTER TABLE `infoEntity` ADD FOREIGN KEY (updatedBy) REFERENCES `joueur` (`id`);
ALTER TABLE `t_classeJoueur` ADD FOREIGN KEY (idPersonnage) REFERENCES `t_personnage` (`id`);
ALTER TABLE `t_classeJoueur` ADD FOREIGN KEY (idClasse) REFERENCES `classe` (`id`);
ALTER TABLE `infoCase` ADD FOREIGN KEY (idCase) REFERENCES `t_case` (`id`);
ALTER TABLE `infoCase` ADD FOREIGN KEY (idRoyaume) REFERENCES `race` (`id`);
ALTER TABLE `infoCase` ADD FOREIGN KEY (updatedBy) REFERENCES `joueur` (`id`);
ALTER TABLE `log` ADD FOREIGN KEY (idRoyaume) REFERENCES `race` (`id`);
ALTER TABLE `t_personnage` ADD FOREIGN KEY (idJoueur) REFERENCES `joueur` (`id`);
ALTER TABLE `t_personnage` ADD FOREIGN KEY (idRoyaume) REFERENCES `race` (`id`);
ALTER TABLE `t_personnage` ADD FOREIGN KEY (updatedBy) REFERENCES `joueur` (`id`);
ALTER TABLE `armeSiege` ADD FOREIGN KEY (idType) REFERENCES `typeArmeSiege` (`id`);
ALTER TABLE `armeSiege` ADD FOREIGN KEY (idRace) REFERENCES `race` (`id`);
ALTER TABLE `armeSiege` ADD FOREIGN KEY (idImage) REFERENCES `image` (`id`);
ALTER TABLE `armeSiege` ADD FOREIGN KEY (shootBy) REFERENCES `joueur` (`id`);
ALTER TABLE `logCoord` ADD FOREIGN KEY (idLog) REFERENCES `log` (`id`);
ALTER TABLE `logCoord` ADD FOREIGN KEY (idCase) REFERENCES `t_case` (`id`);
ALTER TABLE `defense` ADD FOREIGN KEY (idRace) REFERENCES `race` (`id`);
ALTER TABLE `defense` ADD FOREIGN KEY (idImage) REFERENCES `image` (`id`);
ALTER TABLE `imageDisplay` ADD FOREIGN KEY (idRoyaume) REFERENCES `race` (`id`);
ALTER TABLE `imageDisplay` ADD FOREIGN KEY (idJoueur) REFERENCES `joueur` (`id`);
ALTER TABLE `notification` ADD FOREIGN KEY (idJoueur) REFERENCES `joueur` (`id`);
ALTER TABLE `habilitation` ADD FOREIGN KEY (idJoueur) REFERENCES `joueur` (`id`);
ALTER TABLE `surveillance` ADD FOREIGN KEY (idObservation) REFERENCES `observation` (`id`);
ALTER TABLE `surveillance` ADD FOREIGN KEY (idBatiment) REFERENCES `batiment` (`id`);
ALTER TABLE `pointeur` ADD FOREIGN KEY (idCaseSrc) REFERENCES `t_case` (`id`);
ALTER TABLE `pointeur` ADD FOREIGN KEY (idCaseDest) REFERENCES `t_case` (`id`);
ALTER TABLE `pointeur` ADD FOREIGN KEY (idRoyaume) REFERENCES `race` (`id`);

-- ---
-- Table Properties
-- ---

-- ALTER TABLE `joueur` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `batiment` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `observation` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `texture` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `t_case` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `joueurObs` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `race` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `classe` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `pnj` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `flag` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `favoris` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `infoEntity` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `t_classeJoueur` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `infoCase` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `log` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `t_personnage` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `armeSiege` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `logCoord` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `defense` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `image` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `imageDisplay` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `typeArmeSiege` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `statistique` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `notification` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `habilitation` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `surveillance` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `natureTerrain` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `pointeur` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `joueur` (`id`,`nom`,`passwd`,`idRace`,`isActive`,`lastConnection`,`mail`,`invisible`,`invisibleValidite`) VALUES
-- ('','','','','','','','','');
-- INSERT INTO `batiment` (`id`,`idRace`,`idImage`,`hp`) VALUES
-- ('','','','');
-- INSERT INTO `observation` (`id`,`idRoyaume`,`idObservateur`,`dateObservation`,`idCase`,`idTexture`,`idRace`,`idTypeTerrain`,`idBatiment`,`idFlag`,`idPnj`,`idArmeSiege`,`idDefense`,`obsolete`) VALUES
-- ('','','','','','','','','','','','','','');
-- INSERT INTO `texture` (`id`,`css`,`path`) VALUES
-- ('','','');
-- INSERT INTO `t_case` (`id`,`x`,`y`,`lastIdRace`,`dateConquete`,`idNature`) VALUES
-- ('','','','','','');
-- INSERT INTO `joueurObs` (`idPersonnage`,`idObservation`) VALUES
-- ('','');
-- INSERT INTO `race` (`id`,`nom`,`descr`,`capitaleX`,`capitaleY`,`colorR`,`colorG`,`colorB`) VALUES
-- ('','','','','','','','');
-- INSERT INTO `classe` (`id`,`nom`,`path`) VALUES
-- ('','','');
-- INSERT INTO `pnj` (`id`,`nom`,`image`) VALUES
-- ('','','');
-- INSERT INTO `flag` (`id`,`idRace`,`idImage`,`dateFin`,`type`) VALUES
-- ('','','','','');
-- INSERT INTO `favoris` (`id`,`idJoueur`,`idCase`,`nom`) VALUES
-- ('','','','');
-- INSERT INTO `infoEntity` (`idEntite`,`idRoyaume`,`typeEntite`,`updatedBy`,`updated`,`comment`,`isRezor`,`isArchi`,`isTarget`) VALUES
-- ('','','','','','','','','');
-- INSERT INTO `t_classeJoueur` (`idPersonnage`,`idClasse`,`dateObservation`) VALUES
-- ('','','');
-- INSERT INTO `infoCase` (`idCase`,`idRoyaume`,`updatedBy`,`updated`,`comment`) VALUES
-- ('','','','','');
-- INSERT INTO `log` (`id`,`idRoyaume`,`date`,`name`,`details`,`resume`,`niveau`) VALUES
-- ('','','','','','','');
-- INSERT INTO `t_personnage` (`id`,`idJoueur`,`idRoyaume`,`updated`,`updatedBy`,`level`,`melee`,`distance`,`esquive`,`blocage`,`incantation`,`magieVie`,`magieElem`,`magieMort`,`isCache`,`dead`,`dateDeath`) VALUES
-- ('','','','','','','','','','','','','','','','','');
-- INSERT INTO `armeSiege` (`id`,`idType`,`idRace`,`idImage`,`hp`,`nextShoot`,`shootBy`) VALUES
-- ('','','','','','','');
-- INSERT INTO `logCoord` (`idLog`,`idCase`) VALUES
-- ('','');
-- INSERT INTO `defense` (`id`,`idRace`,`idImage`,`hp`) VALUES
-- ('','','','');
-- INSERT INTO `image` (`id`,`nom`,`path`) VALUES
-- ('','','');
-- INSERT INTO `imageDisplay` (`idRoyaume`,`nom`,`date`,`description`,`finValidite`,`idJoueur`,`shared`) VALUES
-- ('','','','','','','');
-- INSERT INTO `typeArmeSiege` (`id`,`nom`,`tpsRecharge`) VALUES
-- ('','','');
-- INSERT INTO `statistique` (`mesure`,`hits`) VALUES
-- ('','');
-- INSERT INTO `notification` (`idJoueur`,`type`,`notified`) VALUES
-- ('','','');
-- INSERT INTO `habilitation` (`idJoueur`,`habilitation`) VALUES
-- ('','');
-- INSERT INTO `surveillance` (`idObservation`,`idBatiment`) VALUES
-- ('','');
-- INSERT INTO `natureTerrain` (`id`,`nom`,`descr`) VALUES
-- ('','','');
-- INSERT INTO `pointeur` (`id`,`idCaseSrc`,`idCaseDest`,`idRoyaume`,`commentaire`) VALUES
-- ('','','','','');
