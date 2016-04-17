DELETE FROM JOUEUR;
delete from texture;
delete from t_case;
-- A faire en dernier
DELETE FROM natureterrain; 
DELETE FROM RACE;

-- Race
INSERT INTO race(id, nom, descr) values
(0,'Inconnu', 'Neutre'),
(1, 'Scav', 'Scavenger');

-- Joueur utilisé pour l'authentification
INSERT INTO joueur(id, nom, passwd, idRace, isActive)
values(1, 'Test', 'password', 1, 1);

-- Texture
INSERT INTO texture (id, css, path) VALUES
(0, '0', 'tex_herbe1.png'),
(101, '101', 'tex_herbe1.png'),
(102, '102', 'tex_herbefleur.png'),
(103, '103', 'tex_herbebuisson.png');

-- Nature
insert into natureTerrain (id, nom, descr) values
(1, 'plaine', 'Plaine'),
(2, 'foret', 'Forêt'),
(3, 'desert', 'Désert'),
(4, 'glace', 'Glace');

-- Case
insert into `t_case` (id, x, y, lastIdRace, idNature) VALUES
(1, 1, 1, 0, 1),
(2, 1, 2, 0, 1),
(3, 1, 3, 0, 1),
(4, 2, 1, 0, 1),
(5, 2, 2, 0, 2),
(6, 2, 3, 0, 2),
(7, 3, 1, 0, 3),
(8, 3, 2, 0, 1),
(9, 3, 3, 0, 1);
