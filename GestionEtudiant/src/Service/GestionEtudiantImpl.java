/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.Classe;
import Models.Etudiant;
import Models.Inscription;
import Models.Professeur;
import Models.User;
import dao.ClasseDao;
import dao.InscriptionDao;
import dao.UserDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class GestionEtudiantImpl implements IGestionEtudiant {
    private ClasseDao daoClasse = new ClasseDao();
    private UserDao daoUser = new UserDao();
    private InscriptionDao daoInscription = new InscriptionDao();
    @Override
    public List<Classe> listerClasseEnseignat(Classe cl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inscrireEtudiant(Etudiant etu, Classe cl,String annee) {
        if(etu.getId()==0){
            System.out.println("Nouvel utilisateur");
            String mat=generateMatricule();;
            etu.setMatricule(mat);
            int id=daoUser.insert(etu);
            etu.setId(id);
        }
        Inscription ins = new Inscription(annee, etu,cl);
        System.out.println("création d'une inscription");
        return daoInscription.insert(annee,etu.getId(),cl.getId())!=0;
    }
    
    private String generateMatricule(){
        String matricule="MAT";
        return matricule;
    }

    @Override
    public int addClasse(Classe cl) {
        return daoClasse.insert(cl);
    }

    @Override
    public boolean affecterProfesseur(Professeur prof, Classe cl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifierClasse(Classe cl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User seConnecter(String login, String pwd) {
        return daoUser.selectUserByLoginAndPwd(login,pwd);
    }

    @Override
    public List<Classe> listerClasse() {
       return daoClasse.selectAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean rechercherClasseByLibelle(String libelle) {
        return daoClasse.selectClasseByLibelle(libelle)!=null;
    }

    @Override
    public boolean rechercherEtudiantParMatricule(String matricule) {
     return daoUser.selectEtudiant(matricule)!=null;
    }

    @Override
    public List<Etudiant> listerEtudiantParClasse(Classe cl, String annee) {
        return daoUser.selectEtudiantByClasseParAnnee(cl, annee);
    }

    @Override
    public List<String> getAnneeScolaire() {
        List<String> lAnneeScolaire = new ArrayList<>();
        lAnneeScolaire.add("2020-2021");
        lAnneeScolaire.add("2019-2020");
        lAnneeScolaire.add("2018-2019");
        lAnneeScolaire.add("2017-2018");
        return lAnneeScolaire;
    }

    @Override
    public Boolean inscrireUser() {
         return daoInscription.insert("2021", 1, 1)!=0;
    }

    @Override
    public boolean inscrireProf(Professeur pr) {
      if(pr.getId()==0){
            int id=daoUser.insert(pr);
            pr.setId(id);
        }
        return pr.getId() != 0;
    }

    @Override
    public List<Professeur> listerProfs() {
       return daoUser.selectProfesseurs() ;
    }
    
}
