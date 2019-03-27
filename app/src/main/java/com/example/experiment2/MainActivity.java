package com.example.experiment2;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void toAdapterTest(View view){
        Intent intent = new Intent(this,SimpleAdapterTest.class);
        startActivity(intent);
    }
    public void toXMLmenuTest(View view){
        Intent intent = new Intent(this,XMLmenu.class);
        startActivity(intent);
    }
    public void  toActionmodeTest(View view){
        Intent intent = new Intent(this,ActionModeTest.class);
        startActivity(intent);
    }
    public void login(View view){
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(R.layout.activity_alert_dialog_test)
                .show();
        Button sign = dialog.findViewById(R.id.sign);
        Button cancel = dialog.findViewById(R.id.cancel);
        if (cancel != null) {
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }
        if (sign != null) {
            sign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText editText = dialog.findViewById(R.id.username);
                    if (editText != null) {
                        Toast.makeText(getApplicationContext(), "Sign in success", Toast.LENGTH_LONG).show();
                }
            }
         });
        }
    }
}
