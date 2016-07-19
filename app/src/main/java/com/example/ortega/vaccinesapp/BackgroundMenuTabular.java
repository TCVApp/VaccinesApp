package com.example.ortega.vaccinesapp;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
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
import java.util.Calendar;

/**
 * Created by Ortega on 18/07/2016.
 */

/*Esta clase compara la fecha actual del celular con las fechas de las proximas vacunas del paciente*/

public class BackgroundMenuTabular extends AsyncTask<String, Void, String> {
    NotificationCompat.Builder nBuilder;
    AlertDialog dialogoAlerta;
    Context contexto;
    String nAfiliacion;
    String fechaActual = "";

    private static final int NOTIF_ALERTA_ID = 1;

    public BackgroundMenuTabular(Context ctx){
        this.contexto = ctx;
    }

    @Override
    protected String doInBackground(String... parametros) {
        String tipo = parametros[0];
        String url_notificacion = new Conexion().obtenerURLNotificacion();

        if (tipo.equals("Notificacion")){
            try {
                //regogemos los parametros que vamos a procesar
                nAfiliacion = parametros[1];

                Calendar calendario = Calendar.getInstance();
                fechaActual += Integer.toString(calendario.get(Calendar.DATE))+"/"
                               +Integer.toString(calendario.get(Calendar.MONTH))+"/"                 //Posible error en el mes
                               +Integer.toString(calendario.get(Calendar.YEAR));

                URL url = new URL(url_notificacion);

                //Abrir conexion con el servidor por medio de http
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");                                        //El método de POST lo recibira el script Login.php
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                //Flujo de salida
                OutputStream flujoSalida = httpURLConnection.getOutputStream();

                //Escritura en el buffer
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(flujoSalida, "UTF-8"));

                //Código pesado para ENVIAR los datos a la peticion
                String post_data = URLEncoder.encode("nAfiliacion", "UTF-8") +"="+ URLEncoder.encode(nAfiliacion, "UTF-8") +"&"    //Para el _POST["afiliacion"]
                        +URLEncoder.encode("fecha_actual", "UTF-8") +"="+ URLEncoder.encode(fechaActual, "UTF-8");                       //Para el _POST["password"]

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
        //dialogoAlerta = new AlertDialog.Builder(contexto).create();
        //dialogoAlerta.setTitle("Login Status");

         nBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(contexto)
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setLargeIcon((((BitmapDrawable)contexto.getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap()))
                .setContentTitle("Mensaje de Alerta")
                .setContentText("Usuario: " +nAfiliacion+ " tiene una notificacion")
                .setContentInfo("1")
                .setTicker("Alerta!");
    }

    @Override
    protected void onPostExecute(String resultado){

        //Lanza la notificacion al usuario:
        NotificationManager mNotificationManager = (NotificationManager) contexto.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(BackgroundMenuTabular.NOTIF_ALERTA_ID, nBuilder.build());
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
