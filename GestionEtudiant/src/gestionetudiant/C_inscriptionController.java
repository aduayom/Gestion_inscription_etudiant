/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiant;

import Models.Classe;
import Models.Etudiant;
import Service.GestionEtudiantImpl;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class C_inscriptionController implements Initializable {
    private GestionEtudiantImpl service =new GestionEtudiantImpl();
    
    @FXML
    private TextField txt_Id;
    @FXML
    private TextField txt_NomComplet;
    @FXML
    private TextField txt_tuteur;
    private ObservableList<Classe> obvClasse;
    
    @FXML
    private ComboBox<String> cmb_annescolaire;
    private ObservableList<String> obvAnneeScolaire;
    @FXML
    private TableView<Classe> tblv_Classe2;
    @FXML
    private TableColumn<Classe, String> tblc_id2;
    @FXML
    private TableColumn<Classe, String> tblc_Libelle2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> lAnneeScolaire= service.getAnneeScolaire();
        //CONVERTIR UN  ARRAY LIST EN OBSERVABLE
        obvAnneeScolaire=FXCollections.observableArrayList(lAnneeScolaire);
        cmb_annescolaire.setItems(obvAnneeScolaire);
        //Selectionner le 1er element
        cmb_annescolaire.getSelectionModel().selectFirst();

       obvClasse=FXCollections.observableArrayList(service.listerClasse());
        tblc_id2.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblc_Libelle2.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        tblv_Classe2.setItems(obvClasse);
        txt_Id.setText("0");
    }    

    @FXML
    private void handle_Ajouter(ActionEvent event) {
        System.out.println(" creer");
        String nomComplet = txt_NomComplet.getText();
        String tuteur = txt_tuteur.getText();
        int id=Integer.valueOf(txt_Id.getText()); 
        System.out.println(id);
        Etudiant newEtu = new Etudiant();
        newEtu.setNomComplet(nomComplet);
        newEtu.setTuteur(tuteur);
        newEtu.setId(id);
        //newEtu.setMatricule(newEtu.);
        
        /*
        List<Etudiant> listeEtudiants = serviceEtu.listerEtu();
        System.out.println(listeEtudiants);
        
       
        System.out.println(listeEtudiants.get(listeEtudiants.size() - 1));
   */
        
        Classe classe = tblv_Classe2.getSelectionModel().getSelectedItem();
        String anneeSco = cmb_annescolaire.getValue();
        
        
        System.out.println(tuteur.compareTo(""));
        if(nomComplet.compareTo("") == 0 || tuteur.compareTo("") == 0){
             Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR");
             alert.setContentText("Verifiez que tous les champs sont remplis");   
              alert.showAndWait();
             return ;
        }
        
        System.out.println(nomComplet);
        System.out.println(tuteur);
        System.out.println(classe);
        System.out.println(anneeSco);
        System.out.println();
        
        Boolean test = service.inscrireEtudiant(newEtu, classe, anneeSco);
        
        if(test) {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("SUCCES");
            if(id == 0 ){
             alert.setContentText("Inscription reussi");   
            }
            else{
                alert.setContentText("Reinscription reussie");
            }
            
            alert.showAndWait();
        }
        
    }

    @FXML
    private void handle_ListEtudiantParClasse(MouseEvent event) {
    }
    
}
