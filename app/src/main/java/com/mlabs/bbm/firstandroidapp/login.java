package com.mlabs.bbm.firstandroidapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by Little Garden on 7/20/2016.
 */
public class login extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        Button btnlogin;
        final EditText etEmail, etPass;

        etEmail = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);
        btnlogin = (Button)findViewById(R.id.btnLogin);
        if (btnlogin != null) {
            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Pattern.compile("([a-zA-Z0-9]+_?)+@[a-zA-Z0-9]+\\.com").matcher(etEmail.getText()).matches()){
                        Toast.makeText(getBaseContext(),"Nice", Toast.LENGTH_SHORT).show();
                    }
    /*                Toast.makeText(getBaseContext(),, Toast.LENGTH_SHORT).show();*/
                }
            });
        }

    }
}
