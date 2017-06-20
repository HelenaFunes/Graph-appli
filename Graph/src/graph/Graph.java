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
//        Sommet A = new Sommet("A");
//        Sommet B = new Sommet("B");
//        Sommet C = new Sommet("C");
//        Arc AB = new Arc(A,B,10);
//        Arc BC = new Arc(B,C);
//        Sommet[] som = {A,B,C};
//        Arc[] arc = {AB,BC};
//        Graphe g = new Graphe(arc , som);
//        System.out.println(g.toString());

          CSVReader reader = new CSVReader();
          //ArrayList<Ville> villes = reader.getFromCSV(150000);
          ArrayList<Ville> villes = reader.getFromCSV();
          //System.out.println(villes.get(0).getDistance(villes.get(1)));
          //Graphe g = new Graphe(villes, 250000);
          Graphe g = new Graphe(villes);
          Matrice mat = new Matrice(g);
          mat.printMat();
          

         Dijkstra dij = new Dijkstra(mat);
         System.out.println("Coucou");
         Boolean[] a = new Boolean[2];
         System.out.println(a[1]);
         
        dij.Chemin(mat.getSommets().get(6) , mat.getSommets().get(10));
        dij.printChemin();
        visuGraph vg = new visuGraph(g);
        vg.afficher();
        //vg.afficher(dij.getChemin());
         
         
         
         

    }
    
}
