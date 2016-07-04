package com.example.ortega.vaccinesapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText etAfiliacion, etPassword;
    Paciente paciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iniciarComponentes();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paciente = new Paciente(etAfiliacion.getText().toString(), etPassword.getText().toString());

                //Primero validamos usuario
                if(etAfiliacion.getText().toString().equals(paciente.obtenerNombre())){  //si el nombre de usuario NO es correcto o NO se encuentra en la base de datos
                    //Se lanza un cuadro de dialogo que indica al usuario que el No. de afiliacion no es correcto

                    FragmentManager fragmentManager = getSupportFragmentManager();

                    DialogoError msjError = new DialogoError();
                    msjError.establecerTitulo("ERROR!!! (x_X)");
                    msjError.establecerMensaje("El paciente no está registrado en el sistema :'(");

                   // msjError.show(fragmentManager, "tagAlerta");

                }else{

                }
            }
        });

    }

    private void iniciarComponentes(){
        btnLogin = (Button) super.findViewById(R.id.buttonLogin);
        etAfiliacion = (EditText) super.findViewById(R.id.etNumAfiliacion);
        etPassword = (EditText) super.findViewById(R.id.etPassword);
    }
}
