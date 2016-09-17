package com.mlabs.bbm.firstandroidapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by androidstudio on 17/09/16.
 */
public class signup extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        SQLiteDatabase mydatabase = openOrCreateDatabase("dbAccounts",MODE_PRIVATE,null);
        Button btnSignUp ;
        final EditText etsignEmail, etsignPass, etsignConPass;

        etsignEmail = (EditText)findViewById(R.id.etsignEmail);
        etsignPass = (EditText)findViewById(R.id.etsignPass);
        etsignConPass = (EditText)findViewById(R.id.etsignConPass);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Pattern.compile("([a-zA-Z0-9]+_?)+@[a-zA-Z0-9]+\\.com").matcher(etsignEmail.getText()).matches()){
                    if(!(etsignPass.length()== 0)){
                        if(etsignPass.length()>8 && etsignConPass.getText().equals(etsignEmail)){

                        } else Toast.makeText(getBaseContext(),"Password too short", Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(getBaseContext(),"Password field is empty", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(getBaseContext(),"Invalid Email Address", Toast.LENGTH_SHORT).show();


                    /*Toast.makeText(getBaseContext(),, Toast.LENGTH_SHORT).show();*/
            }
        });


    }

}
