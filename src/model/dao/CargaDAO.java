/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.entidade.Carga;

/**
 *
 * @author Mic
 */
public class CargaDAO implements DAOinterface<Carga,Integer> {
    

    
     Connection con;
    
    public CargaDAO()
    { con=BDconexao.getConnection();  }

    @Override
    public Carga inserir(Carga ca) {
          String sql="INSERT INTO carga(peso,tipo,valor,idCliente) values(?,?,?,?)";
        PreparedStatement stmt=null;
        
        try
        {
           stmt=con.prepareStatement(sql);
            stmt.setFloat(1,ca.getPeso());
            stmt.setString(2,ca.getTipo());
            stmt.setFloat(3,ca.getValor());
            stmt.setInt(4,ca.getIdCliente());
           stmt.executeUpdate();
            stmt.close();
      
        JOptionPane.showMessageDialog(null," Carga Registada com sucesso");
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
        
        return ca;
        
    }

    
    public void Update(Carga ca) { 
        
            String sql;
        sql = "UPDATE carga set peso=?,tipo=?,valor=?,idCliente=? WHERE idCarga=?";
        PreparedStatement stmt = null;
        try
        {
         stmt=con.prepareStatement(sql);
            stmt.setFloat(1,ca.getPeso());
            stmt.setString(2,ca.getTipo());
            stmt.setFloat(3,ca.getValor());
            stmt.setInt(4,ca.getIdCliente());
            stmt.setInt(1,ca.getIdCarga());
             stmt.executeUpdate();
            stmt.close();
         
        JOptionPane.showMessageDialog(null,"Carga Actualizado com sucesso");
        }catch(SQLException ex){
        Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
     }
    
     public void delete(Integer i) {
     String sql="Delete carga Where idCarga=?";
     PreparedStatement stmt=null;
     try{
         stmt=con.prepareStatement(sql);
          stmt.executeUpdate();
          stmt.setInt(1,i);
          stmt.close();
         JOptionPane.showMessageDialog(null,"EXCLUIDO COM SUCESSO");
    }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
    
 }
    
      @Override
    public List<Carga> listar() {
          String sql="SELECT *FROM carga";
       PreparedStatement stmt=null;
       ResultSet rs=null;
       List<Carga>cargas=new ArrayList();
       
       try{
           stmt=con.prepareStatement(sql);
           rs=stmt.executeQuery();
           while(rs.next())
           {
            Carga ca=new Carga();
            ca.setIdCarga(rs.getInt("idCarga"));
            ca.setPeso(rs.getFloat("peso"));
            ca.setTipo(rs.getString("tipo"));
            ca.setValor(rs.getFloat("Valor"));
             cargas.add(ca);
           }
       stmt.close();
       rs.close();
       }catch(SQLException ex){
       Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
       }
       return cargas;
    }
       
        
   public Carga listarPorID(Integer i) {
      String sql="SELECT *FROM carga where idCarga=?";
       PreparedStatement stmt=null;
       ResultSet rs=null;
         Carga ca=new Carga();
       try{
           stmt=con.prepareStatement(sql);
           stmt.setInt(1,i);
           rs=stmt.executeQuery();
           while(rs.next())
           {
           
            ca.setIdCarga(rs.getInt("idCarga"));
            ca.setPeso(rs.getFloat("peso"));
            ca.setTipo(rs.getString("tipo"));
            ca.setValor(rs.getFloat("Valor"));
           }
       stmt.close();
       rs.close();
       }catch(SQLException ex){
       Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
       }
       return ca;
    
    
   }

  
}
