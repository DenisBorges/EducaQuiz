package com.example.denis.educaquiz.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.denis.educaquiz.Model.Fase;
import com.example.denis.educaquiz.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 01/05/2016.
 */
public class FaseDAO {

    private BaseDAO db;
    public ContentValues fase;
    //NOME DA TABELA
    public static final String TABELA = "FASE";


    //CONSTRUTOR
    public FaseDAO(Context database)
    {
        this.setDb(new BaseDAO(database));
    }

    //CRUD

    public String insereFase(Fase fa){

        fase = new ContentValues();
        fase.put("idFase",fa.getIdFase());
        fase.put("pontosObrigatorios", fa.getPontosObrigatorios());

        if(db.insertDados(fase,TABELA) == true){
            return "Usuario inserido com Sucesso";
        }else{
            return "Erro ao inserir Usuario";
        }
    }


    //UPDATE----------------------------------------------------------------------------------------
    public boolean atualizaFase(Fase fase){
        return true;
    }


    //SELECT ALL------------------------------------------------------------------------------------
    public List<Fase> pesquisaFases(){

        List<Fase> list = new ArrayList<Fase>();
        Cursor cursor;

        cursor = db.consultaDados(new String[]{"idFase","idUsuario","acesso","pontosObrigatorios","conclusao"},TABELA,null);

        if (cursor == null && !cursor.isClosed()) {
            cursor.close();
        }else{

            do{

                //list.add(new Fase(cursor.getInt(0),cursor.getInt(1),Boolean.parseBoolean(cursor.getString(2)),cursor.getInt(3),cursor.getInt(4)));

            }while(cursor.moveToNext());


        }
        return list;

    }

    //SELECT ID-------------------------------------------------------------------------------------
    public Fase pesquisaID(int IdFase){
        return new Fase();
    }



    //GET e SET - BASEDAO db
    public BaseDAO getDb() {
        return db;
    }
    public void setDb(BaseDAO db) {
        this.db = db;
    }
}
