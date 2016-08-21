package com.example.denis.educaquiz.Model;

/**
 * Created by Denis on 01/05/2016.
 */
public class FasesUsuario {

    private int idUsuario;
    private int idFase;
    private int pontos;
    private int totalPontos;

    public FasesUsuario(int idFase, int idUsuario, int pontos,int totalPontos) {
        this.setIdFase(idFase);
        this.setIdUsuario(idUsuario);
        this.setPontos(pontos);
        this.setTotalPontos(totalPontos);
    }

    public FasesUsuario() {
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getTotalPontos() {
        return totalPontos;
    }

    public void setTotalPontos(int totalPontos) {
        this.totalPontos = totalPontos;
    }
}
