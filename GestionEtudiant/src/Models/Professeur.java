/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;

/**
 *
 * @author Daniel
 */
public class Professeur extends User{
  private String grade;
  private String mat;

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }
  //un professeur a plusieurs matières donc on va les mettre dans une liste
  private List<String> matieres;

    public Professeur() {
        type="Professeur";
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<String> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<String> matieres) {
        this.matieres = matieres;
    }

    @Override
    public String toString() {
        return super.toString()+"Professeur{" + "grade=" + grade + ", matieres=" + matieres + '}';
    }

    public int compareTo(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
  
}
