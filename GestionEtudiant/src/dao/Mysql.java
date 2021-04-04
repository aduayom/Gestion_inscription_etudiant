/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Mysql implements IDatabase{
    
    private Connection cnx =null;
    private PreparedStatement ps;

    public PreparedStatement getPs() {
        return ps;
    }
    
    @Override
    public void connexionBD() {
        try {
            //1-chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            //2-ouvrir connexion
                cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_etudiant","root","");
                    } catch (ClassNotFoundException ex) {
            System.out.println("erreur de chargement du driver");
        } catch (SQLException ex) {
            System.out.println("erreur de connexion à la base de donnée");
        }
    }

    @Override
    public void fermerBD() {
        if (cnx!=null){
            cnx=null;
        }
    }

    @Override
    public ResultSet executeSelect(String sql) {
        ResultSet rs=null;
        initPreparedStatement(sql);
        System.out.println(sql);
        try {
            rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    @Override
    public int executeMaj(String sql) {
        int nbreLigne=0;
        initPreparedStatement(sql);
        try {
            nbreLigne=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nbreLigne;
    }

    @Override
    public void initPreparedStatement(String sql) {
         try {
            if(sql.toLowerCase().startsWith("insert")){
                ps=cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            }else{
                 ps=cnx.prepareStatement(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ResultSet executeSelect() {
        ResultSet rs=null;
        try {
            System.out.println(ps);
            rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    @Override
    public int executeMaj() {
         int nbreLigne=0;
        try {
            nbreLigne=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nbreLigne;
    }
    
}
