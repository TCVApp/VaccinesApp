package com.example.ortega.vaccinesapp;

/**
 * Created by Ortega on 02/07/2016.
 */

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Paciente {
    private String nAfiliacion;
    private String password;
    private String url;
    private JSONArray arregloJSON;
    AsyncHttpClient cliente;

    public Paciente(String nAfiliacion, String password){
        this.url = "http://192.168.10.234/Fepro/getUsuario.php";
        this.nAfiliacion = nAfiliacion;
        this.password = password;
        cliente = new AsyncHttpClient();

        RequestParams parametros = new RequestParams();
        parametros.put("nombre", "NOEMI FRANCO");

        cliente.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    try {
                        arregloJSON = new JSONArray(new String(responseBody));

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public String obtenerAfiliacion() {

        /*try {
            //Buscar el usuario dentro del arregloJSON de acuerdo a nuestro atributo
            for(int i=0; i < arregloJSON.length(); i++){
                if(arregloJSON.getJSONObject(i).getString("afiliacion").equals(nAfiliacion)){
                    return arregloJSON.getJSONObject(i).getString("afiliacion");                  //devuelve el numero de afiliacion encontrado en el array
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/

        //devuelve error si la afiliacion dada por el usuario no existe en el arregloJSON obtenida de la base de datos

        String afiliacion = "error";

        try {
            afiliacion = arregloJSON.getJSONObject(0).getString("afiliacion");
        }catch (Exception e){
            e.printStackTrace();
        }

        return afiliacion;
    }

    public String obtenerPassword(){

       /* try {
            //Buscar el usuario dentro del arregloJSON de acuerdo a nuestro atributo
            for(int i=0; i < arregloJSON.length(); i++){
                if(arregloJSON.getJSONObject(i).getString("password").equals(nAfiliacion)){
                    return arregloJSON.getJSONObject(i).getString("password");        //devuelve la contraseña encontrado en el array
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/

        String afiliacion = "error";

        try {
            afiliacion = arregloJSON.getJSONObject(0).getString("password");
        }catch (Exception e){
            e.printStackTrace();
        }

        //devuelve error si la contraseña dada por el usuario no existe en el arregloJSON obtenida de la base de datos
        return afiliacion;
    }
}
