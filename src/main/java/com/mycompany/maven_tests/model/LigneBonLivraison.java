/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_tests.model;

/**
 *
 * @author dell
 */

public class LigneBonLivraison {
    private int id;
    private int idBonLivraison;
    private String designation;
    private int quantity;

    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdBonLivraison() {
        return idBonLivraison;
    }
    public void setIdBonLivraison(int idBonLivraison) {
        this.idBonLivraison = idBonLivraison;
    }

    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
