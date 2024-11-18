-- Joueurs
INSERT INTO users (id, nom, email, mot_de_passe) VALUES
    (1, 'Joueur1', 'joueur1@example.com', 'password123'),
    (2, 'Joueur2', 'joueur2@example.com', 'password456'),
    (3, 'test', 'test@example.com', 'test');

-- Admins
INSERT INTO admins (id, nom, email, mot_de_passe) VALUES
    (1, 'Admin1', 'admin1@example.com', 'adminpass'),
    (2, 'Admin2', 'admin2@example.com', 'adminsecure'),
    (3, 'admin', 'admin@example.com', 'admin'),
    (4, 'Admin4', 'admin4@example.com', 'adminmdp');

-- Questions
INSERT INTO questions (id, question, reponse_correcte, admin_id) VALUES
    (12, 'Quelle est la capitale de l’Allemagne?', 'Berlin', 2),
    (13, 'Quelle est la capitale de la France?', 'Paris', 2),
    (14, 'Quelle est la capitale de l’Espagne?', 'Madrid', 3),
    (15, 'Quel est le plus grand désert du monde?', 'Sahara', 3),
    (16, 'Quel pays a le plus de lacs?', 'Canada', 3),
    (17, 'Quelle est la montagne la plus haute du monde?', 'Everest', 4),
    (18, 'Combien de continents y a-t-il sur Terre?', '7', 4),
    (19, 'Quelle rivière traverse Londres?', 'Thames', 4),
    (20, 'Quel est le pays le plus peuplé au monde?', 'Chine', 2),
    (21, 'Quelle est la capitale de l’Australie?', 'Canberra', 3),
    (22, 'Quel est le plus grand océan du monde?', 'Pacifique', 2);

INSERT INTO questions (id, question, reponse_correcte, admin_id) VALUES
    (23, 'Quel est le plus grand pays en superficie?', 'Russie', 4),
    (24, 'Quelle est la capitale du Japon?', 'Tokyo', 3),
    (25, 'Quel pays a la forme d’une botte?', 'Italie', 2),
    (26, 'Quelle mer borde Israël?', 'Mer Méditerranée', 3),
    (27, 'Quelle chaîne de montagnes se trouve en Europe?', 'Alpes', 4),
    (28, 'Dans quel pays se trouve le Grand Canyon?', 'États-Unis', 2),
    (29, 'Quel est le pays le plus au sud du monde?', 'Chili', 4),
    (30, 'Quel est le plus grand fleuve du monde?', 'Amazone', 4),
    (31, 'Quelle est la plus grande île au monde?', 'Groenland', 2),
    (32, 'Quel pays a le plus de frontières terrestres?', 'Chine', 3),
    (33, 'Dans quel pays se trouve le mont Kilimandjaro?', 'Tanzanie', 4),
    (34, 'Quelle est la capitale de l’Afrique du Sud?', 'Pretoria', 2),
    (35, 'Quel est le pays avec le plus grand nombre de volcans actifs?', 'Indonésie', 3),
    (36, 'Quelle est la mer la plus salée du monde?', 'Mer Morte', 4),
    (37, 'Quel pays possède la plus grande barrière de corail?', 'Australie', 3),
    (38, 'Quelle région est connue comme "le toit du monde"?', 'Tibet', 2),
    (39, 'Quel désert est le plus froid du monde?', 'Antarctique', 4),
    (40, 'Dans quelle ville peut-on trouver la Place Rouge?', 'Moscou', 3);



-- Réponses
INSERT INTO question_reponses (id, question_id, reponse) VALUES (15, 12, 'Berlin');
INSERT INTO question_reponses (id, question_id, reponse) VALUES (16, 12, 'Munich');
INSERT INTO question_reponses (id, question_id, reponse) VALUES (17, 12, 'Hambourg');
INSERT INTO question_reponses (id, question_id, reponse) VALUES (18, 12, 'Francfort');

