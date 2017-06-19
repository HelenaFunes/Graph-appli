/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Objects;

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
        return ("Ville d'id " + id + " de nom " + nom + " de population " + population
            + " de longitude "+ longitude + " de latitude "+ latitude);
    }
    
    public int getDistance(Ville v){
        final int R = 6371; // Radius of the earth
        
        double lat1 = latitude;
        double lat2 = v.getLatitude();
        double lon1 = longitude;
        double lon2 = v.getLongitude();
        
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters


        
        return (int) distance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ville other = (Ville) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
