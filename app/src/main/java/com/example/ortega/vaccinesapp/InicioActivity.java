package com.example.ortega.vaccinesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class InicioActivity extends AppCompatActivity {
    private WebView myWebView;
    public String myURL = "http://10.161.249.202/Fepro/LoginAct.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        myWebView = (WebView) super.findViewById(R.id.miWebView);

        //Activamos JavaScript
        WebSettings configuracionWeb = myWebView.getSettings();
        configuracionWeb.setJavaScriptEnabled(true);

        //URL que carga nuestra app (WebView)
        myWebView.loadUrl(myURL);

        //forzamos el webview para que abra los enlaces INTERNOS dentro de la APP
        myWebView.setWebViewClient(new WebViewClient());

        //forzamos el WebView para que abra los enlaces externos en el Navegador
        myWebView.setWebViewClient(new MyAppWebViewClient());
    }

    //Detectar cuando se presiona el botón de retroceso
    @Override
    public void onBackPressed(){
        if(myWebView.canGoBack()){
            myWebView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
