package com.mlabs.bbm.firstandroidapp;

import android.content.Intent;
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
        Button btnSignUp ;
        final EditText etsignEmail, etsignPass;

        etsignEmail = (EditText)findViewById(R.id.etsignEmail);
        etsignPass = (EditText)findViewById(R.id.etsignPass);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);



    }

}
