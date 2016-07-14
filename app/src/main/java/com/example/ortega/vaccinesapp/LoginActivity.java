package com.example.ortega.vaccinesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText etAfiliacion, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        iniciarComponentes();
    }

    private void iniciarComponentes(){
        etAfiliacion = (EditText) super.findViewById(R.id.etNumAfiliacion);
        etPassword = (EditText) super.findViewById(R.id.etPassword);
    }

    public void onLoguear(View view){
        String nAfiliacion = etAfiliacion.getText().toString();
        String pass = etPassword.getText().toString();

        //Creamos el objeto BackgroundWorker y pasamos como parametro el contexto de ésta clase para que el procesamiento lo haga en segundo plano
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute("Login", nAfiliacion, pass);   //Pasamos los argumentos con los que se debe de trabajar en segundo plano

    }
}
