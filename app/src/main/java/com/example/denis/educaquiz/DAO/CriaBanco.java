package com.example.denis.educaquiz.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Denis on 13/09/2015.
 */
public class CriaBanco extends SQLiteOpenHelper{

    public static String NOME_BANCO = "educaquiz.db";
    public static int VERSAO = 1;

    private static String USUARIO = "CREATE TABLE USUARIO ( id integer primary key autoincrement not null, nome nvarchar(100) null, idade integer not null,totalpontos integer not null)";
    private static String FASESUSUARIO = "CREATE TABLE FASESUSUARIO ( idUsuario integer NULL, IdFase integer primary key not null,pontosFase integer null,totalPontos integer null)";
    private static String FASE = "CREATE TABLE FASE ( idFase integer primary key autoincrement NOT NULL,pontosObrigatorios integer null)";
    private static String PERGUNTAS = "CREATE TABLE PERGUNTAS (id integer primary key autoincrement not null,idFase integer null, idPergunta integer NULL, Pergunta nvarchar(500),AlternativaCorreta integer null,pontos integer null,imagem nvarchar(500) null)";
    private static String ALTERNATIVAS = "CREATE TABLE ALTERNATIVAS (id integer primary key autoincrement NOT NULL, idAlternativa integer null, IdPergunta integer null, alternativas nvarchar(500) null)";

    public static String[] TABELAS = {USUARIO,FASE,FASESUSUARIO,PERGUNTAS,ALTERNATIVAS};

    //Classe de criação do banco/controle de versão
    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null,VERSAO);
    }

    public void onCreate(SQLiteDatabase db){
        for (String sql:TABELAS){
            db.execSQL(sql);
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion){

        for (String sql:TABELAS){
            db.execSQL("DROP TABLE IF EXISTS" + sql.getClass().toString());
            onCreate(db);
        }
    }

}


