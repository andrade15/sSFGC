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
import model.dao.CamiaoDAO;
import model.dao.ClienteDAO;
import model.dao.ViagemDAO;
import model.entidade.Camiao;
import model.entidade.Cliente;
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
  ClienteDAO cdao=new ClienteDAO();
/*  
  via.setPonto_partida(" CHOUPAL");
   via.setDistancia(100);
   via.setData_partida(sdf.parse("2017-09-01"));
   via.setPocket_money(2500);
   via.setProvincia("MAPUTO");
   via.setDistrito("MATOLA");
   via.setCidade("YUT");
   //vdao.inserir(via);
   
 // vdao.delete(0);
    
   
   /*
    */


      Cliente c=new Cliente();    
      c.setIdCliente(109);
      c.setNome("Mozaico");
      c.setProvincia("Maputo");
            c.setDistrito("Maracuene");
        
      
     cdao.Update(c);
          List <Cliente> clientes;
        clientes = cdao.listar();
    System.out.println("CODIGO\tPARTIDA\tDISTANCIA\tDATA_PARTIDA\tPOCKET_MONEY\tPROVINCIA\tDISTRITO\tCIDADE");
       for (Cliente cli:clientes){
        System.out.println(cli.getIdCliente()+"\t"+cli.getNome()+"\t   "+cli.getProvincia()+"   \t"+cli.getDistrito()+"\t     "+
               cli.getTotalValor()+"   \t    "+cli.getTotalSolicitacoes()+"   \t  "+cli.getDistrito());
    }
       
       
  
   System.out.println("CODIGO\tPARTIDA\tDISTANCIA\tDATA_PARTIDA\tPOCKET_MONEY\tPROVINCIA\tDISTRITO\tCIDADE");
      Viagem v=new Viagem();
           v=vdao.listarPorID(201701);
               
        System.out.println(v.getCod_viagem()+"\t"+v.getPonto_partida()+"\t   "+v.getDistancia()+"   \t"+v.getData_partida()+"\t     "+
               v.getPocket_money()+"   \t    "+v.getProvincia()+"   \t  "+v.getDistrito()+"  \t  "+v.getCidade());
    
      /* CamiaoDAO cami=new CamiaoDAO();
       Camiao ca=new Camiao();
       cami.Update(ca, "MTJ");
       */
       
   
 
 
     //vdao.Update(via,201701);
    }
}
