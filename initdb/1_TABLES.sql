-- Table User
CREATE TABLE users (
   id SERIAL PRIMARY KEY,
   nom TEXT NOT NULL,
   email TEXT NOT NULL UNIQUE,
   mot_de_passe TEXT NOT NULL
);


-- Table Admin
CREATE TABLE admins (
    id SERIAL PRIMARY KEY,
    nom TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    mot_de_passe TEXT NOT NULL
);


-- Table Score (lié à User)
CREATE TABLE scores (
    id SERIAL PRIMARY KEY,
    score INT NOT NULL,
    date TIMESTAMP NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);


-- Table Question (lié à Admin)
CREATE TABLE questions (
   id SERIAL PRIMARY KEY,
   question TEXT NOT NULL,
   reponse_correcte TEXT NOT NULL,
   admin_id INT NOT NULL,
   FOREIGN KEY (admin_id) REFERENCES admins(id) ON DELETE SET NULL
);


-- Table des réponses pour chaque question (lié à Question)
CREATE TABLE question_reponses (
   id SERIAL PRIMARY KEY,
   question_id INT NOT NULL,
   reponse TEXT NOT NULL,
   FOREIGN KEY (question_id) REFERENCES questions(id) ON DELETE CASCADE
);

