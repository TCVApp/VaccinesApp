package com.example.ortega.vaccinesapp;

/**
 * Created by Ortega on 14/07/2016.
 */
public class Conexion {
    String ip;
    String url;

    public Conexion(){
        this.ip = "192.168.10.34";
        //this.url = "http://"+ip+"/VaccinesAppWeb";
        this.url = "http://"+ip+"/FeproApp";
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

    public String obtenerURLMaps(){
        //url += "/getNotificacion.php";
        return "https://www.google.com.mx/maps/place/Hospital+Gral.+Zona+Norte+de+Puebla/@19.0790287,-98.1841059,17z/data=!4m5!3m4!1s0x0:0x32ae769757902db3!8m2!3d19.0793508!4d-98.1854414";
    }

}
