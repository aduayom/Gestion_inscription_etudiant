/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cours;

import Models.Etudiant;
import Models.Professeur;
import Models.User;
import dao.Mysql;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        System.out.println("bonjour monsieur");
        //Créer un nouveau utilisateur
        //User u=new User();)=>user est abstract donc on a une erreur
        //polymorphisme d'objet
        User u =new Etudiant();
        //on va faire du dowcasting 
        ((Etudiant)u).getTuteur();
        //declaration de liste
        List<String>lString=new ArrayList();
        lString.add("Bonjour");
        lString.add("a");
        lString.add("Tous");
        //Afficher la liste:
        for(String s:lString){
            System.out.println(s);
        }
        //liste des users et ajouter un nouvel user dans la liste
        List<User>lUser=new ArrayList();
        lUser.add(new Etudiant());
        lUser.add(new Professeur());
         for(User user:lUser){
            System.out.println(user);
        }*/
        Mysql mysql =new Mysql();
        mysql.connexionBD();
    }
    
}
