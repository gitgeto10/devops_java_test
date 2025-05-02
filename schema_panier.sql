-- Création de la table panier
CREATE TABLE IF NOT EXISTS panier (
    id INT AUTO_INCREMENT PRIMARY KEY,
    n_article VARCHAR(255) NOT NULL,
    client VARCHAR(255) NOT NULL
);

