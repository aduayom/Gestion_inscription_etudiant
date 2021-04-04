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
public abstract class User {
    //pour dire que la class est abstraite on met "abstract"
    //les attributs de user 
    protected int id;
    protected String nomComplet;
    protected String login;
    protected String pwd;
    protected String photo;
    protected String type;
    //generer un contructeur=clic droit->insert code->construct->et on ne choisit rien
    public User() {
    }
     //generer getters&setters=clic droit->insert code->getters and setters->on coche tout
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

        public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    /* pour afficher on utilise la method toString qui permet de faire une serialisation:l'objet est 
    transformer en chaine*/
    //Override veut dire que cette methode est hérité et redefini
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nomComplet=" + nomComplet + ", login=" + login + ", pwd=" + pwd + ", photo=" + photo + '}';
    }
    
}
