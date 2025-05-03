/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_tests.model;

public class Panier {
    private int id;
    private String article;
    private String client;

    public Panier(String article, String client) {
        this.article = article;
        this.client = client;
    }

    public Panier(int id, String article, String client) {
        this.id = id;
        this.article = article;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public String getArticle() {
        return article;
    }

    public String getClient() {
        return client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setClient(String client) {
        this.client = client;
    }
}

