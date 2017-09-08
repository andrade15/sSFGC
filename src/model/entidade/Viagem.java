/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.util.Date;

/**
 *
 * @author OSVALDO
 */
public class Viagem {
    
    	private int cod_viagem;
        private String ponto_partida;
	private Date data_partida;
	private float distancia;
	private float pocket_money;
        private String provincia;
        private String distrito;
        private String cidade;

    public Viagem() {
    }

    public int getCod_viagem() {
        return cod_viagem;
    }

    public void setCod_viagem(int cod_viagem) {
        this.cod_viagem = cod_viagem;
    }

    public String getPonto_partida() {
        return ponto_partida;
    }

    public void setPonto_partida(String ponto_partida) {
        this.ponto_partida = ponto_partida;
    }

    public Date getData_partida() {
        return data_partida;
    }

    public void setData_partida(Date data_partida) {
        this.data_partida = data_partida;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public float getPocket_money() {
        return pocket_money;
    }

    public void setPocket_money(float pocket_money) {
        this.pocket_money = pocket_money;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    
    
        
        
        
        
	
    
    
}
