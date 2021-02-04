package com.tecsup.pm.gocar.ui.catalogo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tecsup.pm.gocar.R;

public class ModeloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modelo);

        Long idMarca = getIntent().getLongExtra("idMarca", 0);
        System.out.println(idMarca);
    }
}