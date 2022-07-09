package com.example.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Media extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
    }

    public void onClick(View view){
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }
}
