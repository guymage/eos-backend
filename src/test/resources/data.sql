DELETE FROM JOUEUR;
delete from texture;
delete from t_case;
-- A faire en dernier
DELETE FROM natureterrain; 
DELETE FROM RACE;

-- Race
insert into race (id, nom, descr, colorR, colorG, colorB)	VALUES(0,'Inconnu', 'Neutre', 170, 170, 170);
insert into race (id, nom, descr, colorR, colorG, colorB)	VALUES(1, 'barbare', 'Barbare', 0, 104, 255);
insert into race (id, nom, descr, capitaleX, capitaleY, colorR, colorG, colorB) VALUES(2, 'elfebois', 'Elfe des bois', 44, 90, 0, 153, 0);
insert into race (id, nom, descr, capitaleX, capitaleY, colorR, colorG, colorB) VALUES(3, 'troll', 'Troll', NULL, NULL, 255, 0, 0);
insert into race (id, nom, descr, capitaleX, capitaleY, colorR, colorG, colorB)	VALUES(4, 'scavenger', 'Scavenger', NULL, NULL, 255, 255, 0);
insert into race (id, nom, descr, capitaleX, capitaleY, colorR, colorG, colorB)	VALUES(6, 'orc', 'Orc', NULL, NULL, 255, 204, 204);
insert into race (id, nom, descr, capitaleX, capitaleY, colorR, colorG, colorB)	VALUES(7, 'nain', 'Nain', NULL, NULL, 255, 165, 0);
insert into race (id, nom, descr, capitaleX, capitaleY, colorR, colorG, colorB) VALUES(8, 'mortvivant', 'Mort-Vivant', NULL, NULL, 92, 30, 0);
insert into race (id, nom, descr, capitaleX, capitaleY, colorR, colorG, colorB) VALUES(9, 'humainnoir', 'Corrompu', NULL, NULL, 0, 0, 0);
insert into race (id, nom, descr, capitaleX, capitaleY, colorR, colorG, colorB)	VALUES(10, 'humain', 'Humain', NULL, NULL, 0, 0, 255);
insert into race (id, nom, descr, capitaleX, capitaleY, colorR, colorG, colorB)	VALUES(11, 'elfehaut', 'Haut-Elfe', NULL, NULL, 255, 255, 255);
insert into race (id, nom, descr, capitaleX, capitaleY, colorR, colorG, colorB) VALUES(12, 'vampire', 'Vampire', NULL, NULL, 204,204,204);


-- Joueur utilisé pour l'authentification
INSERT INTO joueur(id, nom, passwd, idRace, isActive)
values(1, 'Test', MD5('password'), 1, 1);

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
