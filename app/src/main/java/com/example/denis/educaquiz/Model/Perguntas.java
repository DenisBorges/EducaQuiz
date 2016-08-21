package com.example.denis.educaquiz.Model;

import android.widget.ImageView;

import java.util.List;

/**
 * Created by Denis on 09/04/2016.
 */

public class Perguntas {

    private int idFase;
    private int idPergunta;
    private String pergunta;
    private String respostaCorreta;
    private int pontos;
    private String imagem;
    private List<Alternativas> alternativas;

    public Perguntas(int idPergunta, String pergunta,String respostaCorreta, List<Alternativas> alternativas) {
        this.setAlternativas(alternativas);
        this.setIdPergunta(idPergunta);
        this.setPergunta(pergunta);
        this.setRespostaCorreta(respostaCorreta);
    }

    public Perguntas(List<Alternativas> alternativas, int idPergunta, int idFase, String pergunta, String respostaCorreta) {
        this.setAlternativas(alternativas);
        this.setIdPergunta(idPergunta);
        this.setIdFase(idFase);
        this.setPergunta(pergunta);
        this.setRespostaCorreta(respostaCorreta);
    }

    public Perguntas() {
    }



    public int getIdPergunta() {
        return idPergunta;
    }
    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public int getIdFase() {
        return idFase;
    }
    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }


    public String getPergunta() {
        return pergunta;
    }
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public List<Alternativas> getAlternativas() {
        return alternativas;
    }
    public void setAlternativas(List<Alternativas> alternativas) {
        this.alternativas = alternativas;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
