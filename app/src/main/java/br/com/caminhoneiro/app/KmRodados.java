package br.com.caminhoneiro.app;

import com.orm.SugarRecord;

/**
 * Created by 16254855 on 30/10/2017.
 */

public class KmRodados extends SugarRecord{
    private String mes;
    private Integer km;
    private double ganho;

    public KmRodados(){ }


    public KmRodados(String mes, Integer km){
        this.mes = mes;
        this.km = km;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public double getGanho() {;
        return ganho;
    }

    public void setGanho(double ganho) {
        this.ganho = ganho;
    }
}
