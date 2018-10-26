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
public class Cliente {
    private int idCliente;
    private String provincia,distrito,nome;
    private int totalValor,totalSolicitacoes;
    
    public Cliente(){
    
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTotalValor() {
        return totalValor;
    }

    public void setTotalValor(int totalValor) {
        this.totalValor = totalValor;
    }

    public int getTotalSolicitacoes() {
        return totalSolicitacoes;
    }

    public void setTotalSolicitacoes(int totalSolicitacoes) {
        this.totalSolicitacoes = totalSolicitacoes;
    }

 
    
}
