/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Versao;

/**
 *
 * @author MIGRAÇÃO-PC
 */
public class Versao {

    private int id;
    private int versao;
    private String data_vigencia;
    private String data_hora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }

    public String getData_vigencia() {
        return data_vigencia;
    }

    public void setData_vigencia(String data_vigencia) {
        this.data_vigencia = data_vigencia;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

}
