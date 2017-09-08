/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.sql.Date;

/**
 *
 * @author OSVALDO
 */
public class Condutor {
    private Date dataNac;
    private int idFun;
    private String Categoria;
    private int num_viagens;
    private int idGestor;

    public Condutor() {
    }

    public Date getDataNac() {
        return dataNac;
    }

    public void setDataNac(Date dataNac) {
        this.dataNac = dataNac;
    }

    public int getIdFun() {
        return idFun;
    }

    public void setIdFun(int idFun) {
        this.idFun = idFun;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public int getNum_viagens() {
        return num_viagens;
    }

    public void setNum_viagens(int num_viagens) {
        this.num_viagens = num_viagens;
    }

    public int getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(int idGestor) {
        this.idGestor = idGestor;
    }
    
    
    
 
    
}
