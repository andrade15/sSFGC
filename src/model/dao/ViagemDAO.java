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
import model.entidade.Viagem;
import model.entidade.Viagens;

/**
 *
 * @author OSVALDO
 */
public class ViagemDAO implements DAOinterface<Viagem,Integer> {
    
    Connection con;
    
    public ViagemDAO()
    { con=BDconexao.getConnection();  }

    @Override
    public Viagem inserir(Viagem v) {
        String sql;
        sql = "insert into Viagem(ponto_partida,distancia,data_partida,pocket_money,"+
                "provincia,distrito,cidade) values (?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try
        {
        stmt=con.prepareStatement(sql);
        stmt.setString(1,v.getPonto_partida());
        stmt.setFloat(2,v.getDistancia());
        stmt.setDate(3,new Date(v.getData_partida().getTime()));
        stmt.setFloat(4,v.getPocket_money());
        stmt.setString(5,v.getProvincia());
        stmt.setString(6,v.getDistrito());
        stmt.setString(7,v.getCidade());
        stmt.executeUpdate();
      stmt.close();
      
        JOptionPane.showMessageDialog(null,"Gravado com sucesso");
        
        }catch(SQLException ex){System.out.println(ex);}
       
        return v;
    }

   
    public void Update(Viagem v) {
        PreparedStatement stmt=null;
        try
        {
        
        stmt=con.prepareStatement("UPDATE viagem set ponto_partida=?,distancia=?,data_partida=?"
                + ",pocket_money=?,provincia=?,distrito=?,cidade=? where codviagem=? ");
            
        stmt.setString(1,v.getPonto_partida());
        stmt.setFloat(2,v.getDistancia());
        stmt.setDate(3,new Date(v.getData_partida().getTime()));
        stmt.setFloat(4,v.getPocket_money());
        stmt.setString(5,v.getProvincia());
        stmt.setString(6,v.getDistrito());
        stmt.setString(7,v.getCidade());
        stmt.setInt(8,v.getCod_viagem());
        
        stmt.executeUpdate();
            
        JOptionPane.showMessageDialog(null,"Actualizado com sucesso");
        }catch(SQLException ex){
        Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
      
    }

    
    public void delete(Integer i) 
    {
     String sql="DELETE FROM Viagem WHERE codViagem=?";
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
    public List<Viagens> listarTudo() {
        String sql="SELECT * from dadosviagem";
        ResultSet rs=null;
        PreparedStatement stmt=null;
        List<Viagens>v=new ArrayList<>();
        
        try{
            stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next())
            {//Os nomes devem ser iGuais com a Base De dados
             
                      Viagens viagem;
                viagem = new Viagens();
                                    
	     viagem.setIdCliente(rs.getInt("idCliente"));
             viagem.setCodigo(rs.getInt("codViagem"));
             viagem.setPonto_partida(rs.getString("ponto_partida"));
             viagem.setDistancia(rs.getInt("distancia"));
             viagem.setData_partida(rs.getDate("data_partida"));
             viagem.setPocket_money(rs.getFloat("pocket_money"));
             viagem.setProvincia(rs.getString("provincia"));
             viagem.setDistrito(rs.getString("distrito"));
             viagem.setCidade(rs.getString("cidade"));
            
             
			 viagem.setIdcarga(rs.getInt("idCarga"));
			 viagem.setTipo(rs.getString("tipo"));
			 viagem.setValor(rs.getFloat("valor"));
			 viagem.setCusto(rs.getFloat("custo_viagem"));
			 viagem.setIdfun(rs.getInt("idFun"));
			 viagem.setMatricula(rs.getString("matricula"));
                         viagem.setNumero(rs.getInt("numero"));
			 viagem.setData_multa(rs.getDate("data_multa"));
			 
			 
              v.add(viagem);
            
            }
              stmt.close();
             rs.close();
        }catch(SQLException ex){
           Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE,null,ex);
          }
      return v; 
    }

   

    @Override
    public List<Viagem> listar() {
        String sql="SELECT *FROM viagem";
        ResultSet rs=null;
        PreparedStatement stmt=null;
        List<Viagem>viagens=new ArrayList<>();
        
        try{
            stmt=con.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next())
            {//Os nomes devem ser iGuais com a Base De dados
              Viagem viagem=new Viagem();
             viagem.setCod_viagem(rs.getInt("codViagem"));
             viagem.setPonto_partida(rs.getString("ponto_partida"));
             viagem.setDistancia(rs.getInt("distancia"));
             viagem.setData_partida(rs.getDate("data_partida"));
             viagem.setPocket_money(rs.getFloat("pocket_money"));
             viagem.setProvincia(rs.getString("provincia"));
             viagem.setDistrito(rs.getString("distrito"));
             viagem.setCidade(rs.getString("cidade"));
             
              viagens.add(viagem);
            
            }
              stmt.close();
             rs.close();
        }catch(SQLException ex){
           Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE,null,ex);
          }
      return viagens; 
    }

   
    public Viagem listarPorID(Integer i)
    {
      String sql="SELECT *FROM viagem WHERE codViagem=?";
        ResultSet rs=null;
        PreparedStatement stmt=null;
        List<Viagem>viagens=new ArrayList<>();
         Viagem viagem=new Viagem();
        try{
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,i);
            rs=stmt.executeQuery();
            while(rs.next())
            {
             viagem.setCod_viagem(rs.getInt("codViagem"));//Os nomes devem ser iGuais com a Base De dados
             viagem.setPonto_partida(rs.getString("ponto_partida"));
             viagem.setDistancia(rs.getInt("distancia"));
             viagem.setData_partida(rs.getDate("data_partida"));
             viagem.setPocket_money(rs.getFloat("pocket_money"));
             viagem.setProvincia(rs.getString("provincia"));
             viagem.setDistrito(rs.getString("distrito"));
             viagem.setCidade(rs.getString("cidade"));
            
     
            }   
             stmt.close();
             rs.close();
           }catch(SQLException ex){
           Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE,null,ex); }
           return viagem;
    }
}
