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

    public String obtenerUrlRegistro(){                     //El RegistroAct.html no está en la web actual
        url += "VaccinesAppWeb/RegistroAct.html";
        return url;
    }

    public String obtenerURLInicio(){
        url += "VaccinesAppWeb/InicioAct.html";
        return url;
    }

    public String obtenerURLLogin(){
        url += "VaccinesAppWeb/Login.php";
        return url;
    }

}
