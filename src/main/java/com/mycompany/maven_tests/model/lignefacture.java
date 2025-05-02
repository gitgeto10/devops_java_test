package com.mycompany.maven_tests.model;

public class lignefacture {
    private int id;
    private int id_facture;
    private int id_article;
    private int quantity;
    private double sub_total;

    public lignefacture(int id_facture, int id_article, int quantity, double sub_total) {
        this.id_facture = id_facture;
        this.id_article = id_article;
        this.quantity = quantity;
        this.sub_total = sub_total;
    }

    // Getters et Setters
    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }
}
