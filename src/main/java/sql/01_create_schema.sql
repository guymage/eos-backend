--
-- Scripts pour MySQL

-- Creation de la database
CREATE DATABASE IF NOT EXISTS `eos` 
CHARACTER SET utf8
COLLATE utf8_bin;


-- Creation du user
CREATE USER 'joueur'@'localhost' IDENTIFIED BY 'joueur';
GRANT USAGE ON * . * TO 'joueur'@'localhost' IDENTIFIED BY 'joueur' ;
GRANT DROP, DELETE, SELECT, INSERT, UPDATE, EXECUTE ON eos.* TO 'joueur'@'localhost' ;  


-- ne pas oublier:
-- ENGINE=innoDB DEFAULT CHARSET=utf8 
-- pour chaque création de table afin de gérer les transactions et le bon encodage.