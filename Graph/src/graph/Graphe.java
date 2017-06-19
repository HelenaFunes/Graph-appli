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

import java.util.ArrayList;
import java.util.ListIterator;

public class Graphe {
   private ArrayList<Sommet> listeSommets; //= new ArrayList<Sommet> ();
   private ArrayList<Arc> listeArcs; //= new ArrayList<Arc> ();

    public Graphe(Arc[] arcs , Sommet[] sommets){
        listeSommets = new ArrayList<Sommet> ();
        listeArcs = new ArrayList<Arc> ();
        int n = sommets.length;
        int m = arcs.length;
        listeSommets.add(sommets[0]);
        System.out.println("sommet 0 ajouté : " + listeSommets.get(0).getNom());
        for (int i=1; i<n; i++){
            if (!listeSommets.contains(sommets[i])){
                listeSommets.add(sommets[i]);
                System.out.println("sommet "+i+" ajouté : " + listeSommets.get(i).getNom());
            }
            else{
                System.out.println("Le graphe contient déjà" + sommets[i].getNom());
            }
        }
        listeArcs.add(arcs[0]);
        System.out.println("arc 0 ajouté : " + listeArcs.get(0).toString());
        for (int i=1; i<m; i++){
            if (!listeArcs.contains(arcs[i])){
                listeArcs.add(arcs[i]);
                System.out.println("arc " +i+" ajouté : " + listeArcs.get(i).toString());
            }
            else{
                System.out.println("Le graphe contient déjà l'arc");
            }
        }
        System.out.println(listeSommets.size());
    }
    /**
     * La distance est en metres. Elle délimite la distance à laquelle on fait un arc
     * @param villes
     * @param dist 
     */
    public Graphe(ArrayList<Ville> villes, int dist){
        listeSommets = new ArrayList<Sommet> ();
        listeArcs = new ArrayList<Arc> ();
        for(int i = 0; i<villes.size(); i++){
            Ville v =villes.get(i);
            Sommet som = new Sommet(v);
            if(!listeSommets.contains(som)){
                listeSommets.add(som);
                for (int k = 0; k<villes.size(); k++){
                    if(!v.equals(villes.get(k)) 
                            && v.getDistance(villes.get(k)) <=dist){
                        Arc arc = new Arc(v, villes.get(k));
                        Boolean dedans = false;
                        for(int j = 0; j<listeArcs.size(); j++){
                            if(arc.equals(listeArcs.get(j))){
                                dedans = true;
                            }
                        }
                        if(!dedans){
                            listeArcs.add(arc);
                        }
                    }
                }
            }
        }
        System.out.println(toString());
    }
    
    public Graphe(ArrayList<Ville> villes){
        this(villes, 0);
    }
      
    public void addSommet(Sommet A){
        if(!listeSommets.isEmpty()){
            if (!listeSommets.contains(A)){
                listeSommets.add(A);
            }
            else{
                System.out.println("Le graphe contient déjà" + A.getNom());
            }
        }else{
            listeSommets.add(A);
        }
   }
   
    public void addArc(Arc A){
        if(!listeArcs.isEmpty()){
            if (!listeArcs.contains(A)){
                listeArcs.add(A);
            }else{
                   System.out.println("Le graphe contient déjà l'arc" + A.getSom1().getNom() + 
                           " " + A.getSom2().getNom());
            }
        }else{
            listeArcs.add(A);
        }
    }
   
    public Object[] getSommets(){
         return listeSommets.toArray();
    }
    
    public ArrayList<Sommet> getListSom(){
        return listeSommets;
    }
    public ArrayList<Arc> getListArc(){
        return listeArcs;
    }

    public Object[] getArcs(){
        return listeArcs.toArray();
    }

   @Override
    public String toString(){
        StringBuffer texte = new StringBuffer("*** graphe ***\n");
        for (int i=0; i<listeSommets.size();i++){
            Sommet noeudCourant = listeSommets.get(i);
            texte.append(noeudCourant.getNom()+"\n" );
        }
        for (Arc a : listeArcs){
             Arc arcCourant = a;
            texte.append(arcCourant.toString()+"\n" );
        }
        return texte.toString();
        }
}

