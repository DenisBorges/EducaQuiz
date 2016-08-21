package com.example.denis.educaquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.denis.educaquiz.DAO.UsuarioDAO;
import com.example.denis.educaquiz.Model.Usuario;

/**
 * Created by Denis on 24/04/2016.
 */
public class NovoUsuario extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_usuario);



    }


    public void CadastrarUsuario(View view){

        String nome = ((EditText) findViewById(R.id.nomeUsuario)).getText().toString();
        int idade = Integer.parseInt(((EditText) findViewById(R.id.idadeUsuario)).getText().toString());

        try{

            new UsuarioDAO(getBaseContext()).insereUsuario(new Usuario(nome,idade,0));


        }catch (Exception ex) {
            Toast.makeText(getBaseContext(), ex.toString(), Toast.LENGTH_SHORT);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
