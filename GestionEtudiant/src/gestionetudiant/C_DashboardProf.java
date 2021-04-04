/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiant;

import Models.Classe;
import Models.Professeur;
import Service.GestionEtudiantImpl;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class C_DashboardProf implements Initializable {
    private GestionEtudiantImpl service =new GestionEtudiantImpl();
    @FXML
    private TableView<Classe> tblv_Classe;
    @FXML
    private TableColumn<?, ?> tblc_id;
    @FXML
    private TableColumn<?, ?> tblc_Libelle;
    @FXML
    private TableView<Professeur> tblv_professeurs;
    @FXML
    private TableColumn<?, ?> tblc_matiere;
    @FXML
    private TableColumn<?, ?> tblc_nomprenom;
    @FXML
    private Pane pane_addclasse;
    private ObservableList<Classe> obvClasse;
    private ObservableList<Professeur> obvProfs;
    @FXML
    private TableColumn<?, ?> tblc_grade;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Professeur> listeProfs = service.listerProfs();
        System.out.println("la liste des profs "+ listeProfs);
        obvProfs=FXCollections.observableArrayList(listeProfs);
        tblc_grade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        tblc_nomprenom.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        tblc_matiere.setCellValueFactory(new PropertyValueFactory<>("mat"));
        tblv_professeurs.setItems(obvProfs);
        
        
        obvClasse=FXCollections.observableArrayList(service.listerClasse());
        tblc_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblc_Libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        tblv_Classe.setItems(obvClasse);
    }    

    @FXML
    private void handle_ListEtudiantParClasse(MouseEvent event) {
    }
    
}
