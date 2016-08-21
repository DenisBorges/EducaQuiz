package com.example.denis.educaquiz.Model;

/**
 * Created by Denis on 09/04/2016.
 */

public class Alternativas {

    private int idPergunta;
    private int idAlternativa;
    private String alternativa;

    public Alternativas(int idAlternativa, int idPergunta, String alternativa) {
        this.setIdAlternativa(idAlternativa);
        this.setIdPergunta(idPergunta);
        this.setAlternativa(alternativa);

    }

    public Alternativas(int idPergunta, String alternativa) {
        this.setIdPergunta(idPergunta);
        this.setAlternativa(alternativa);
    }

    public Alternativas() {
    }

    public int getIdAlternativa() {
        return idAlternativa;
    }
    public void setIdAlternativa(int idAlternativa) {
        this.idAlternativa = idAlternativa;
    }

    public int getIdPergunta() {
        return idPergunta;
    }
    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getAlternativa() {
        return alternativa;
    }
    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }

}
