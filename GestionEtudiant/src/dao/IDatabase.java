/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;

/**
 *
 * @author Daniel
 */
public interface IDatabase {
    public void connexionBD();
    public void fermerBD();
    public ResultSet executeSelect(String sql);
    public int executeMaj (String sql);
    public ResultSet executeSelect();
    public int executeMaj ();
    public void initPreparedStatement(String sql);
    
}
