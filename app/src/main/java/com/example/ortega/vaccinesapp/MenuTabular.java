package com.example.ortega.vaccinesapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

public class MenuTabular extends AppCompatActivity {
    TabHost tabs;
    Resources recursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tabular);

        recursos = super.getResources();

        tabs = (TabHost) super.findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("miTab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("TAB1", recursos.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);


        spec = tabs.newTabSpec("miTab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("TAB2", recursos.getDrawable(android.R.drawable.ic_dialog_map));
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
