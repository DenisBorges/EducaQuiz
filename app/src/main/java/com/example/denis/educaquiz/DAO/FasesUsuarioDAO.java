package com.example.denis.educaquiz.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.denis.educaquiz.Model.Fase;
import com.example.denis.educaquiz.Model.FasesUsuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 01/05/2016.
 */
public class FasesUsuarioDAO {

    private BaseDAO db;
    public ContentValues fasesUsuario;
    //NOME DA TABELA
    public static final String TABELA = "FASESUSUARIO";


    //CONSTRUTOR
    public FasesUsuarioDAO(Context database)
    {
        this.setDb(new BaseDAO(database));
    }

    //CRUD

    //UPDATE----------------------------------------------------------------------------------------
    public boolean atualizaFasesUsuario(FasesUsuario fase){
        return true;
    }

    public boolean apagaFasesUsuario(int id){
      return true;
    };


    //SELECT ALL------------------------------------------------------------------------------------
    public List<FasesUsuario> pesquisaFasesUsuario(){

        List<FasesUsuario> list = new ArrayList<FasesUsuario>();

        Cursor cursor;

        cursor = db.consultaDados(new String[]{"idFase","idUsuario","acesso","pontosObrigatorios","conclusao"},TABELA,null);

        if (cursor == null && !cursor.isClosed()) {
            cursor.close();
        }else{

            do{

                list.add(new FasesUsuario());

            }while(cursor.moveToNext());


        }
        return list;

    }

    //SELECT ID-------------------------------------------------------------------------------------
    public FasesUsuario pesquisaID(int IdFase){
        return new FasesUsuario();
    }



    //GET e SET - BASEDAO db
    public BaseDAO getDb() {
        return db;
    }
    public void setDb(BaseDAO db) {
        this.db = db;
    }
}
