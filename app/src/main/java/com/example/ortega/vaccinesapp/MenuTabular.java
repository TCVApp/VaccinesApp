package com.example.ortega.vaccinesapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TabHost;

public class MenuTabular extends AppCompatActivity {
    TabHost tabs;
    Resources recursos;
    WebView wvPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tabular);

        wvPerfil = (WebView) super.findViewById(R.id.WebView_perfil);

        recursos = super.getResources();

        tabs = (TabHost) super.findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("miTab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("INICIO", recursos.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        //-----------------------------------------------------trabajando con WebView del Perfil-----------------------------------------------------
        //Activamos JavaScript
        WebSettings configuracionWeb = wvPerfil.getSettings();
        configuracionWeb.setJavaScriptEnabled(true);

        //URL que carga nuestra app (WebView)
        wvPerfil.loadUrl("http://192.168.10.34/VaccinesAppWeb/InicioAct.html");

        //forzamos el webview para que abra los enlaces INTERNOS dentro de la APP
        wvPerfil.setWebViewClient(new WebViewClient());

        //forzamos el WebView para que abra los enlaces externos en el Navegador
        wvPerfil.setWebViewClient(new MyAppWebViewClient());

        //-------------------------------------------------------------------------------------------------------------------------------------------


        spec = tabs.newTabSpec("miTab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("ESQUEMA", recursos.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec = tabs.newTabSpec("miTab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("PERFIL", recursos.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec = tabs.newTabSpec("miTab4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("NUTRI", recursos.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec = tabs.newTabSpec("miTab5");
        spec.setContent(R.id.tab5);
        spec.setIndicator("CITAS", recursos.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec = tabs.newTabSpec("miTab6");
        spec.setContent(R.id.tab6);
        spec.setIndicator("MAPA", recursos.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

        //Implementacion del evento para visualizar las tabulaciones
        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.i("Android Tabs", "Pestaña pulsada: " +tabId);
            }
        });
    }
}
