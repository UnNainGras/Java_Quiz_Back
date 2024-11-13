-- Insertion d'un joueur
INSERT INTO users (id, nom, email, mot_de_passe) VALUES (1, 'Joueur1', 'joueur1@example.com', 'password123');

-- Insertion d'un admin
INSERT INTO admins (id, nom, email, mot_de_passe) VALUES (1, 'Admin1', 'admin1@example.com', 'adminpass');

-- Insertion d'une question par l'admin
INSERT INTO questions (id, question, reponse_correcte, admin_id) VALUES (1, 'Quelle est la capitale de la France?', 'Paris', 1);

-- Insertion d'une réponse pour la question
INSERT INTO question_reponses (id, question_id, reponse) VALUES (1, 1, 'Paris');
INSERT INTO question_reponses (id, question_id, reponse) VALUES (2, 1, 'Lyon');
INSERT INTO question_reponses (id, question_id, reponse) VALUES (3, 1, 'Marseille');
INSERT INTO question_reponses (id, question_id, reponse) VALUES (4, 1, 'Nice');

-- Insertion d'un score de 0 pour le joueur
INSERT INTO scores (id, score, date, user_id) VALUES (1, 0, NOW(), 1);
