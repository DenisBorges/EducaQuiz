package com.example.denis.educaquiz.Model;



/**
 * Created by Denis on 28/09/2015.
 */

public class Usuario {

    private int id;
    private String nome;
    private int idade;
    private int totalpontos;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getTotalpontos() {
        return totalpontos;
    }
    public void setTotalpontos(int totalpontos) {
        this.totalpontos = totalpontos;
    }

    // SELECT
    public Usuario(int id,String nome, int idade,int totalpontos){
        this.setId(id);
        this.setNome(nome);
        this.setIdade(idade);
        this.setTotalpontos(totalpontos);
    }

    //INSERT
    public Usuario(String nome, int idade,int totalpontos){

        this.setNome(nome);
        this.setIdade(idade);
        this.setTotalpontos(totalpontos);
    }

    public Usuario(){};

}
