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
import model.entidade.Cliente;
import model.entidade.Viagem;

/**
 *
 * @author Mic
 */
public class ClienteDAO implements DAOinterface<Cliente,Integer> {
    Connection con;
    
    public ClienteDAO()
    { con=BDconexao.getConnection();  }

    
    public Cliente inserir(Cliente cli) {
        String sql;
        sql = "CALL novoCliente (?,?,?)";
        PreparedStatement stmt = null;
        try
        {
        stmt=con.prepareStatement(sql);
        stmt.setString(1,cli.getNome());
        stmt.setString(2,cli.getProvincia());
         stmt.setString(3,cli.getDistrito());
         //stmt.setInt(4,cli.getTotalValor());
       //stmt.setInt(5,cli.getTotalSolicitacoes());

        stmt.executeUpdate();
        stmt.close();
      
        JOptionPane.showMessageDialog(null," Cliente Registado com sucesso");
        
        }catch(SQLException ex){System.out.println(ex);}
       
        return cli;
    }

   
    public void Update(Cliente cli) {
        String sql="UPDATE cliente set nome=?,provincia=?,distrito=?,TotalValor=?,TotalSolicitacoes=? WHERE idCliente=?";
        PreparedStatement stmt = null;
        
        try
        {
        stmt=con.prepareStatement(sql);
        stmt.setString(1,cli.getNome());
        stmt.setString(2,cli.getProvincia());
        stmt.setString(3,cli.getDistrito());
        stmt.setInt(4,cli.getTotalValor());
        stmt.setInt(5,cli.getTotalSolicitacoes());
        stmt.setInt(6,cli.getIdCliente());
        stmt.executeUpdate();
        stmt.close();
      
        JOptionPane.showMessageDialog(null," Cliente Actualizado com sucesso");
        }catch(SQLException ex){
        Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
      
    }

    
    public void delete(Integer i) 
    {
     String sql="DELETE FROM cliente WHERE idCliente=?";
      PreparedStatement stmt=null;
       try{
          stmt=con.prepareStatement(sql);
          stmt.setInt(1, i);
          stmt.executeUpdate();
         
          stmt.close();
        JOptionPane.showMessageDialog(null,"Excluido com suceesso");
        
       }catch(SQLException ex){
        Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE,null,ex);
        }  
    }

    public List<Cliente> listar() {
        String sql="SELECT *FROM cliente";
        ResultSet rs=null;
        PreparedStatement stmt=null;
        List<Cliente>clientes=new ArrayList<>();
         
        try{
            stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next())
            {//Os nomes devem ser iGuais com a Base De dados
                 Cliente cli=new Cliente();
         cli.setIdCliente(rs.getInt("idCliente"));    
         cli.setNome(rs.getString("nome"));
         cli.setProvincia(rs.getString("provincia"));
         cli.setDistrito(rs.getString("distrito"));
         cli.setTotalValor(rs.getInt("TotalValor"));
         cli.setTotalSolicitacoes(rs.getInt("TotalSolicitacoes"));
             
              clientes.add(cli);
            
            }
              stmt.close();
             rs.close();
        }catch(SQLException ex){
           Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE,null,ex);
          }
      return clientes; 
    }

   
    public Cliente listarPorID(Integer i)
    {
        String sql="SELECT *FROM cliente where idCliente=?";
        ResultSet rs=null;
        PreparedStatement stmt=null;
          Cliente cli=new Cliente();
        try{
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,i);
            rs=stmt.executeQuery();
            while(rs.next())
            {//Os nomes devem ser iGuais com a Base De dados
         cli.setIdCliente(rs.getInt("idCliente"));    
         cli.setNome(rs.getString("nome"));
         cli.setProvincia(rs.getString("provincia"));
         cli.setDistrito(rs.getString("Distrito"));
         cli.setTotalValor(rs.getInt("TotalValor"));
         cli.setTotalSolicitacoes(rs.getInt("TotalSolicitacoes"));
            }
              stmt.close();
             rs.close();
        }catch(SQLException ex){
           Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE,null,ex);
          }
      return cli; 
    }
}
