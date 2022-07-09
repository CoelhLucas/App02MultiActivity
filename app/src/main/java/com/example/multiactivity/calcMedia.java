package com.example.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class calcMedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_media);
        Intent it = getIntent();
        if (it != null) {
            Bundle params = it.getExtras();
            if (params != null) {
                String nome = params.getString("nome");
                Double media = params.getDouble("media");
                Integer freq = params.getInt("freq");

                if(nome.length() > 0 && media >= 0 && freq >=0){
                    TextView nomeOut  = findViewById(R.id.textViewNomeOut);
                    TextView freqOut  = findViewById(R.id.textViewfreqOut);
                    TextView mediaOut = findViewById(R.id.textViewMediaOut);
                    TextView cond     = findViewById(R.id.textViewCondicao);

                    nomeOut.setText(nome);
                    freqOut.setText(freq.toString());
                    mediaOut.setText(media.toString());

                    if (freq < 75){
                        cond.setText("Reprovado por falta");
                    }
                    else if (media >= 7 && freq >= 75){
                        cond.setText("Aprovado");
                    }
                    else if (media >= 4 && media <= 6.9 && freq >= 75){
                        cond.setText("Final");
                    }
                    else if (media < 4){
                        cond.setText("Reprovado por nota");
                    }
                }
            }
        }
    }
}