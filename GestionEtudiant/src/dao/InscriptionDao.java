/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Models.Inscription;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class InscriptionDao implements IDao<Inscription> {
     private final String SQL_INSERT="INSERT INTO `inscription` ( `create_at`, `annee`, `classe_id`, `etudiant_id`) VALUES (?, ?, ?, ?);";
     private Mysql mysql=new Mysql();
     @Override
    public int insert(Inscription objet) {
        int nbreLigne=0;
        return nbreLigne;
    }

    @Override
    public int update(Inscription objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int insert(String annee, int id_Etu, int id_Classe) {
       int id=0;
        //1-connexion a une BD
        mysql.connexionBD();
        try {
            mysql.initPreparedStatement(SQL_INSERT);
            //2-Preparer la requette
            mysql.getPs().setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
            mysql.getPs().setString(2, annee);
            mysql.getPs().setInt(3, id_Classe);
            
            mysql.getPs().setInt(4,id_Etu );
            //3-executer la requette //4-Recuperation des resultats
            mysql.executeMaj();
            ResultSet rs = mysql.getPs().getGeneratedKeys();
            rs.next();
            id=rs.getInt(1);
            
            System.out.println("l'inscription réussi");
            mysql.fermerBD();
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
        
}
