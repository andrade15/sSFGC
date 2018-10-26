/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;

/**
 *
 * @author OSVALDO
 */

//Criei essa interface para usar em chaves primarias do tipo String
public interface DAOinterface2 <V,S>{
    
    
        public V inserir(V v);
    
    public void Update( V v);
    
    public void delete(S i);
    
  
    public List<V> listar();
    
    public V listarPorID(S s);
    
    
    
    
    
    
    
}
