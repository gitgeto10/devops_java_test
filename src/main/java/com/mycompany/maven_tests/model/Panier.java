/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_tests.model;


public class Panier {
    private int id;
    private String nArticle;
    private String client;

    public Panier(int id, String nArticle, String client) {
        this.id = id;
        this.nArticle = nArticle;
        this.client = client;
    }

    public int getId() { return id; }
    public String getArticle() { return nArticle; }
    public String getClient() { return client; }

    public void setId(int id) { this.id = id; }
    public void setNArticle(String nArticle) { this.nArticle = nArticle; }
    public void setClient(String client) { this.client = client; }
}

