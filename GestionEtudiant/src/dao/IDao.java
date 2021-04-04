/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Daniel
 */
public interface IDao<t> {
    //dire à l'interface qu'il est générique
    public int insert(t objet);
    public int update(t objet);
    public int delete(int id);
    public List<t> selectAll();
  
    
}