INSERT INTO question_reponses (id, question_id, reponse) VALUES
    (19, 13, 'Lyon'), (20, 13, 'Paris'), (21, 13, 'Marseille'), (22, 13, 'Nice'),
    (23, 14, 'Barcelone'), (24, 14, 'Madrid'), (25, 14, 'Valence'), (26, 14, 'Séville'),
    (27, 15, 'Kalahari'), (28, 15, 'Sahara'), (29, 15, 'Atacama'), (30, 15, 'Gobi'),
    (31, 16, 'Russie'), (32, 16, 'Canada'), (33, 16, 'Chine'), (34, 16, 'États-Unis'),
    (35, 17, 'K2'), (36, 17, 'Everest'), (37, 17, 'Lhotse'), (38, 17, 'Kangchenjunga'),
    (39, 18, '6'), (40, 18, '4'), (41, 18, '5'), (42, 18, '7'),
    (43, 19, 'Seine'), (44, 19, 'Thames'), (45, 19, 'Danube'), (46, 19, 'Rhin'),
    (47, 20, 'Inde'), (48, 20, 'Chine'), (49, 20, 'États-Unis'), (50, 20, 'Indonésie'),
    (51, 21, 'Brisbane'), (52, 21, 'Canberra'), (53, 21, 'Sydney'), (54, 21, 'Melbourne'),
    (55, 22, 'Indien'), (56, 22, 'Atlantique'), (57, 22, 'Arctique'), (58, 22, 'Pacifique'),
    (59, 23, 'Chine'), (60, 23, 'Russie'), (61, 23, 'États-Unis'), (62, 23, 'Canada'),
    (63, 24, 'Osaka'), (64, 24, 'Tokyo'), (65, 24, 'Hiroshima'), (66, 24, 'Kyoto'),
    (67, 25, 'Portugal'), (68, 25, 'Italie'), (69, 25, 'Grèce'), (70, 25, 'Espagne'),
    (71, 26, 'Mer Caspienne'), (72, 26, 'Mer Méditerranée'), (73, 26, 'Mer Noire'), (74, 26, 'Mer Rouge'),
    (75, 27, 'Himalaya'), (76, 27, 'Andes'), (77, 27, 'Rocheuses'), (78, 27, 'Alpes'),
    (79, 28, 'Canada'), (80, 28, 'États-Unis'), (81, 28, 'Brésil'), (82, 28, 'Mexique'),
    (83, 29, 'Argentine'), (84, 29, 'Chili'), (85, 29, 'Afrique du Sud'), (86, 29, 'Australie'),
    (87, 30, 'Mississippi'), (88, 30, 'Nil'), (89, 30, 'Yangtsé'), (90, 30, 'Amazone'),
    (91, 31, 'Baffin'), (92, 31, 'Groenland'), (93, 31, 'Madagascar'), (94, 31, 'Australie'),
    (95, 32, 'Russie'), (96, 32, 'Chine'), (97, 32, 'Brésil'), (98, 32, 'Inde'),
    (99, 33, 'Kenya'), (100, 33, 'Tanzanie'), (101, 33, 'Afrique du Sud'), (102, 33, 'Rwanda'),
    (103, 34, 'Johannesburg'), (104, 34, 'Pretoria'), (105, 34, 'Le Cap'), (106, 34, 'Durban'),
    (107, 35, 'États-Unis'), (108, 35, 'Indonésie'), (109, 35, 'Japon'), (110, 35, 'Philippines'),
    (111, 36, 'Mer Rouge'), (112, 36, 'Mer Méditerranée'), (113, 36, 'Mer Morte'), (114, 36, 'Mer Caspienne'),
    (115, 37, 'Indonésie'), (116, 37, 'Australie'), (117, 37, 'Mexique'), (118, 37, 'États-Unis'),
    (119, 38, 'Himalaya'), (120, 38, 'Tibet'), (121, 38, 'Alpes'), (122, 38, 'Andes'),
    (123, 39, 'Atacama'), (124, 39, 'Karakoum'), (125, 39, 'Gobi'), (126, 39, 'Antarctique'),
    (127, 40, 'Saint-Pétersbourg'), (128, 40, 'Moscou'), (129, 40, 'Kazan'), (130, 40, 'Novgorod');


-- Scores
INSERT INTO scores (id, score, date, user_id) VALUES
    (20, 0, NOW(), 1),
    (21, 10, NOW(), 2),
    (22, 15, NOW(), 3),
    (23, 20, NOW(), 1),
    (24, 25, NOW(), 2);

