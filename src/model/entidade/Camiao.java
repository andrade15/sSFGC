/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

/**
 *
 * @author OSVALDO
 */
public class Camiao {
    
       private String Matricula;
    private float tanque;
    private String seguros,Marca;
    private int peso_bruto;
    private int num_viagens;
    private int num_Manutencao;

    public Camiao() {
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public float getTanque() {
        return tanque;
    }

    public void setTanque(float tanque) {
        this.tanque = tanque;
    }

    public String getSeguros() {
        return seguros;
    }

    public void setSeguros(String seguros) {
        this.seguros = seguros;
    }

    public int getPeso_bruto() {
        return peso_bruto;
    }

    public void setPeso_bruto(int peso_bruto) {
        this.peso_bruto = peso_bruto;
    }

    public int getNum_viagens() {
        return num_viagens;
    }

    public void setNum_viagens(int num_viagens) {
        this.num_viagens = num_viagens;
    }

    public int getNum_Manutencao() {
        return num_Manutencao;
    }

    public void setNum_Manutencao(int num_Manutencao) {
        this.num_Manutencao = num_Manutencao;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

 
  
    
    
    
    
    
}
