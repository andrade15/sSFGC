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
public class Manuntencao {
    private int codManuntencao;
    private String descricao,tipo;
    
    public Manuntencao(){
    
    }

    public int getCodManuntencao() {
        return codManuntencao;
    }

    public void setCodManuntencao(int codManuntencao) {
        this.codManuntencao = codManuntencao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
