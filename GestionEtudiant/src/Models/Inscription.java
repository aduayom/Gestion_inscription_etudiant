/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.LocalDate;

/**
 *
 * @author Daniel
 */
public class Inscription {
    private int id;
    private LocalDate createAt;
    private String année;
    //Navigabilité
    private Etudiant etu;
    private Classe classe;

    public Inscription() {
    }

    public Inscription(String année, Etudiant etu, Classe classe) {
        this.année = année;
        this.etu = etu;
        this.classe = classe;
        this.createAt=LocalDate.now();
    }
    
    public Etudiant getEtu() {
        return etu;
    }

    public void setEtu(Etudiant etu) {
        this.etu = etu;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public String getAnnée() {
        return année;
    }

    public void setAnnée(String année) {
        this.année = année;
    }
  
}
