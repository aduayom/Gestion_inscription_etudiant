/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Affectation {
    private int annee;
    private LocalDate creatAt;
    //list est une interface
    private List<String> matieresEnseignees;
    //Navigabilité
    private Professeur prof;
    private Classe classe;

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public LocalDate getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(LocalDate creatAt) {
        this.creatAt = creatAt;
    }

    public List<String> getMatieresEnseignees() {
        return matieresEnseignees;
    }

    public void setMatieresEnseignees(List<String> matieresEnseignees) {
        this.matieresEnseignees = matieresEnseignees;
    }

    public Professeur getProf() {
        return prof;
    }

    public void setProf(Professeur prof) {
        this.prof = prof;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
}
