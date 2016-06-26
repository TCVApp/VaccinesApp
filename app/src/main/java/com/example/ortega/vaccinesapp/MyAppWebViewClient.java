package com.example.ortega.vaccinesapp;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URI;
import java.net.URL;

/**
 * Created by Ortega on 23/06/2016.
 */
public class MyAppWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url){
        //URL base de la app (al salir de esta url, abre el navegador)
        if (Uri.parse(url).getHost().endsWith("10.161.249.202")){
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}