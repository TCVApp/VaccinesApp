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

    public Paciente(String nAfiliacion, String password){
        this.url = "";
        this.nAfiliacion = nAfiliacion;
        this.password = password;
    }

    public String obtenerNombre() {
        AsyncHttpClient cliente = new AsyncHttpClient();
        RequestParams parametros = new RequestParams();
        parametros.put("nombre", "NOEMI FRANCO");

        cliente.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    try {
                        arregloJSON = new JSONArray(new String(responseBody));

                    }catch (Exception e){

                    }

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return "Noemi";
    }

    public String obtenerPassword(){
        return "mimichula";
    }
}
