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
public class Sommet {
    private String nom;
    private float latitude;
    private float longitude;

    public Sommet(String nom, float latitude, float longitude) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public Sommet(Ville v){
        this.nom = v.getId();
        this.latitude = v.getLatitude();
        this.longitude = v.getLongitude();
    }

    public Sommet(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
    public Boolean equals(Sommet s){
        if (nom.equals(s.getNom()) || longitude == s.getLongitude() || latitude == s.getLatitude()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String printSom(){
        return "Sommet "+ nom;
    }
    
    public Boolean isNom(String nm){
        if(nom == nm){
            return true;
        }
        return false;
    }
}
