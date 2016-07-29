package com.example.ortega.vaccinesapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TabHost;


public class MenuTabular extends AppCompatActivity {
    private static final int NOTIF_ALERTA_ID = 1;

    TabHost tabs;
    Resources recursos;
    WebView wvPerfil, wvEsquema, wvNutricion, wvCitas, wvMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tabular);

        wvPerfil = (WebView) super.findViewById(R.id.WebView_perfil);
        wvEsquema = (WebView) super.findViewById(R.id.WebView_esquema);
        wvNutricion = (WebView) super.findViewById(R.id.WebView_nutricion);
        wvCitas =  (WebView) super.findViewById(R.id.WebView_citas);
        wvMaps = (WebView) super.findViewById(R.id.WebView_maps);

        //Recuperamos la información pasada en el LoginActivity
        Bundle bundle = this.getIntent().getExtras();
        String usuario = bundle.getString("N_AFILIACION");
        Log.e("Recuparacion:", "Recupere el dato: " +usuario);

        //Crear una notificacion de acuerdo al dato recibido
        NotificationCompat.Builder nBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(MenuTabular.this)
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setLargeIcon((((BitmapDrawable)getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap()))
                .setContentTitle("Mensaje de Alerta")
                .setContentText("Usuario: " +usuario+ " tiene una notificacion")
                .setContentInfo("1")
                .setTicker("Alerta!");

        //codigo para llamar a la actividad cuando se presiona en la notificacion
        Intent intent = new Intent(MenuTabular.this, NotificacionActivity.class);
        PendingIntent contIntent = PendingIntent.getActivity(MenuTabular.this, 0, intent, 0);
        nBuilder.setContentIntent(contIntent);

        //Lanza la notificacion al usuario:
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(MenuTabular.NOTIF_ALERTA_ID, nBuilder.build());


        //Creamos el objeto BackgroundWorker y pasamos como parametro el contexto de ésta clase para que el procesamiento lo haga en segundo plano
        //BackgroundMenuTabular backgroundWorker = new BackgroundMenuTabular(this);
        //backgroundWorker.execute("Notificacion", usuario, "");   //Pasamos los argumentos con los que se debe de trabajar en segundo plano


        //------------------------------------------------------------------------------------------------------------------
        recursos = super.getResources();

        tabs = (TabHost) super.findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("miTab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("INICIO", recursos.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        //-----------------------------------------------------trabajando con WebView del Inicio-----------------------------------------------------
        //Activamos JavaScript
        WebSettings configuracionWeb = wvPerfil.getSettings();
        configuracionWeb.setJavaScriptEnabled(true);

        //URL que carga nuestra app (WebView)
        wvPerfil.loadUrl(new Conexion().obtenerURLInicio());

        //forzamos el webview para que abra los enlaces INTERNOS dentro de la APP
        wvPerfil.setWebViewClient(new WebViewClient());

        //forzamos el WebView para que abra los enlaces externos en el Navegador
        //wvPerfil.setWebViewClient(new MyAppWebViewClient());


        //-------------------------------------------------------------------------------------------------------------------------------------------


        spec = tabs.newTabSpec("miTab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("ESQUEMA", recursos.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        //-----------------------------------------------------trabajando con WebView del Esquema-----------------------------------------------------
        //Activamos JavaScript
        WebSettings configuracionWeb2 = wvEsquema.getSettings();
        configuracionWeb2.setJavaScriptEnabled(true);

        //URL que carga nuestra app (WebView)
        wvEsquema.loadUrl(new Conexion().obtenerURLEsquema());

        //forzamos el webview para que abra los enlaces INTERNOS dentro de la APP
        wvEsquema.setWebViewClient(new WebViewClient());

        //forzamos el WebView para que abra los enlaces externos en el Navegador
        //wvEsquema.setWebViewClient(new MyAppWebViewClient());


        //-------------------------------------------------------------------------------------------------------------------------------------------


        spec = tabs.newTabSpec("miTab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("PERFIL", recursos.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        //-----------------------------------------------------trabajando con WebView del Perfil-----------------------------------------------------
        //Activamos JavaScript
        WebSettings configuracionWeb3 = wvPerfil.getSettings();
        configuracionWeb3.setJavaScriptEnabled(true);

        //URL que carga nuestra app (WebView)
        wvPerfil.loadUrl(new Conexion().obtenerURLPerfil());

        //forzamos el webview para que abra los enlaces INTERNOS dentro de la APP
        wvPerfil.setWebViewClient(new WebViewClient());

        //forzamos el WebView para que abra los enlaces externos en el Navegador
        //wvPerfil.setWebViewClient(new MyAppWebViewClient());


        //-------------------------------------------------------------------------------------------------------------------------------------------

        spec = tabs.newTabSpec("miTab4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("NUTRI", recursos.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        //-----------------------------------------------------trabajando con WebView de Nutricion-----------------------------------------------------
        //Activamos JavaScript
        WebSettings configuracionWeb4 = wvNutricion.getSettings();
        configuracionWeb4.setJavaScriptEnabled(true);

        //URL que carga nuestra app (WebView)
        wvNutricion.loadUrl(new Conexion().obtenerURLNutricion());

        //forzamos el webview para que abra los enlaces INTERNOS dentro de la APP
        wvNutricion.setWebViewClient(new WebViewClient());

        //forzamos el WebView para que abra los enlaces externos en el Navegador
        //wvNutricion.setWebViewClient(new MyAppWebViewClient());


        //-------------------------------------------------------------------------------------------------------------------------------------------

        spec = tabs.newTabSpec("miTab5");
        spec.setContent(R.id.tab5);
        spec.setIndicator("CITAS", recursos.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        //-----------------------------------------------------trabajando con WebView de Citas-----------------------------------------------------
        //Activamos JavaScript
        WebSettings configuracionWeb5 = wvCitas.getSettings();
        configuracionWeb5.setJavaScriptEnabled(true);

        //URL que carga nuestra app (WebView)
        wvCitas.loadUrl(new Conexion().obtenerURLCitas());

        //forzamos el webview para que abra los enlaces INTERNOS dentro de la APP
        wvCitas.setWebViewClient(new WebViewClient());

        //forzamos el WebView para que abra los enlaces externos en el Navegador
        //wvCitas.setWebViewClient(new MyAppWebViewClient());


        //-------------------------------------------------------------------------------------------------------------------------------------------

        spec = tabs.newTabSpec("miTab6");
        spec.setContent(R.id.tab6);
        spec.setIndicator("MAPA", recursos.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        //-----------------------------------------------------trabajando con WebView de Mapas-----------------------------------------------------
        //Activamos JavaScript
        WebSettings configuracionWeb6 = wvMaps.getSettings();
        configuracionWeb6.setJavaScriptEnabled(true);

        //URL que carga nuestra app (WebView)
        wvMaps.loadUrl(new Conexion().obtenerURLMaps());

        //forzamos el webview para que abra los enlaces INTERNOS dentro de la APP
        wvMaps.setWebViewClient(new WebViewClient());

        //forzamos el WebView para que abra los enlaces externos en el Navegador
        //wvMaps.setWebViewClient(new MyAppWebViewClient());


        //-------------------------------------------------------------------------------------------------------------------------------------------

        tabs.setCurrentTab(0);

        //Implementacion del evento para visualizar las tabulaciones
        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.i("Android Tabs", "Pestaña pulsada: " +tabId);

                // De acuerdo a la pestaña seleccionada, mostrar la información correcta en la webView

            }
        });
    }
}
