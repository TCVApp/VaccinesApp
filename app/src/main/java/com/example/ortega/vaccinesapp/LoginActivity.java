package com.example.ortega.vaccinesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                Toast toast;

                //Primero validamos usuario
                if(!etAfiliacion.getText().toString().equals(paciente.obtenerAfiliacion())){  //si el nombre de usuario NO es correcto o NO se encuentra en la base de datos
                    //Se lanza un cuadro de dialogo que indica al usuario que el No. de afiliacion no es correcto

                    toast = Toast.makeText(getApplicationContext(), "El paciente no está registrado ", Toast.LENGTH_SHORT);
                    toast.show();
                }else if(!etPassword.getText().toString().equals(paciente.obtenerPassword())){  // si la contraseña NO es correcta
                    toast = Toast.makeText(getApplicationContext(), "Contraseña Incorrecta", Toast.LENGTH_LONG);
                    toast.show();
                }else {  //si el usuario y contraseña son correctos, entonces loguea a la aplicacion
                    Intent intent = new Intent(LoginActivity.this, InicioActivity.class);
                    startActivity(intent);
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
