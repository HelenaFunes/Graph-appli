/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;

/**
 *
 * @author Axel
 */
public class Matrice {
    private int[][] mat;
    private ArrayList<Sommet> sommets;
    
    public Matrice(Graphe g){
        sommets = g.getListSom();
        ArrayList<Arc> arcs = g.getListArc();
        int max = Integer.MAX_VALUE;
        int n = sommets.size();
        int m = arcs.size();
        mat = new int[n][n];
        for (int i =0; i< n; i++){
            Sommet s = sommets.get(i);
            for(int j = 0;j<m; j++ ){
                if(arcs.get(j).inArc(s)){
                    for (int k=0; k<n; k++){
                        if(sommets.get(k).equals(arcs.get(j).otherSom(sommets.get(i)))){
                            mat[i][k] = arcs.get(j).getValeur();   
                        }
                    }
                        
                }
            }
        }
        for (int i = 0; i<n; i++){
            for (int j =0; j<n; j++){
                if(i==j){
                    mat[i][i] = 0;
                }else if(mat[i][j] == 0){
                    mat[i][j] = max;
                }
            }
        }
    }
    
    public void printMat(){
        for (int i =0; i<sommets.size(); i++){
            String impr = sommets.get(i).getNom() +" ";
            for (int j = 0; j<sommets.size(); j++){
                impr += mat[i][j] + " ";
            }
            System.out.println(impr);
        }
    }

    public int[][] getMat() {
        return mat;
    }

    public void setMat(int[][] mat) {
        this.mat = mat;
    }

    public ArrayList<Sommet> getSommets() {
        return sommets;
    }

    public void setSommets(ArrayList<Sommet> sommets) {
        this.sommets = sommets;
    }
    
    public Sommet getSommetbyName(String s){
        for (int i=0; i<sommets.size(); i++){
            System.out.println(sommets.get(i).getNom());
            if(sommets.get(i).getNom().equals(s)){
                System.out.println("WYT");
                return sommets.get(i);
            }
        }
        System.out.println("Le sommet "+ s+ " n'existe pas dans la matrice");
        return null;
    }
    
}
