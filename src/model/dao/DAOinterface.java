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
public interface DAOinterface<V,I> {
    
    
    public V inserir(V v);
    
    public void Update( V v);
    
    public void delete(I i);
    
  
    public List<V> listar();
    
    public List listarPorID(I i);
    
    
    
}
