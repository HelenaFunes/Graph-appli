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


//public class Graphe {
//    private Sommet[] sommets;
//    private Arc[] arcs;
//    private int[][] mat;
//
//    public Graphe(Sommet[] sommets, Arc[] arcs) {
//        this.sommets = sommets;
//        this.arcs = arcs;
//        this.mat = null;
//    }
//    
//    public void creeMat(){
//        int n = sommets.length;
//        int m = arcs.length;
//        int [][] matrice = new int[n][n];
//        int val = -1;
//        boolean marque;
//        for (int i =0; i<n; i++){
//            marque = false;
//            for (int j = 0; j<m; j++){
//                if (i == j){
//                    matrice[i][j] = 0;
//                    marque = true;
//                }else if((arcs[j].getSom1() == sommets[i] || arcs[j].getSom2() == sommets[i]) && !marque){
//                    matrice[i][j] = arcs[j].getValeur();
//                    marque = true;
//                }
//            }
//            if (!marque){
//                
//            }
//            
//        }
//        setMat(matrice);
//        
//    }
//
//    public Sommet[] getSommets() {
//        return sommets;
//    }
//
//    public void setSommets(Sommet[] sommets) {
//        this.sommets = sommets;
//    }
//
//    public Arc[] getArcs() {
//        return arcs;
//    }
//
//    public void setArcs(Arc[] arcs) {
//        this.arcs = arcs;
//    }
//
//    public int[][] getMat() {
//        return mat;
//    }
//
//    public void setMat(int[][] mat) {
//        this.mat = mat;
//    }
//    
//    public void printGraphe(){
//        int n = sommets.length;
//        int m = arcs.length;
//        System.out.println("Le graphe est :");
//        for (int i =0; i<n; i++){
//            System.out.print("Sommet "+ i + " " + sommets[i].getNom());
//            for (int j = 0; j<n; j++){
//                System.out.print(" " + mat[i][j]);
//            }
//            System.out.println(" ");
//        }
//    }
//    
//    
// 
//    
//}
