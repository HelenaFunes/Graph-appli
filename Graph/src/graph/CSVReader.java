/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Axel
 */
public class CSVReader {
    //adresse à modifier suivant l'utilisateur... Il y amoyen de le jouer plus finement
    //private String adresse = "C:\\Users\\Axel\\Desktop\\Graphe_v2\\CommunesFrance.csv";
    private String adresse = "..\\CommunesFrance.csv";
    public ArrayList<Ville> getFromCSV(){
        return getFromCSV(0);
    }
    /**
     * Meme methode, mais on ne prend que les villes de plus de x habitants
     */
    public ArrayList<Ville> getFromCSV(int x){
        String line = "";
        String cvsSplitBy = ";";
        ArrayList<Ville> villes = new ArrayList<Ville> ();

        try (BufferedReader br = new BufferedReader(new FileReader(adresse))) {
            line = br.readLine();
            
            while ((line = br.readLine()) != null) {
                Ville v = new Ville();
                // use comma as separator
                String[] ville = line.split(cvsSplitBy);
                if (Integer.parseInt(ville[2])>= x){
                    v.setId(ville[0]);
                    v.setNom(ville[1]);
                    v.setPopulation(Integer.parseInt(ville[2]));
                    v.setLongitude(Float.parseFloat(ville[3].replaceAll(",",".")));
                    v.setLatitude(Float.parseFloat(ville[4].replaceAll(",",".")));
                    System.out.println(v.toString());
                    villes.add(v);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return villes;

    }
    
    public void setAdresse(String s){
        adresse = s;
    }
}
