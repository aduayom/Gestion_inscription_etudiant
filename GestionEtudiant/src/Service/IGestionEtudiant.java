/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.Classe;
import Models.Etudiant;
import Models.Professeur;
import Models.User;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface IGestionEtudiant {
    public List <Classe> listerClasseEnseignat(Classe cl);
    public boolean inscrireEtudiant(Etudiant etu,Classe cl,String annee);/* methode pour inscrire etudiat et professeur*/
    //les methodes qui font insertion doivent retourner un entier qui représente le dernier id
    public int addClasse(Classe cl);/**/ 
    public List <Classe> listerClasse();/**/ 
    public List <Professeur> listerProfs();
    public boolean affecterProfesseur(Professeur prof,Classe cl);
    public boolean modifierClasse(Classe cl);
    public User seConnecter(String login, String pwd);/**/ 
    public boolean rechercherClasseByLibelle(String libelle);
    public boolean rechercherEtudiantParMatricule(String matricule);
    public List<Etudiant> listerEtudiantParClasse(Classe cl,String annee);/**/ 
    public List<String> getAnneeScolaire();
    public Boolean inscrireUser();
    public boolean inscrireProf(Professeur pr);
}
