package com.example.agenda;

import android.app.Activity;

import androidx.appcompat.app.AlertDialog;


public class MSG {

    //classe em static para utilizar a função sem precisar instanciar o objeto
    public static void mensagem(String txt, Activity act) {
        AlertDialog.Builder adb = new AlertDialog.Builder(act);
        adb.setMessage(txt);
        adb.setNeutralButton("OK", null);
        adb.show();
    }


}
