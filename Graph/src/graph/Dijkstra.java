/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.*;
/**
 *
 * @author Axel
 */
public class Dijkstra {
    private Matrice mat;//Matrice d'adjacence du graphe
    private ArrayList<Sommet> chemin; //ArrayList qui contiendra le chemin
    private int[] pere; //
    private ArrayList<Sommet> Z;//ArrayList qui contient l'ensemble des sommets
    private Boolean[] marque;//Tableau de boolean qui indique si on a marqué le noeud
    private int[] lambda;//Tableau qui contient lambda(i)
    private int val;//Valeur du chemin
    
    
    final int max = Integer.MAX_VALUE;//Valeur de l'infini
    
    public Dijkstra(Matrice mat){
        this.mat = mat;
        Z = mat.getSommets();
        chemin = new ArrayList<Sommet>();
        pere = new int[Z.size()];
        lambda = new int[Z.size()];
        marque = new Boolean[Z.size()];
        for (int i =0; i<Z.size(); i++){
            marque[i] = false;
        }
        val = max;
    }
    
    //On renvoit le tableau des pères
    public int[] plusCourtChemin(Sommet x){
        //On vérifie que le sommet soit dans le graphe
        if(!Z.contains(x)){
            return null;
        }else{
            int i = Z.indexOf(x);
            //On marque le sommet i
            marque[i] = true;
            //On fait les opérations sur les sommets atteignables depuis i
            for (int j =0; j<Z.size(); j++){
                lambda[j] = mat.getMat()[i][j];
                if(lambda[j]!=max){
                    System.out.println(i +" devient pere de " + j);
                    pere[j]=i;
                }
            }
            //Tant que l'on a pas fini (finir =  tous les sommets sont marqués
            while(!end()){
                //On prend le sommet non marque le plus proche du sommet initial
                int indicemin = getMin();
                System.out.println("indicemin : "+ indicemin);
                //on le marque
                marque[indicemin] = true;
                for (int j=0; j<Z.size(); j++){
                    //Si on peut réduire la distance à i, on le fait
                    if (lambda[j]> lambda[indicemin] + mat.getMat()[indicemin][j] 
                                && mat.getMat()[indicemin][j]!=max ){
                    lambda[j] = lambda[indicemin] + mat.getMat()[indicemin][j];
                    System.out.println(indicemin +" devient pere de " + j);
                    //on modifie le tableau des pères
                    pere[j] = indicemin;
                    }
                }
            }
            return pere; 
        }
    }
    
    //On renvoit le chemin, et on le modifie dans l'objet
    public ArrayList<Sommet> Chemin(Sommet dep, Sommet fin){
        int[] padre = plusCourtChemin(dep);
        if (marque[Z.indexOf(fin)]){
            for(int i = 0; i<Z.size(); i++){
                System.out.print(padre[i]+ " ");

            }
            System.out.println(" ");
            int i = Z.indexOf(fin);
            System.out.println("la fin est :"+ i);
            System.out.println("le début est :" + Z.indexOf(dep));
            chemin.add(fin);
            while(i!= Z.indexOf(dep)){
                i = padre[i];
                chemin.add(Z.get(i));
                System.out.println("ajout de "+ i);
            }
            return chemin;
        }else{
            chemin = null;
            return null;
        }
    }
    
    //On récupère la valeur d'un chemin
    public int valChemin(ArrayList<Sommet> som){
        if (som == null){
            return 0;
        }else{
        int somme = 0;
        for(int i=0; i<som.size()-1; i++){
            int a = Z.indexOf(som.get(i));
            int b = Z.indexOf(som.get(i+1));
            somme +=mat.getMat()[a][b];
        }
        return somme;
        }
    }
    
    //On récupère la valeur du plus court chemin
    public int valPlusCourtChemin(){
        return valChemin(chemin);
    }
    
    //On affiche le plus court chemin
    public String printChemin(){
        if (chemin == null){
            System.out.println("Il n'y a pas de chemin entre les deux");
            return "Il n'y a pas de chemin entre les deux";
        }else{
            System.out.println("Chemin de " + chemin.get(chemin.size()-1).printSom() + " à " 
                    + chemin.get(0).printSom());
            String rep = "";
            for (int i = 0; i<chemin.size(); i++){
                rep += chemin.get(chemin.size()-1-i).printSom() + "-> ";
            }
            rep = rep.substring(0, rep.length() -3);
            System.out.println(rep);
            System.out.println("De valeur " + valChemin(chemin));

            return rep;
        }
    }
    
    //On renvoit le chemin avec les entiers qui correspondent aux sommets
    public int[] chemin_en_int(){
        int[] rep = new int[chemin.size()];
        for (int i = 0; i<chemin.size(); i++){
            rep[i] = Z.indexOf(chemin.get(i));
        }
        return rep;
    }
    
    //On récupère le point le plus proche
    public int getMin(){
        int min = max;
        int rep = -1;
        for (int i=0; i<lambda.length; i++){
            if(lambda[i]!=0 && lambda[i]<min && marque[i]==false){
                min = lambda[i];
                rep = i;
            }
        }
        System.out.println("getmin : " +rep);
        return rep;
    }
    
    //On vérifie si l'on a fini
    public Boolean end(){
        boolean rep = true;
        rep = false;
        for(int i =0; i<marque.length; i++){
            if(!marque[i] && lambda[i]!=max) return false;
        }
        return true;
    }

    public ArrayList<Sommet> getChemin() {
        return chemin;
    }

    public void setChemin(ArrayList<Sommet> chemin) {
        this.chemin = chemin;
    }
    
    
}
