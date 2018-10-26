/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.util.Date;

/**
 *
 * @author Mic
 */
public class MultaViagem {
    private int codViagem,numero;
    private Date dataMulta;

    public MultaViagem(){
    
    }

    public int getCodViagem() {
        return codViagem;
    }

    public void setCodViagem(int codViagem) {
        this.codViagem = codViagem;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDataMulta() {
        return dataMulta;
    }

    public void setDataMulta(Date dataMulta) {
        this.dataMulta = dataMulta;
    }
    
}
