/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiant;

import Models.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class C_Dashboard implements Initializable {
    private static User userconnect;
    @FXML
    private Button btn_deconnexion;
    @FXML
    private AnchorPane anchor_container;
    @FXML
    private Text txt_nomprenom;
    @FXML
    private Text text_profil;
    @FXML
    private TitledPane menu_classe;
    @FXML
    private TitledPane menu_inscription;
    @FXML
    private TitledPane menu_professeur;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userconnect=C_connexionController.getUser();
        txt_nomprenom.setText(userconnect.getNomComplet());
        text_profil.setText(userconnect.getType());
        //menu_classe.setCollapsible(false);
        if(userconnect.getType().compareTo("AC")==0){
             menu_inscription.setCollapsible(false);
             menu_professeur.setCollapsible(false);
        }
    }    

    @FXML
    private void handleDeconnexion(ActionEvent event) {
        //changement de page 
        //il faut d'abord cacher la fenetre en cours
        btn_deconnexion.getScene().getWindow().hide();
                //chargement de la fenetre de destination
                AnchorPane layout;
                try {
                    layout = FXMLLoader.load(getClass().getResource("V_connexion.fxml"));
                      Scene scene = new Scene(layout);
                      Stage stage= new Stage();
                      stage.setScene(scene);
                      stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(C_connexionController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void handleLoadViewClasse(ActionEvent event) {
         AnchorPane layout;
                try {
                    layout = FXMLLoader.load(getClass().getResource("V_classe.fxml"));
                    anchor_container.getChildren().clear();
                    anchor_container.getChildren().add(layout);
                     if(userconnect.getType().compareTo("AC")==0){
                            layout.getChildren().get(0).setVisible(false);
                       }if(userconnect.getType().compareTo("RP")==0){
                             layout.getChildren().get(0).setVisible(true);
                        }
                } catch (IOException ex) {
                    Logger.getLogger(C_connexionController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
    }

    @FXML
    private void handleLoadViewInscription(ActionEvent event) {
         AnchorPane layout;
                try {
                    layout = FXMLLoader.load(getClass().getResource("V_inscription.fxml"));
                    anchor_container.getChildren().clear();
                    anchor_container.getChildren().add(layout);
                     if(userconnect.getType().compareTo("AC")==0){
                            layout.getChildren().get(0).setVisible(false);
                       }if(userconnect.getType().compareTo("RP")==0){
                             layout.getChildren().get(0).setVisible(true);
                        }
                } catch (IOException ex) {
                    Logger.getLogger(C_connexionController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void handle_ajout(ActionEvent event) {
        AnchorPane layout;
                try {
                    layout = FXMLLoader.load(getClass().getResource("V_ajoutprof.fxml"));
                    anchor_container.getChildren().clear();
                    anchor_container.getChildren().add(layout);
                     if(userconnect.getType().compareTo("AC")==0){
                            layout.getChildren().get(0).setVisible(false);
                       }if(userconnect.getType().compareTo("RP")==0){
                             layout.getChildren().get(0).setVisible(true);
                        }
                } catch (IOException ex) {
                    Logger.getLogger(C_connexionController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void handle_listerProf(ActionEvent event) {
        AnchorPane layout;
                try {
                    layout = FXMLLoader.load(getClass().getResource("V_listerprof.fxml"));
                    anchor_container.getChildren().clear();
                    anchor_container.getChildren().add(layout);
                     if(userconnect.getType().compareTo("AC")==0){
                            layout.getChildren().get(0).setVisible(false);
                       }if(userconnect.getType().compareTo("RP")==0){
                             layout.getChildren().get(0).setVisible(true);
                        }
                } catch (IOException ex) {
                    Logger.getLogger(C_connexionController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
}
