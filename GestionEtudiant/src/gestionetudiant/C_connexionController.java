/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiant;

import Models.User;
import Service.GestionEtudiantImpl;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class C_connexionController implements Initializable {
    private GestionEtudiantImpl service =new GestionEtudiantImpl();
    private static User user; 
    @FXML
    private TextField txt_login;
    @FXML
    private PasswordField txt_password;
    @FXML
    private Text txt_error;

    public static User getUser() {
        return user;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //pour cacher le message d'erreur 
        txt_error.setVisible(false);
    }    

    @FXML
    private void handleConnexion(ActionEvent event) {
        String login=txt_login.getText();
        String pwd=txt_password.getText();
        if(login.compareTo("")!=0 && pwd.compareTo("")!=0){
             user =service.seConnecter(login, pwd);
            if(user==null){
                txt_error.setText("Login ou mot de passe incorrect");
                txt_error.setVisible(true);
            }else{
                txt_error.getScene().getWindow().hide();
                AnchorPane layout;
                try {
                    layout = FXMLLoader.load(getClass().getResource("V_Dashboard.fxml"));
                      Scene scene = new Scene(layout);
                      Stage stage= new Stage();
                      stage.setScene(scene);
                      stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(C_connexionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            txt_error.setText("Login ou mot de passe obligatoire");
            txt_error.setVisible(true);
        }
        
    }
    
}
