/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import graph.*;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import visual.visuGraph;

/**
 * FXML Controller class
 *
 * @author Axel
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField textPop;
    @FXML
    private TextField textDist;
    @FXML
    private Button butGraphNorm;
    @FXML
    private TextArea error;
    @FXML
    private ComboBox<String> choiceDep;
    @FXML
    private ComboBox<String> choiceFin;
    @FXML
    private Button affSimple;
    @FXML
    private TextArea textChem;
    @FXML
    private Button affGraph;
    @FXML 
    private CheckBox affich;
    
    private ArrayList<Ville> villes;
    ArrayList<String> ids;
    private Graphe g;
    private Boolean graphok = false;
    private int pop;
    private int dist;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handlebutGraphNormAction(ActionEvent event) {
        if(!isInteger(textPop.getText())){
            error.setText("La population n'est pas un int");
        }else if(Integer.parseInt(textPop.getText())>2243833){
            error.setText("Population supérieure à celle de la ville de Paris");
        }else if(!isInteger(textDist.getText())){
            error.setText("La distance n'est pas un int");
        }else if(Integer.parseInt(textDist.getText())>40075000){
            error.setText("Distance supérieure au contour de la Terre");
        }else {
            pop = Integer.parseInt(textPop.getText());
            dist = Integer.parseInt(textDist.getText());
            CSVReader reader = new CSVReader();
            villes = reader.getFromCSV(Integer.parseInt(textPop.getText()));
            ids = new ArrayList<String>();
            for(int i=0; i<villes.size();i++){
                ids.add(villes.get(i).getId());
            }
            System.out.println("Avant création graphe");
            g = new Graphe(villes, Integer.parseInt(textDist.getText()));
            graphok = true;
            System.out.println("Après création graphe");
            if(affich.isSelected()){
                visuGraph vg = new visuGraph(g);
                System.out.println("Après création visugraphe");
                vg.afficher();
                System.out.println("Après affichage");
            }
            error.setText("Votre graphe a bien été créé, on travaille sur celui créé à cet instant");
            ObservableList<String> idsobs = FXCollections.observableArrayList(ids);
            choiceDep.setItems(idsobs);
            choiceFin.setItems(idsobs);
        }
    }
    
    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
         return true;
    }
    
    @FXML
    private void handlebutaffSimpleAction(ActionEvent event) {
        if(graphok){
            Matrice mat = new Matrice(g);
            Dijkstra dij = new Dijkstra(mat);
            ArrayList<Sommet> chem =dij.Chemin(mat.getSommetbyName(choiceDep.getValue()) , mat.getSommetbyName(choiceFin.getValue()));
            String rep = dij.printChemin();
            textChem.appendText(rep+"\n");
            String val = "C'est une chemin qui mesure " + dij.valPlusCourtChemin();
            textChem.appendText(val+"\n");
        }else {
            if(!isInteger(textPop.getText())){
                error.setText("La population n'est pas un int");
            }else if(Integer.parseInt(textPop.getText())>2243833){
                error.setText("Population supérieure à celle de la ville de Paris");
            }else if(!isInteger(textDist.getText())){
                error.setText("La distance n'est pas un int");
            }else if(Integer.parseInt(textDist.getText())>40075000){
            error.setText("Distance supérieure au contour de la Terre");
            }else {
            CSVReader reader = new CSVReader();
            ArrayList<Ville> villes = reader.getFromCSV(Integer.parseInt(textPop.getText()));
            System.out.println("Avant création graphe");
            g = new Graphe(villes, Integer.parseInt(textDist.getText()));
            System.out.println("Après création graphe");
            Matrice mat = new Matrice(g);
            Dijkstra dij = new Dijkstra(mat);
            dij.Chemin(mat.getSommetbyName(choiceDep.getValue()) , mat.getSommetbyName(choiceFin.getValue()));
            String rep = dij.printChemin();
            textChem.appendText(rep+"\n");
            String val = "C'est une chemin qui mesure" + dij.valPlusCourtChemin();
            textChem.appendText(val);
            
            }
        }
            
    }
    
    @FXML
    private void handlebutaffDijAction(ActionEvent event) {
        if(graphok){
            Matrice mat = new Matrice(g);
            Dijkstra dij = new Dijkstra(mat);
            ArrayList<Sommet> chem =dij.Chemin(mat.getSommetbyName(choiceDep.getValue()) , mat.getSommetbyName(choiceFin.getValue()));
            String rep = dij.printChemin();
            textChem.appendText(rep+"\n");
            String val = "C'est une chemin qui mesure " + dij.valPlusCourtChemin();
            textChem.appendText(val);
            visuGraph vg = new visuGraph(g);
            if(chem ==null){
                vg.afficher();
            }else{
                vg.afficher(chem);
            }
        }else {
            if(!isInteger(textPop.getText())){
                error.setText("La population n'est pas un int");
            }else if(Integer.parseInt(textPop.getText())>2243833){
                error.setText("Population supérieure à celle de la ville de Paris");
            }else if(!isInteger(textDist.getText())){
                error.setText("La distance n'est pas un int");
            }else if(Integer.parseInt(textDist.getText())>40075000){
            error.setText("Distance supérieure au contour de la Terre");
            }else {
            CSVReader reader = new CSVReader();
            ArrayList<Ville> villes = reader.getFromCSV(Integer.parseInt(textPop.getText()));
            System.out.println("Avant création graphe");
            g = new Graphe(villes, Integer.parseInt(textDist.getText()));
            System.out.println("Après création graphe");
            Matrice mat = new Matrice(g);
            Dijkstra dij = new Dijkstra(mat);
            dij.Chemin(mat.getSommetbyName(choiceDep.getValue()) , mat.getSommetbyName(choiceFin.getValue()));
            String rep = dij.printChemin();
            textChem.appendText(rep+"\n");
            String val = "C'est une chemin qui mesure" + dij.valPlusCourtChemin();
            textChem.appendText(val);
            
            }
        }
            
    }
    
    
}
