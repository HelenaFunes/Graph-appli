/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import visual.visuGraph;

/**
 *
 * @author Héléna
 */
public class Graph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int population = 150000;
        int dist = 300000;// en mètres
        String nom1 = "nantes";
        String nom2 = "lyon";
        Boolean Dijsktra = true;
        
        /*
        Paramètres de base : 150000 de population, dist = 250000
        Si vous voulez essayer de charger toutes les villes, vous pouvez mettre
        pop à 0.
        Si vous ne voulez pas afficher de plus court chemin, mettez Dijsktra sur false.
        Si vous ne modifiez rien, il y a dans le graphe : nice, marseille, dijon 
        toulouse bordeaux montpellierrennes grenoble saint-etienne nantes
        reims lille strasbourg lyon paris havre toulon
        */

        CSVReader reader = new CSVReader();
        ArrayList<Ville> villes = reader.getFromCSV(population);
        System.out.println(villes.get(0).getDistance(villes.get(1)));
        Graphe g = new Graphe(villes, dist);
        if (Dijsktra){
            Matrice mat = new Matrice(g);
            mat.printMat();
            Dijkstra dij = new Dijkstra(mat);
            dij.Chemin(mat.getSommetbyName(nom1) , mat.getSommetbyName(nom2));
            dij.printChemin();
            visuGraph vg = new visuGraph(g);
            vg.afficher(dij.getChemin());
        }else{
            visuGraph vg = new visuGraph(g);
            vg.afficher();
        }
         
         
         
         

    }
    
}
