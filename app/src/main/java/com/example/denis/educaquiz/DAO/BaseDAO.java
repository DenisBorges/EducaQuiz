package com.example.denis.educaquiz.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by Denis on 26/08/2015.
 */



//Classe de manipulação do banco
public class BaseDAO {

public SQLiteDatabase db;
    //Variavel que pega a instancia do banco em execução
 private CriaBanco banco;

    public BaseDAO(Context context){
        banco = new CriaBanco(context);
    }



    //METODO INSERT
    public boolean insertDados(ContentValues valores,String Tabela){

        // Variavel que armazena dados baseado em chave/valor

        long resultado;

        //getWritableDatabase() explica ao banco que vamos utiliza-lo para leitura e gravação de dados
        db = banco.getWritableDatabase();

        //valores = new ContentValues();

        //valores.put(CriaBanco.NOME, nome);
        //valores.put(CriaBanco.IDADE, String.valueOf(idade));

//Metodo 'insert' que grava valores na tabela tal e retorna -1 caso erro ou maior que -1 caso sucesso

        resultado = db.insert(Tabela,null,valores);

// fecha conexao com banco

        db.close();

        if(resultado == -1) {
            return false;
        }else{
            return true;
        }


    }

    //METODO READ

    public Cursor consultaDados(String[] campos,String TABELA,String where){
        Cursor cursor;
        db = banco.getReadableDatabase();
        //metodo query recebe (Nome da tabela,
        cursor = db.query(TABELA,campos,where,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        db.close();


        return cursor;

    }





}



