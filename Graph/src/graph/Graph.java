/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Héléna
 */
public class Graph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sommet A = new Sommet("A");
        Sommet B = new Sommet("B");
        Sommet C = new Sommet("C");
        Arc AB = new Arc(A,B,10);
        Arc BC = new Arc(B,C);
        Sommet[] som = {A,B,C};
        Arc[] arc = {AB,BC};
        Graphe g = new Graphe(arc , som);
        System.out.println(g.toString());
    }
    
}
