package com.example.denis.educaquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.denis.educaquiz.DAO.UsuarioDAO;
import com.example.denis.educaquiz.Model.Alternativas;
import com.example.denis.educaquiz.Model.Perguntas;
import com.example.denis.educaquiz.Model.Usuario;
import com.example.denis.educaquiz.Model.Fase;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class MainActivity extends Activity {
    public EditText alertIdade;
    public EditText alertNome;

    public List<Usuario> list;
    ListView listView = null;
    public AlertDialog.Builder builder;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        try {
            for (String file:getAssets().list("xml")
                 ) {
                try {
                    LeXmls(file);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        listView = (ListView) this.findViewById(R.id.lista);*/



//        AlertDialog ad = alertDialogIdade();
//        ad.show();
//
//        ImageButton alertBtnAumenta = (ImageButton) ad.findViewById(R.id.alert_aumenta);
//        ImageButton alertBtnDiminui = (ImageButton) ad.findViewById(R.id.alert_diminui);
//
//        alertIdade = (EditText) ad.findViewById(R.id.alert_idade);
//        alertNome = (EditText) ad.findViewById(R.id.alert_nome);
//
//        alertBtnAumenta.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//;
//
//                if (Integer.parseInt(alertIdade.getText().toString()) < 12){
//                    alertIdade.setText(String.valueOf(Integer.parseInt(alertIdade.getText().toString())+1));
//                }
//            }
//        });
//
//        alertBtnDiminui.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (Integer.parseInt(alertIdade.getText().toString()) > 4){
//                    alertIdade.setText(String.valueOf(Integer.parseInt(alertIdade.getText().toString())-1));
//                }
//            }
//        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /*public void carregaXML() throws IOException, ParserConfigurationException, SAXException {

        ArrayList array2 = new ArrayList<Perguntas>();


        ArrayList array1 = new ArrayList<Alternativas>();

        array1.add(new Alternativas(1, "cachorro"));
        array1.add(new Alternativas(1, "gato"));
        array1.add(new Alternativas(1, "leao"));

        array2.add(new Perguntas(1, "Qual desses Animais emite o som de um Latido ?", 1, array1));
        XStream xstream = new XStream();


        String teste = xstream.toXML(array2);
        InputStream input = getClass().getResourceAsStream("/com/example/denis/educaquiz/xml/teste.xml");
        InputStream is;
        String[] list123 = getAssets().list("xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc12 = dBuilder.parse(getAssets().open("xml/teste1.xml"));

        //String xml = xstream.fromXML(getAssets().open("xml/teste1.xml")).toString();

        List<String> lista = new ArrayList<String>();

        NodeList raiz = doc12.getElementsByTagName("Fase").item(0).getChildNodes();


        for(int i=0;i<raiz.getLength();i++){
            if(raiz.item(i).getNodeName().equals("Pergunta"))
            {
                NodeList filho1 = raiz.item(i).getChildNodes();
                for(int j=0;j<filho1.getLength();j++){
                    if(filho1.item(j).getNodeName().equals("TXT_PERGUNTA"))
                    {
                        String txt_pergunta = filho1.item(j).getTextContent();
                    }
                    else if(filho1.item(j).getNodeName().equals("CORRETA"))
                    {
                        String correta = filho1.item(j).getTextContent();
                    }
                    else if(filho1.item(j).getNodeName().equals("ALTERNATIVAS"))
                    {
                        NodeList filho2 = filho1.item(j).getChildNodes();
                        for(int l=0;l<filho2.getLength();l++)
                        {
                            if(!filho2.item(l).getNodeName().equals("#text"))
                            {
                                String alternativa = filho2.item(l).getTextContent();

                            }

                        }

                    }

                }


            }

        }

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {

            case R.id.usuarios_id:


                //listView.setAdapter(adapter);

                //AlertDialog_ListaUsuarios();

                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void AddUsuario(View view) {


        this.startActivity(new Intent(this, NovoUsuario.class));

    }

    public void itemClick(View view) {


    }

    public void Iniciar(View view){
/*        Usuario user = new UsuarioDAO(getApplicationContext()).pesquisaNome("Denis");
        Intent i = new Intent(this,SelecaoFase.class);
        i.putExtra("Nome",user.getNome());
        i.putExtra("Idade",user.getIdade());
        i.putExtra("TotalPontos",user.getTotalpontos());

        startActivity(i);*/

        Usuario user = new Usuario("Children",8,0);

        Intent i = new Intent(this,SelecaoFase.class );
        i.putExtra("Nome",user.getNome());
        i.putExtra("Idade",user.getIdade());
        i.putExtra("TotalPontos",user.getTotalpontos());
        startActivity(i);
    }





    /*
    public AlertDialog alertDialogIdade() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.alertdialog_relativeLayout);
        LayoutInflater inflater = getLayoutInflater();
    // Inflate and set the layout for the dialog
    // Pass null as the parent view because its going in the dialog
    // layoutZZ
        alert.setCancelable(false);
        alert.setView(inflater.inflate(R.layout.alertdialog, null));
        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
    //            user = new Usuario();
    //            user.Usuario(alertNome.getText().toString(),Integer.parseInt(alertIdade.getText().toString()));
    //            userDAO = new UsuarioDAO();
    //            userDAO.UsuarioDAO(getBaseContext());
    //            Toast.makeText(getBaseContext(),userDAO.insereUsuario(user) , Toast.LENGTH_SHORT).show();
                //banco.insertDados(alertNome.getText().toString(),Integer.parseInt(alertIdade.getText().toString()));
               //Toast.makeText(getBaseContext(), "Bem Vindo" , Toast.LENGTH_SHORT).show();
            }
        });

       return alert.create();

    }*/
    public Fase LeXmls(String file) throws ParserConfigurationException, IOException, SAXException {


        List<Perguntas> perguntas =  new ArrayList<Perguntas>();


        Fase fase = new Fase();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc12 = dBuilder.parse(getAssets().open("xml/" + file));

        NodeList raiz = doc12.getElementsByTagName("Fase").item(0).getChildNodes();
        for(int i=0;i<raiz.getLength();i++){
            if(raiz.item(i).getNodeName().equals("PontosObrigatorios")){
                fase.setPontosObrigatorios(Integer.valueOf(raiz.item(i).getTextContent()));
            }

            if(raiz.item(i).getNodeName().equals("Perguntas"))
            {

                Perguntas pergunta =  new Perguntas();
                List<Alternativas> alternativas = new ArrayList<Alternativas>();
                NodeList filho1 = raiz.item(i).getChildNodes();
                for(int j=0;j<filho1.getLength();j++){
                    if(filho1.item(j).getNodeName().equals("Pergunta"))
                    {
                        pergunta.setPergunta(filho1.item(j).getTextContent());
                        pergunta.setIdPergunta(Integer.valueOf(filho1.item(j).getAttributes().item(0).getTextContent()));
                    }
                    else if(filho1.item(j).getNodeName().equals("RespostaCorreta"))
                    {
                        pergunta.setRespostaCorreta(filho1.item(j).getTextContent());
                    }
                    else if(filho1.item(j).getNodeName().equals("Imagem"))
                    {
                        pergunta.setImagem(filho1.item(j).getTextContent());
                    }
                    else if(filho1.item(j).getNodeName().equals("Pontos"))
                    {
                        pergunta.setPontos(Integer.valueOf(filho1.item(j).getTextContent()));

                    }
                    else if(filho1.item(j).getNodeName().equals("Alternativas"))
                    {

                        NodeList filho2 = filho1.item(j).getChildNodes();
                        for(int l=0;l<filho2.getLength();l++)
                        {
                            Alternativas alter = new Alternativas();
                            if(!filho2.item(l).getNodeName().equals("#text"))
                            {
                                alter.setIdAlternativa(Integer.valueOf(filho2.item(l).getAttributes().item(0).getTextContent()));
                                alter.setAlternativa(filho2.item(l).getTextContent());
                                alternativas.add(alter);
                            }

                        }



                    }


                }
                pergunta.setAlternativas(alternativas);
                perguntas.add(pergunta);

            }
        }
        fase.setPerguntas(perguntas);

        return fase;
    }


    public void AlertDialog_ListaUsuarios() {

        UsuarioDAO userDAO = new UsuarioDAO(getBaseContext());
        List<String> listuser = new ArrayList<String>();

        for (Usuario user : userDAO.pesquisaTodos()) {
            listuser.add(user.getNome());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listitem, R.id.txtitem, listuser);

        builder = new AlertDialog.Builder(MainActivity.this);
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.listviewlayout);
        LayoutInflater inflater = getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.listview,null));
        builder.setCancelable(true);
        builder.setPositiveButton("OK", null);
        AlertDialog dialogs = builder.create();
        dialogs.show();

    }

}
