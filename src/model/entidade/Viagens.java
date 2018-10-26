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
public class Viagens {
    private int idCliente,codigo,idfun,idcarga,numero;
    private float valor, pocket_money,custo,distancia;
    private String matricula, provincia,tipo, distrito,cidade,ponto_partida;
    private Date data,data_partida,data_multa;

    public Viagens(int idCliente, int codigo, int idfun, int idcarga, int numero, float valor, float pocket_money, float custo, String matricula, String provincia, String tipo, String distrito, String cidade, String ponto_partida, Date data, Date data_partida, Date data_multa) {
        this.idCliente = idCliente;
        this.codigo = codigo;
        this.idfun = idfun;
        this.idcarga = idcarga;
        this.numero = numero;
        this.valor = valor;
        this.pocket_money = pocket_money;
        this.custo = custo;
        this.matricula = matricula;
        this.provincia = provincia;
        this.tipo = tipo;
        this.distrito = distrito;
        this.cidade = cidade;
        this.ponto_partida = ponto_partida;
        this.data = data;
        this.data_partida = data_partida;
        this.data_multa = data_multa;
    }

    public Viagens() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdfun() {
        return idfun;
    }

    public void setIdfun(int idfun) {
        this.idfun = idfun;
    }

    public int getIdcarga() {
        return idcarga;
    }

    public void setIdcarga(int idcarga) {
        this.idcarga = idcarga;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getPocket_money() {
        return pocket_money;
    }

    public void setPocket_money(float pocket_money) {
        this.pocket_money = pocket_money;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getPonto_partida() {
        return ponto_partida;
    }

    public void setPonto_partida(String ponto_partida) {
        this.ponto_partida = ponto_partida;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData_partida() {
        return data_partida;
    }

    public void setData_partida(Date data_partida) {
        this.data_partida = data_partida;
    }

    public Date getData_multa() {
        return data_multa;
    }

    public void setData_multa(Date data_multa) {
        this.data_multa = data_multa;
    }
    
 


            
            

    
}
