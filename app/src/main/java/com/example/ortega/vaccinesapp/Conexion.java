package com.example.ortega.vaccinesapp;

/**
 * Created by Ortega on 14/07/2016.
 */
public class Conexion {
    String ip;
    String url;

    public Conexion(){
        this.ip = "192.168.10.34";
        this.url = "http://"+ip+"/";
    }

    public Conexion(String ipServer){
        this.ip = ipServer;
        this.url = "http://"+ip+"/";
    }

    public String getUrlRegistro(){
        url += "VaccinesAppWeb//";
        return url;
    }
}
