/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author OSVALDO
 */
public class BDconexao {
    private static final String Driver="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost/frota";
    private static final String user="root";
    private static final String password="";
    
   
  public static Connection getConnection() {
    try {
        Class.forName(Driver);
        return DriverManager.getConnection(URL, user, password);
        
         } catch (ClassNotFoundException | SQLException ex) {
          JOptionPane.showMessageDialog(null,"Erro na Conexao");
          System.exit(0);
         }
    return null;
     }
     
    
        //Para fechar conexao
    public static void fecharConexao(Connection con)
    {
     try{
         if(con!=null)
          con.close();
   
        }catch(SQLException ex){
         Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
     } 
    
       //Para fechar conexao,PreparedStatement
    public static void fecharConexao(Connection con,PreparedStatement stmt)
    {
        fecharConexao(con);
       try{
         if(stmt!=null)
          stmt.close();
         }catch(SQLException ex){
         Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
          }
    }
      
      
      //Para fechar conexao,PreparedStatement e Result
     public static void fecharConexao(Connection con, PreparedStatement stmt,ResultSet rs)
     {
       fecharConexao(con,stmt);
    
      try{
         if(rs!=null)
          rs.close();
        }catch(SQLException ex){
         Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
        }
     }
}
