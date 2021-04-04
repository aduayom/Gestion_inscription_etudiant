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
public class Classe {
    private int id;
    private String libelle;
    /*propriéte static =propriété dont la valeur ne change pas elle est appelée 
    directement à travers la classe*/
    private  static int nbreEtuMax;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public static int getNbreEtuMax() {
        return nbreEtuMax;
    }

    public static void setNbreEtuMax(int nbreEtuMax) {
        Classe.nbreEtuMax = nbreEtuMax;
    }
    
    
}
