package com.example.denis.educaquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.denis.educaquiz.DAO.BaseDAO;
import com.example.denis.educaquiz.DAO.CriaBanco;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Denis on 26/08/2015.
 */
public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                finish();

                Intent intent = new Intent();
                intent.setClass(Splash.this, MainActivity.class);
                startActivity(intent);
            }
        }, 3000);



    }
}
