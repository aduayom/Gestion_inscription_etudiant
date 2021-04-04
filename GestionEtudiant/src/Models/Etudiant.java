/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Daniel
 */
public class Etudiant extends User{
    private String tuteur;
    private String matricule;
    public Etudiant() {
        type="Etudiant";
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getTuteur() {
        return tuteur;
    }

    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }
    //super permet de faire appek a la methode affiche =tostring de la classe mére
    @Override
    public String toString() {
        return super.toString()+"Etudiant{" + "tuteur=" + tuteur + '}';
    }
    
}
