/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Models.Classe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class ClasseDao implements IDao<Classe> {
    //Les différentes requètes sont définis ici
    private final String SQL_SELECT_ALL="SELECT * FROM `classe`";
    private final String SQL_SELECT_CLASSE_BY_LIBELLE="select * from classe where libelle=?";
    private final String SQL_INSERT="INSERT INTO `classe` (`libelle`) VALUES (?);";
    
    //pour se connecter il doit créer un objet de type mysql
    private Mysql mysql=new Mysql();
    
    @Override
    public int insert(Classe objet) {
        int id=0;
        //1-connexion a une BD
        mysql.connexionBD();
        try {
            mysql.initPreparedStatement(SQL_INSERT);
            //2-Preparer la requette
            mysql.getPs().setString(1, objet.getLibelle());
            //3-executer la requette //4-Recuperation des resultats
            mysql.executeMaj();
            ResultSet rs = mysql.getPs().getGeneratedKeys();
            rs.next();
            id=rs.getInt(1);
            mysql.fermerBD();
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public int update(Classe objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Classe> selectAll() {
         List <Classe> lClasses=null;
        //1-connexion a une BD
        mysql.connexionBD();
            //3-executer la requette 
            ResultSet rs = mysql.executeSelect(SQL_SELECT_ALL);
        try {
            //4-Recuperation des resultats
            lClasses=new ArrayList<>();
            while (rs.next()){
                Classe cl =new Classe();
                //recupérer id que l'on stocke dans l'objet cl
                cl.setId(rs.getInt("id"));
                cl.setLibelle(rs.getString("libelle"));
                lClasses.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            mysql.fermerBD();
        
        return lClasses;
    }
    
    
    public Classe selectClasseByLibelle(String libelle){
         Classe cl=null;
        //1-connexion a une BD
        mysql.connexionBD();
        try {
            mysql.initPreparedStatement(SQL_SELECT_CLASSE_BY_LIBELLE);
            mysql.getPs().setString(1, libelle);
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            //3-executer la requette 
            ResultSet rs = mysql.executeSelect();
        try {
            //4-Recuperation des resultats
            if(rs.next()){
                cl =new Classe();
                cl.setId(rs.getInt("id"));
                cl.setLibelle(rs.getString("libelle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            mysql.fermerBD();
        
        return cl;
    }
}
