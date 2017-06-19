/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import graph.Arc;
import graph.Graphe;
import graph.Sommet;
import java.util.ArrayList;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
/**
 *
 * @author Axel
 */
public class visuGraph {
    private Graphe g;
    
    public visuGraph(Graphe g){
        this.g = g;
    }
    
    public void afficher(){
        Graph graph = new SingleGraph("Carte");
        ArrayList<Sommet> sommets = g.getListSom();
        ArrayList<Arc> arcs = g.getListArc();
        int n = sommets.size();
        int m = arcs.size();
        for (int i=0; i<n; i++){
            Node a;
            System.out.println(sommets.get(i).getNom());
            a = graph.addNode(sommets.get(i).getNom());
            a.addAttribute("ui.label", sommets.get(i).getNom());
        }
        for (int j =0; j<m; j++){
            Arc arc = arcs.get(j);
            Sommet a1 = arc.getSom1();
            Sommet a2 = arc.getSom2();
            Edge e;
            e = graph.addEdge(a1.getNom() + a2.getNom(), a1.getNom() ,a2.getNom());
            e.setAttribute("ui.label", arc.getValeur());
        }
        
        graph.display();
        
    }
}
