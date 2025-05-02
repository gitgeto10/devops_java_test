/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_tests.model;

/**
 *
 * @author yassin
 */
public class Article {
    private int id;
    private String ref;
    private String nom;
    private double prixUnitaire;
    private int qte;

    public Article() {}

    public Article(String ref, String nom, double prixUnitaire, int qte) {
        this.ref = ref;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.qte = qte;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getRef() { return ref; }
    public void setRef(String ref) { this.ref = ref; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(double prixUnitaire) { this.prixUnitaire = prixUnitaire; }

    public int getQte() { return qte; }
    public void setQte(int qte) { this.qte = qte; }
}