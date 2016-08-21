package com.example.denis.educaquiz.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.denis.educaquiz.Model.Usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Denis on 28/09/2015.
 */
public class UsuarioDAO{

    private BaseDAO db;
    public ContentValues usuario;
    //NOME DA TABELA
    public static final String TABELA = "USUARIO";


    //CONSTRUTOR
    public UsuarioDAO(Context database)
    {
        this.setDb(new BaseDAO(database));
    }

    //CRUD


    //INSERT----------------------------------------------------------------------------------------
    public String insereUsuario(Usuario user){

        usuario = new ContentValues();
        usuario.put("nome", user.getNome());
        usuario.put("idade",user.getIdade());
        usuario.put("totalpontos",user.getTotalpontos());

       if(db.insertDados(usuario,TABELA) == true){
           return "Usuário inserido com Sucesso";
       }else{
           return "Erro ao inserir Usuário";
       }
    }
    //UPDATE----------------------------------------------------------------------------------------
    public boolean atualizaUsuario(Usuario user){
        return true;
    }

    //DELETE----------------------------------------------------------------------------------------
    public boolean apagaUsuario(Usuario user){
        return true;
    }

    //SELECT ALL------------------------------------------------------------------------------------
    public List<Usuario> pesquisaTodos(){

        List<Usuario> list = new ArrayList<Usuario>();
        Cursor cursor;

        cursor = db.consultaDados(new String[]{"id","nome","idade","totalpontos"},TABELA,null);

        if (cursor == null && !cursor.isClosed()) {
            cursor.close();
        }else{

            do{

                list.add(new Usuario(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3)));

            }while(cursor.moveToNext());


        }
        return list;

    }

    //SELECT ID-------------------------------------------------------------------------------------
    public Usuario pesquisaId(int idUsuario){

        Usuario user = null;

        Cursor cursor;
        cursor = db.consultaDados(new String[]{"id","nome","idade","totalpontos"},TABELA,"id = "+ idUsuario);
        if (cursor == null && !cursor.isClosed()) {
            cursor.close();
        }else{

            do{

                user = new Usuario(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3));

            }while(cursor.moveToNext());


        }

        return user;
    }

    //SELECT NOME
    public Usuario pesquisaNome(String nomeUsuario){

        Usuario user = null;

        Cursor cursor;
        cursor = db.consultaDados(new String[]{"id","nome","idade","totalpontos"},TABELA,"nome = '"+ nomeUsuario + "'");
        if (cursor == null && !cursor.isClosed()) {
            cursor.close();
        }else{

            do{

                user = new Usuario(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3));

            }while(cursor.moveToNext());


        }

        return user;
    }



    //GET e SET - BASEDAO db
    public BaseDAO getDb() {
        return db;
    }
    public void setDb(BaseDAO db) {
        this.db = db;
    }


}
