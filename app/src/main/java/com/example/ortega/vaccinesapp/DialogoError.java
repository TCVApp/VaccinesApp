package com.example.ortega.vaccinesapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Ortega on 04/07/2016.
 */
public class DialogoError extends DialogFragment {

    private String msjError = "";
    private String titulo = "";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(msjError)
                .setTitle(titulo)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }

    public void establecerMensaje(String mensaje){
        this.msjError = mensaje;
    }

    public void establecetTitulo(String title){
        this.titulo = title;
    }
}
