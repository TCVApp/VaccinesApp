package com.example.ortega.vaccinesapp;

/**
 * Created by Ortega on 14/07/2016.
 */
public class Conexion {
    String ip;
    String url;

    public Conexion(){
        this.ip = "192.168.10.34";
        this.url = "http://"+ip+"/VaccinesAppWeb";
        //this.url = "http://"+ip+"/FeproApp";
    }

    public Conexion(String ipServer){
        this.ip = ipServer;
        this.url = "http://"+ip+"/VaccinesAppWeb";
        //this.url = "http://"+ip+"/FeproApp";
    }

    public String obtenerURLEsquema(){
        url += "/CartillaAct.php";
        return url;
    }

    public String obtenerURLPerfil(){
        url += "/PerfilAct.php";
        return url;
    }

    public String obtenerURLNutricion(){
        url += "/NutricionAct.php";
        return url;
    }

    public String obtenerURLCitas(){
        url += "/CitasAct.php";
        return url;
    }

    public String obtenerUrlRegistro(){                     //El RegistroAct.html no está en la web actual
        url += "/RegistroAct.html";
        return url;
    }

    public String obtenerURLInicio(){
        url += "/InicioAct.html";
        return url;
    }

    public String obtenerURLLogin(){
        url += "/Login.php";
        return url;
    }

    public String obtenerURLNotificacion(){
        url += "/getNotificacion.php";
        return url;
    }

}
