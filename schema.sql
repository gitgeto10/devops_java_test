/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  dell
 * Created: 30 avr. 2025
 */

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);
CREATE TABLE article (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ref VARCHAR(50) NOT NULL,
    nom VARCHAR(255) NOT NULL,
    prixUnitaire DECIMAL(10,2) NOT NULL,
    qte INT NOT NULL
);
