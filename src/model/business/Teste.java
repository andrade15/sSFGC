/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import model.dao.ViagemDAO;
import model.entidade.Viagem;

/**
 *
 * @author OSVALDO
 */
public class Teste {
    
    
    public static void main(String[] args)throws ParseException
    {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    ViagemDAO vdao=new ViagemDAO();
  Viagem via=new Viagem();
  
  via.setPonto_partida(" CHOUPAL");
   via.setDistancia(100);
   via.setData_partida(sdf.parse("2017-09-01"));
   via.setPocket_money(2500);
   via.setProvincia("MAPUTO");
   via.setDistrito("MATOLA");
   via.setCidade("FEEM");
   vdao.inserir(via);
   
  vdao.delete(0);
    
   
   
    
         
          List <Viagem> viagens = vdao.listar();
    System.out.println("CODIGO\tPARTIDA\tDISTANCIA\tDATA_PARTIDA\tPOCKET_MONEY\tPROVINCIA\tDISTRITO\tCIDADE");
       for (Viagem viagem:viagens){
        System.out.println(viagem.getCod_viagem()+"\t"+viagem.getPonto_partida()+"\t   "+viagem.getDistancia()+"   \t"+viagem.getData_partida()+"\t     "+
               viagem.getPocket_money()+"   \t    "+viagem.getProvincia()+"   \t  "+viagem.getDistrito()+"  \t  "+viagem.getCidade());
    }
       
       
      
   System.out.println("CODIGO\tPARTIDA\tDISTANCIA\tDATA_PARTIDA\tPOCKET_MONEY\tPROVINCIA\tDISTRITO\tCIDADE");
      Viagem v=new Viagem();
           v=vdao.listarPorID(201701);
               
        System.out.println(v.getCod_viagem()+"\t"+v.getPonto_partida()+"\t   "+v.getDistancia()+"   \t"+v.getData_partida()+"\t     "+
               v.getPocket_money()+"   \t    "+v.getProvincia()+"   \t  "+v.getDistrito()+"  \t  "+v.getCidade());
    
        
       
    
    }


    
            
    
    
    
}
