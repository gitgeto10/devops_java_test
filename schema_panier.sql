-- Création de la table panier
CREATE TABLE IF NOT EXISTS panier (
    id INT AUTO_INCREMENT PRIMARY KEY,
    article VARCHAR(255) NOT NULL,
    client VARCHAR(255) NOT NULL
);

-- Insertion d'exemples de données dans la table panier
INSERT INTO panier (article, client) VALUES 
('ART001', 'Ahmed'),
('ART002', 'Jamila'),
('ART003', 'SAAD'),
('ART004', 'SAMIRA');
