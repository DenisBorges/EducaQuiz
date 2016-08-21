package com.example.denis.educaquiz.Model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by Denis on 28/09/2015.
 */


public class Fase {

    //ATRIBUTOS

    private int idFase;
    private int pontosObrigatorios;
    private List<Perguntas> perguntas;


    //CONSTRUTORES
    public Fase(List<Perguntas> perguntas) {
        this.perguntas = perguntas;
    }

    public Fase(int _idFase,int _pontosObrigatorios, List<Perguntas> _perguntas){

        this.setIdFase(_idFase);
        this.setPontosObrigatorios(_pontosObrigatorios);

    }

    public Fase (){};

//ENCAPSULAMENTO
    public int getIdFase() {
        return idFase;
    }
    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }
    public int getPontosObrigatorios() {
        return pontosObrigatorios;
    }
    public void setPontosObrigatorios(int pontosObrigatorios) {
        this.pontosObrigatorios = pontosObrigatorios;
    }
    public List<Perguntas> getPerguntas() {
        return perguntas;
    }
    public void setPerguntas(List<Perguntas> perguntas) {
        this.perguntas = perguntas;
    }

}
