package com.example.ecovolt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DicasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicas);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Dicas de Eficiência");
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}