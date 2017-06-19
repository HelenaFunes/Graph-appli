/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Axel
 */
public class Ville {
    private String id;
    private String nom;
    private int population;
    private float longitude;
    private float latitude;

    public Ville(String id, String nom, int pop, float longitude, float latitude){
        this.id = id;
        this.nom = nom;
        this.population = pop;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    public Ville(){
        this.id = null;
        this.nom = null;
        this.population = 0;
        this.longitude = 0;
        this.latitude = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    
    @Override
    public String toString(){
        return ("Ville d'id" + id + " de nom " + nom + " de population " + population
            + "de longitude "+ longitude + " de latitude "+ latitude);
    }
    
}
