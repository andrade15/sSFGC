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
import model.entidade.Condutor;

/**
 *
 * @author OSVALDO
 */
public class CondutorDAO implements DAOinterface<Condutor,Integer>{
    
    private Connection con;
    
    public CondutorDAO()         
    {
    con=BDconexao.getConnection();
    
    }

    @Override
    public Condutor inserir(Condutor c) {
        String sql="INSERT INTO condutor(Anos_Experienci,data_nasc) values(?,?)";
        PreparedStatement stmt=null;
        
        try
        {
           stmt=con.prepareStatement(sql);
           stmt.setInt(1,c.getAno_Experiencia());
           stmt.setDate(2,new Date (c.getData_nasc().getTime()));
          
                  
           stmt.executeUpdate();
            stmt.close();
      
        JOptionPane.showMessageDialog(null," Condutor Gravado com sucesso");
        }catch(SQLException ex){Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
        
        return c;
       }

    @Override
    public void Update(Condutor c) {
        String sql="Update condutor set Anos_Experienci=?,data_nasc=? WHERE idFun=?";
        PreparedStatement stmt=null;
        try{
           stmt=con.prepareStatement(sql);
           
           stmt.setInt(1,c.getAno_Experiencia());
           stmt.setDate(2,new Date(c.getData_nasc().getTime()));
           stmt.setInt(3,c.getIdFun());
           
           stmt.close();
        
                 JOptionPane.showMessageDialog(null," Condutor Actualizado com sucesso");
        }catch(SQLException ex){
        Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
       
    }

    public void delete(Integer i) {
        String sql="Delete from condutor where idFun=? ";
        PreparedStatement stmt=null;
        try{
            stmt=con.prepareStatement(sql);
             stmt.setInt(1,i);
             stmt.executeUpdate();
        
        stmt.close();
        JOptionPane.showMessageDialog(null,"Excluido com sucesso");
            }catch(SQLException ex){
        Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);}
    }

    @Override
    public List<Condutor> listar() {
      
        String sql="SELECT *FROM condutor ";
        PreparedStatement stmt=null;
        List<Condutor> condutores=new ArrayList();
        ResultSet rs=null; 
        try{
            
            stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next())
            {
            Condutor co=new Condutor();
            co.setIdFun(rs.getInt("idFun"));
            co.setAno_Experiencia(rs.getInt("Anos_Experiencia"));
            co.setData_nasc(rs.getDate("data_nasc"));
            co.setNum_viagens(rs.getInt("num_viagens"));
            condutores.add(co);
            }
      
            stmt.close();
            rs.close();
         
        }catch(SQLException ex)
        {
        Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
        }
        return condutores;  
    }

    @Override
    public Condutor listarPorID(Integer i) {
         Condutor co=new Condutor();
        String sql="SELECT *FROM condutor WHERE idFun=?";
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try
        {   stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next())
            {
           
            stmt.setInt(1, i);
            co.setIdFun(rs.getInt("idFun"));
            co.setAno_Experiencia(rs.getInt("Anos_Experiencia"));
            co.setData_nasc(rs.getDate("data_nasc"));
            co.setNum_viagens(rs.getInt("num_viagens"));
            }
            stmt.close();
            rs.close();
        }catch(SQLException ex)
        {
        Logger.getLogger(BDconexao.class.getName()).log(Level.SEVERE,null,ex);
        } 
        return co;
    }
    
    
    
    
    
    
}
