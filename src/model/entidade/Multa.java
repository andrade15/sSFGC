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
public class Multa {
    private int numero;
    private String tipo_multa,causa;
    private double valor;
    
    public Multa(){
    
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo_multa() {
        return tipo_multa;
    }

    public void setTipo_multa(String tipo_multa) {
        this.tipo_multa = tipo_multa;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
