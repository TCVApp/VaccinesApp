package com.example.ortega.vaccinesapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Ortega on 13/07/2016.
 */
public class BackgroundWorker  extends AsyncTask<String, Void, String>{
    Context contexto;
    AlertDialog dialogoAlerta;
    String nAfiliacion, password;

    public BackgroundWorker(Context ctx){
        this.contexto = ctx;
    }

    @Override
    protected String doInBackground(String... parametros) {
        String tipo = parametros[0];
        String login_url = new Conexion().obtenerURLLogin();

        if (tipo.equals("Login")){
            try {
                //regogemos los parametros que vamos a procesar
                nAfiliacion = parametros[1];
                password = parametros[2];
                URL url = new URL(login_url);

                //Abrir conexion con el servidor por medio de http
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");                                        //El método de POST lo recibira el script Login.php
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                //Flujo de salida
                OutputStream flujoSalida = httpURLConnection.getOutputStream();

                //Escritura en el buffer
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(flujoSalida, "UTF-8"));

                //Código pesado para extaer los datos de la peticion
                String post_data = URLEncoder.encode("afiliacion", "UTF-8") +"="+ URLEncoder.encode(nAfiliacion, "UTF-8") +"&"    //Para el _POST["afiliacion"]
                        +URLEncoder.encode("password", "UTF-8") +"="+ URLEncoder.encode(password, "UTF-8");                       //Para el _POST["password"]

                //Aqui es donde enviamos los datos a la aplicacion web
                bufferedWriter.write(post_data);
                Log.e("Valor de POST", post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                //Entrada de datos desde la conexion htto
                InputStream flujoEntrada = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(flujoEntrada, "iso-8859-1"));
                String resultado = "";
                String linea = "";

                while ((linea = bufferedReader.readLine()) != null){
                    resultado += linea;
                }

                bufferedReader.close();
                flujoEntrada.close();
                httpURLConnection.disconnect();
                Log.e("Valor de res", resultado);

                return resultado;

            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPreExecute(){
        dialogoAlerta = new AlertDialog.Builder(contexto).create();
        dialogoAlerta.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String resultado){

        //Comparar el resultado para que con base a eso digamos que el usuario se logueo exitosamente
        if(resultado.equals("1")){

            Intent intent = new Intent(contexto, MenuTabular.class);

            //PAsamos el numero de afiliacion hacia la actividad MenuTabular
            Bundle bundle = new Bundle();
            bundle.putString("N_AFILIACION", nAfiliacion);

            //Añadimos la información al intent
            intent.putExtras(bundle);

            contexto.startActivity(intent);
        }else{
            dialogoAlerta.setMessage(resultado +": Login not Success");
            dialogoAlerta.show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
