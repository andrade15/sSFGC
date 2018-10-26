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
public class Condutor {
   
    private int idFun;
    private int Ano_Experiencia;
    private Date data_nasc;
    private int num_viagens;
  

    public Condutor() {
    }

    public int getIdFun() {
        return idFun;
    }

    public void setIdFun(int idFun) {
        this.idFun = idFun;
    }

    public int getAno_Experiencia() {
        return Ano_Experiencia;
    }

    public void setAno_Experiencia(int Ano_Experiencia) {
        this.Ano_Experiencia = Ano_Experiencia;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public int getNum_viagens() {
        return num_viagens;
    }

    public void setNum_viagens(int num_viagens) {
        this.num_viagens = num_viagens;
    }

    
 
    
}
