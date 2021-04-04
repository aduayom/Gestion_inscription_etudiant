/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiant;

import Models.Classe;
import Models.Etudiant;
import Models.User;
import Service.GestionEtudiantImpl;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author Daniel
 */
public class C_Classe implements Initializable {
    
    
    private GestionEtudiantImpl service =new GestionEtudiantImpl();
    private static User userconnect=C_connexionController.getUser();; 
    @FXML
    private ComboBox<String> cbo_AnneeScolaire;
    private ObservableList<String> obvAnneeScolaire;
    private ObservableList<Classe> obvClasse;
    private ObservableList<Etudiant> obvEtudiant;
    @FXML
    private TableView<Classe> tblv_Classe;
    @FXML
    private TableColumn<Classe, String> tblc_id;
    @FXML
    private TableColumn<Classe, String> tblc_Libelle;
    @FXML
    private TextField txt_Libelle;
    @FXML
    private TableView<Etudiant> tblv_etudiant;
    @FXML
    private TableColumn<Etudiant, String> tblc_matricule;
    @FXML
    private TableColumn<Etudiant, String> tblc_nomprenom;
    @FXML
    public Pane pane_addclasse;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> lAnneeScolaire= service.getAnneeScolaire();
        //CONVERTIR UN  ARRAY LIST EN OBSERVABLE
        obvAnneeScolaire=FXCollections.observableArrayList(lAnneeScolaire);
        cbo_AnneeScolaire.setItems(obvAnneeScolaire);
        //Selectionner le 1er element
        cbo_AnneeScolaire.getSelectionModel().selectFirst();
        
        obvClasse=FXCollections.observableArrayList(service.listerClasse());
        tblc_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblc_Libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        tblv_Classe.setItems(obvClasse);
        
    }    

    @FXML
    private void handle_InsertClasse(ActionEvent event) {
        String libelle=txt_Libelle.getText().trim();
        if (libelle.compareTo("")==0){
            //ici on définit une erreur en cas de non validation 
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("libelle obligatoire");
            alert.showAndWait();
        }else{
            if(service.rechercherClasseByLibelle(libelle)){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setContentText("libelle existe déjà");
                alert.showAndWait();
            }else {
                //enregistrement de la classe tout est ok
                Classe cl = new Classe();
                cl.setLibelle(libelle);
                int id=service.addClasse(cl);
                if(id !=0){
                    cl.setId(id);
                    obvClasse.add(cl);
                     Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setContentText("classe enregistré avec succès");
                    alert.showAndWait();
                }
                
            }
        }
    }

    @FXML
    private void handle_ListEtudiantParClasse(MouseEvent event) {
        String annee=cbo_AnneeScolaire.getSelectionModel().getSelectedItem();
        Classe cl = tblv_Classe.getSelectionModel().getSelectedItem();
        List<Etudiant> lEtudiant=service.listerEtudiantParClasse(cl, annee);
        obvEtudiant=FXCollections.observableArrayList(lEtudiant);
        tblc_matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        tblc_nomprenom.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        tblv_etudiant.setItems(obvEtudiant);
        }
        
    
}
