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
public class Categoria {
    private int totalFuncionarios,totalSalarios;
    private String categoria;
    private double media_salarios;
    
    public Categoria(){
    
    }

    public int getTotalFuncionarios() {
        return totalFuncionarios;
    }

    public void setTotalFuncionarios(int totalFuncionarios) {
        this.totalFuncionarios = totalFuncionarios;
    }

    public int getTotalSalarios() {
        return totalSalarios;
    }

    public void setTotalSalarios(int totalSalarios) {
        this.totalSalarios = totalSalarios;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getMedia_salarios() {
        return media_salarios;
    }

    public void setMedia_salarios(double media_salarios) {
        this.media_salarios = media_salarios;
    }
    
}
