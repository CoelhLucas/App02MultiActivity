package com.example.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText nome = findViewById(R.id.editTextNome);
        EditText n1 = findViewById(R.id.editTextNota1);
        EditText n2 = findViewById(R.id.editTextNota2);
        EditText freq = findViewById(R.id.editTextFreq);


        if (nome.getText().length() > 0 && n1.getText().length() > 0 && n2.getText().length() > 0 && freq.getText().length() > 0) {
            String sNome = nome.getText().toString();
            Double media = ( (Double.parseDouble(n1.getText().toString()) + Double.parseDouble(n2.getText().toString())) / 2 );
            Integer sFre = Integer.parseInt(freq.getText().toString());

            if (sFre < 0 || sFre > 100) {
                Toast.makeText(this, "Frequência entre 0 e 100.", Toast.LENGTH_SHORT).show();
            } else if (Double.parseDouble(n1.getText().toString()) < 0 || Double.parseDouble(n1.getText().toString()) > 10 ||
                    Double.parseDouble(n2.getText().toString()) < 0 || Double.parseDouble(n2.getText().toString()) > 10) {
                Toast.makeText(this, "Notas devem ser de 0 a 10.", Toast.LENGTH_SHORT).show();
            } else {
                Intent it = new Intent(this, calcMedia.class);
                Bundle params = new Bundle();
                params.putDouble("media", media);
                params.putInt("freq", sFre);
                params.putString("nome", sNome);
                it.putExtras(params);
                startActivity(it);
            }
        } else {
            Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
        }

    }

}