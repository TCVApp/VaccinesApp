package com.example.ortega.vaccinesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnIniSesion, btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniSesion = (Button) super.findViewById(R.id.btn_inisesion);
        btnRegistrar = (Button) super.findViewById(R.id.btn_registrar);

        btnIniSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el intent para la comunicacion con la otra activity
                Intent intent = new Intent(MainActivity.this, InicioActivity.class);

                //iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el intent para la comunicacion con la otra activity
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);

                //iniciamos la nueva actividad
                startActivity(intent);
            }
        });

    }
}
