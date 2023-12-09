package com.microservices.recommandation.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity

public class Recommandation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentaire;
    private Float rating;
    private String auteur;





    // Getters


    public String getCommentaire() {
        return commentaire;
    }

    public Float getRating() {
        return rating;
    }

    public String getAuteur() {
        return auteur;
    }

    // Setters


    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
