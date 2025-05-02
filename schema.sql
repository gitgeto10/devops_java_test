/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  dell
 * Created: 30 avr. 2025
 */

-- Création de la table article
CREATE TABLE IF NOT EXISTS article (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ref VARCHAR(50) NOT NULL,
    nom VARCHAR(255) NOT NULL,
    prixUnitaire DECIMAL(10,2) NOT NULL,
    qte INT NOT NULL
);

-- Création de la table users
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Création de la table factures
CREATE TABLE IF NOT EXISTS factures (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Création de la table lignefacture
CREATE TABLE IF NOT EXISTS lignefacture (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_facture INT NOT NULL,
    id_article INT NOT NULL,
    quantity INT NOT NULL,
    sub_total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_facture) REFERENCES factures(id),
    FOREIGN KEY (id_article) REFERENCES article(id)
);

-- Insérer un utilisateur pour test
INSERT INTO users (name, email) VALUES ('Jamila Dahi', 'jda@gk.mt');
