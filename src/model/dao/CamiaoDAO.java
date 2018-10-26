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
import model.entidade.Camiao;
import model.entidade.Viagem;

/**
 *
 * @author Mic
 */
public class CamiaoDAO implements DAOinterface2<Camiao,String> {
    
     Connection con;
    
    public CamiaoDAO()
    { con=BDconexao.getConnection();  }

   @Override
    public Camiao inserir(Camiao cam) {
        String sql;
        sql = "insert into camiao (matricula,marca,tanque,seguros,peso_bruto,num_Viagens,num_manutencoes)"+
                "values (?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try
        {
        stmt=con.prepareStatement(sql);
        stmt.setString(1,cam.getMarca());
        stmt.setFloat(2,cam.getTanque());
        stmt.setString(5,cam.getSeguros());
         stmt.setInt(4,cam.getPeso_bruto());
        stmt.setInt(4,cam.getNum_viagens());
        stmt.setInt(4,cam.getNum_Manutencao());
        
        stmt.executeUpdate();
        stmt.close();
      
        JOptionPane.showMessageDialog(null," Registado com sucesso");
        
        }catch(SQLException ex){System.out.println(ex);}
       
        return cam;
    }

   
    public void Update(Camiao cam) {
        String sql;
        sql = "Update camiao set marca=?,tanque=?,seguros=?,peso_bruto=?,num_Viagens=?,num_manutencoes=? WHERE Matricula=?)"+
                "values (?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try
        {
        stmt=con.prepareStatement(sql);
        stmt.setString(1,cam.getMarca());
        stmt.setFloat(2,cam.getTanque());
        stmt.setString(5,cam.getSeguros());
         stmt.setInt(4,cam.getPeso_bruto());
        stmt.setInt(4,cam.getNum_viagens());
        stmt.setInt(4,cam.getNum_Manutencao());
        stmt.setString(7,cam.getMatricula());
        
        stmt.executeUpdate();
            
        JOptionPane.showMessageDialog(null,"Actualizado com sucesso");
        }catch(SQLException ex){
        Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
      
    }

    
    public void delete(String s) 
    {
     String sql="DELETE camiao WHERE Matricula=?";
      PreparedStatement stmt=null;
       try{
          stmt=con.prepareStatement(sql);
          stmt.setString(1, s);
          stmt.executeUpdate();
         
          stmt.close();
        JOptionPane.showMessageDialog(null," CAMIAO Excluido com suceesso");
        
       }catch(SQLException ex){
        Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE,null,ex);
        }  
    }

    @Override
    public List<Camiao> listar() {
        String sql="SELECT *FROM camiao";
        ResultSet rs=null;
        PreparedStatement stmt=null;
        List<Camiao>camioes=new ArrayList<>();
        
        try{
            stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next())
            {        Camiao cami=new Camiao();

              cami.setMatricula(rs.getString("Matricula"));
               cami.setMarca(rs.getString("Marca"));
               cami.setTanque(rs.getFloat("Tanque"));
               cami.setSeguros(rs.getString("Seguros"));
                cami.setPeso_bruto(rs.getInt("peso_bruto"));
                 cami.setNum_viagens(rs.getInt("Num_Viagens"));
                  cami.setNum_Manutencao(rs.getInt("Num_Manutencoes"));
          
              camioes.add(cami);
            
            }
              stmt.close();
             rs.close();
        }catch(SQLException ex){
           Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE,null,ex);
          }
      return camioes; 
    }

   
    public List listarPorID(String s)
    {
       String sql="SELECT *FROM camiao WHERE Matricula=?";
        ResultSet rs=null;
        PreparedStatement stmt=null;
        Camiao cami=new Camiao();
        
        try{
            stmt=con.prepareStatement(sql);
            stmt.setString(1,s);
            rs=stmt.executeQuery();
            while(rs.next())
            {
              cami.setMatricula(rs.getString("Matricula"));
               cami.setMarca(rs.getString("Marca"));
               cami.setTanque(rs.getFloat("Tanque"));
               cami.setSeguros(rs.getString("Seguros"));
                cami.setPeso_bruto(rs.getInt("peso_bruto"));
                 cami.setNum_viagens(rs.getInt("Num_Viagens"));
                  cami.setNum_Manutencao(rs.getInt("Num_Manutencoes"));
            }
              stmt.close();
             rs.close();
        }catch(SQLException ex){
           Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE,null,ex);
          }
    return
    }



}  

