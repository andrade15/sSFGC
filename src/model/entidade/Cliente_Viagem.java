/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

/**
 *
 * @author Mic
 */
public class Cliente_Viagem {
   private int codViagem,idCliente;
   private double custo_Viagem;
   
   public Cliente_Viagem(){
   
   }

    public int getCodViagem() {
        return codViagem;
    }

    public void setCodViagem(int codViagem) {
        this.codViagem = codViagem;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getCusto_Viagem() {
        return custo_Viagem;
    }

    public void setCusto_Viagem(double custo_Viagem) {
        this.custo_Viagem = custo_Viagem;
    }
   
}
