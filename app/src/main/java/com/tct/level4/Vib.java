package com.tct.level4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Aditya C Awalkar on 29-03-2015.
 */
public class Vib extends Activity{

    final Context context=this;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //public void onClick(View arg0) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set title
            alertDialogBuilder.setTitle("CONFIRM");

            // set dialog message
            alertDialogBuilder
                    .setMessage("DISABLE VIBRATION ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, close
                            // current activity
                            SharedPreferences sp = Vib.this.getSharedPreferences("yo", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putInt("sss", 1);
                            editor.commit();
                            Vib.this.finish();
                            Toast.makeText(getApplicationContext(), "VIBRATION DISABLED",
                                    Toast.LENGTH_LONG).show();
                        }
                    })
                    .setNegativeButton("No",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            SharedPreferences sp = Vib.this.getSharedPreferences("yo", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putInt("sss", 0);
                            editor.commit();
                            dialog.cancel();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
    }
}

