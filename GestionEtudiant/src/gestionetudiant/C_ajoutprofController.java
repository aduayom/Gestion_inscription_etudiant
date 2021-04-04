/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiant;

import Models.Professeur;
import Service.GestionEtudiantImpl;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class C_ajoutprofController implements Initializable {
    private GestionEtudiantImpl service =new GestionEtudiantImpl();
    @FXML
    private TextField txt_nomprenom;
    @FXML
    private TextField txt_grade;
    @FXML
    private TextField txt_matiere;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_ajout(ActionEvent event) {
        System.out.println(" ajouter");
        
        String nomComplet =txt_nomprenom.getText();
        String grade = txt_grade.getText();
        String matieres = txt_matiere.getText();
        
        System.out.println(nomComplet);
        System.out.println(grade);
        // Python Django Flutter
        
        String[] listMat = matieres.split(" ");
        
        
        Professeur pr = new Professeur();
        pr.setNomComplet(nomComplet);
        pr.setGrade(grade);
        pr.setMatieres(Arrays.asList(listMat));
        pr.setMat(matieres);
        
        System.out.println("le prof "+pr);
         if (nomComplet.compareTo("") == 0 || grade.compareTo("")==0 || matieres.compareTo("")==0) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Verifiez les champs");
            alert.setContentText("Certains champs sont vides ");
            alert.showAndWait();
            return;
        }
        
        service.inscrireProf(pr);
   
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setContentText("Inscription du prof reussite ");
            alert.showAndWait();
    }
    
}
