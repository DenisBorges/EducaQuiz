package com.example.denis.educaquiz;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Bundle;
import android.service.dreams.DreamService;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.denis.educaquiz.Model.Fase;
import com.example.denis.educaquiz.Model.Usuario;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by Denis on 01/05/2016.
 */
public class SelecaoFase extends Activity {

    public Usuario user;
    //private List<Fase> fases;
    public TextView nome, totalPontos;
    public ImageSwitcher sw;
    public List<Object[]> imagens;
    public String imagemAtual="";
    public int index = 0;
    public int pontos = 0;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selecaofases);
        carregaUsuario(getIntent().getExtras());

        //((Button) findViewById(R.id.btn_anterior)).setEnabled(false);

        ((EditText) findViewById(R.id.txtSpeechInput)).addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if(!s.equals("") )
                { //do your work here }

                    switch (((String) imagens.get(index)[1])){
                        case "1":
                            if (s.toString().equals("coala")){
                              pontos +=1;
                            }

                            break;
                        case "2":
                            if (s.toString().equals("elefante")){
                                pontos +=1;

                            }
                            break;
                        case "3":
                            if (s.toString().equals("esquilo")){
                                pontos +=1;

                            }
                            break;
                        case "4":
                            if (s.toString().equals("jacaré")){
                                pontos +=1;

                            }
                            break;
                        case "5":
                            if (s.toString().equals("leão")){
                                pontos +=1;

                            }
                            break;
                        case "6":
                            if (s.toString().equals("porco espinho")){
                                pontos +=1;

                            }
                            break;
                        case "7":
                            if (s.toString().equals("urso")){
                                pontos +=1;

                            }
                            break;
                        case "8":
                            if (s.toString().equals("veado")){
                                pontos +=1;

                            }
                            break;
                    }


                        totalPontos.setText(String.valueOf(pontos));
                        index += 1;
                        AlteraImagem(index);
                        //((EditText) findViewById(R.id.txtSpeechInput)).setText("");



                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void afterTextChanged(Editable s) {

            }
        });

        try {
            CarregaImagens();
        } catch (IOException e) {
            e.printStackTrace();
        }


        sw = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        //sw = new ImageSwitcher(getApplicationContext());
        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView im = new ImageView(getApplicationContext());
                im.setScaleType(ImageView.ScaleType.FIT_CENTER);
                im.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT));
                ;
                return im;
            }
        });

        sw.setImageDrawable((Drawable)imagens.get(this.index)[0]);



    }

    public void CarregaImagens() throws IOException {
        imagens = new ArrayList<Object[]>();
        for (String file : getAssets().list("image")
                ) {
            InputStream ims = getAssets().open("image/" + file);
            String nome = file.substring(0,1);
            Bitmap b = ((BitmapDrawable) Drawable.createFromStream(ims, null)).getBitmap();

            imagens.add(new Object[] {new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(b, 500, 500, true)),nome});
        }
        Collections.shuffle(imagens);

    }

    ;

    public void carregaUsuario(Bundle usuario) {

        user = new Usuario(usuario.getString("Nome"), usuario.getInt("Idade"), usuario.getInt("TotalPontos"));

        nome = (TextView) findViewById(R.id.txtUsuario_SelecaoFase);
        totalPontos = (TextView) findViewById(R.id.txtTotalPontos_SelecaoFase);

        nome.setText(user.getNome());
        totalPontos.setText(String.valueOf(user.getTotalpontos()));

    }


    public void AlteraImagem(int index) {


/*        switch ((String) b.getText()) {
            case "Anterior":
                index -= 1;
                HabilitaDesabilitaBotao();

                sw.setInAnimation(this, R.anim.slide_in_right); // added
                sw.setOutAnimation(this, R.anim.slide_out_right); //added

                sw.setImageDrawable(imagens.get(index));
                break;


            case "Próximo":*/

        if (index != imagens.size()) {
            sw.setInAnimation(this, R.anim.slide_in_left); // added
            sw.setOutAnimation(this, R.anim.slide_out_left); // added

            sw.setImageDrawable((Drawable)imagens.get(index)[0]);
            //break;
        }

                //HabilitaDesabilitaBotao();



        //}


    }

    public void HabilitaDesabilitaBotao() {
        if (index + 1 == imagens.size()) {
            //((Button) findViewById(R.id.btn_proximo)).setEnabled(false);
        } else {
            //((Button) findViewById(R.id.btn_proximo)).setEnabled(true);
        }

        if (index == 0) {
            //((Button) findViewById(R.id.btn_anterior)).setEnabled(false);
        } else {
            //((Button) findViewById(R.id.btn_anterior)).setEnabled(true);
        }
    }
/*    public Drawable getRandomImage() {
        int index = geradorAleatorio.nextInt(imagens.size());
        Drawable imagem = imagens.get(index);
        return imagem;
    }*/


    public void promptSpeechInput(View v) {
/*        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));*/

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "pt-BR");

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }



    public List<Fase> CarregaFases() {


        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    ((EditText) findViewById(R.id.txtSpeechInput)).setText(result.get(0));

                }
                break;
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
