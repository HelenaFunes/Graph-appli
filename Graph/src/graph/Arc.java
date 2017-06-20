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
public class Arc {
    private Sommet som1;
    private Sommet som2;
    private int valeur;

    public Arc(Sommet som1, Sommet som2, int valeur) {
        this.som1 = som1;
        this.som2 = som2;
        this.valeur = valeur;
    }

    public Arc(Sommet som1, Sommet som2) {
        this.som1 = som1;
        this.som2 = som2;
        this.valeur = -1;
    }
    
    public Arc (Arc a){
        this.som1 = a.getSom1();
        this.som2 = a.getSom2();
        this.valeur = a.getValeur();
    }
    
    public Arc(Ville v1, Ville v2){
        this.som1 = new Sommet(v1);
        this.som2 = new Sommet(v2);
        this.valeur = v1.getDistance(v2);
    }
    

    public Sommet getSom1() {
        return som1;
    }

    public void setSom1(Sommet som1) {
        this.som1 = som1;
    }

    public Sommet getSom2() {
        return som2;
    }

    public void setSom2(Sommet som2) {
        this.som2 = som2;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    
    @Override
    public String toString(){
        return "Arc reliant " + this.getSom1().getNom() + " à " + this.getSom2().getNom() + " de valeur " + this.getValeur() + " mètres";
    }
    
    public Boolean equals(Arc a){
        return (som1.equals(a.getSom1()) && som2.equals(a.getSom2()) && valeur == a.getValeur())
                || (som1.equals(a.getSom2()) && som2.equals(a.getSom1()) && valeur == a.getValeur());
    }
    
    public Boolean inArc(Sommet s){
        return som1.equals(s) || som2.equals(s);
    }
    
    public Sommet otherSom(Sommet s){
        if (som1.equals(s)){
            return som2;
        }else if(som2.equals(s)){
            return som1;
        }else{
            return null;
        }
    }
    
    public Boolean isEnds(Sommet s1, Sommet s2){
        return inArc(s1) && otherSom(s1).equals(s2);
    }
    
}
