-- Insertion d'un joueur
INSERT INTO users (id, nom, email, mot_de_passe) VALUES (2, 'Joueur2', 'joueur2@example.com', 'password123');

-- Insertion d'un admin
INSERT INTO admins (id, nom, email, mot_de_passe) VALUES (2, 'Admin2', 'admin2@example.com', 'adminpass');

-- Insertion d'une question par l'admin
INSERT INTO questions (id, question, reponse_correcte, admin_id) VALUES (2, 'Quelle est la capitale de l’Allemagne?', 'Berlin', 2);

-- Insertion des réponses pour la question
INSERT INTO question_reponses (id, question_id, reponse) VALUES (5, 2, 'Berlin');
INSERT INTO question_reponses (id, question_id, reponse) VALUES (6, 2, 'Munich');
INSERT INTO question_reponses (id, question_id, reponse) VALUES (7, 2, 'Hambourg');
INSERT INTO question_reponses (id, question_id, reponse) VALUES (8, 2, 'Francfort');

-- Insertion d'un score pour le joueur
INSERT INTO scores (id, score, date, user_id) VALUES (2, 0, NOW(), 2);
