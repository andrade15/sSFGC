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
public class CamiaoManuntencao {
    private int codManuntencao,matricula;
    private Date dataManuntencao;
    private double custoManuntencao;
    
    public CamiaoManuntencao(){
    
    }

    public int getCodManuntencao() {
        return codManuntencao;
    }

    public void setCodManuntencao(int codManuntencao) {
        this.codManuntencao = codManuntencao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Date getDataManuntencao() {
        return dataManuntencao;
    }

    public void setDataManuntencao(Date dataManuntencao) {
        this.dataManuntencao = dataManuntencao;
    }

    public double getCustoManuntencao() {
        return custoManuntencao;
    }

    public void setCustoManuntencao(double custoManuntencao) {
        this.custoManuntencao = custoManuntencao;
    }
    
}
