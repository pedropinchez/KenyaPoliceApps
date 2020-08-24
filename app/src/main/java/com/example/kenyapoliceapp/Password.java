package com.example.kenyapoliceapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


import com.example.kenyapoliceapp.R;
import com.example.kenyapoliceapp.Utils.SharedPref;
import com.google.android.material.textfield.TextInputEditText;


public class Password extends AppCompatActivity {

    TextInputEditText editTextPassword;
    Button buttonSignIn;


    Boolean firstTime = true;

    String regnumber;
    ProgressDialog progressDialog;
    SharedPref sharedPref;


    int num = 1;

    String login_url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        editTextPassword = findViewById(R.id.editTextPortalPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);

        regnumber = getIntent().getStringExtra("regno");

        sharedPref = new SharedPref(Password.this);

        progressDialog = new ProgressDialog(Password.this);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = editTextPassword.getText().toString().trim();

                if (password.isEmpty()) {

                    editTextPassword.setError("Please provide a valid password");
                    editTextPassword.requestFocus();
                    return;
                }

                Intent intent = new Intent(Password.this, PhotoSelection.class);
                intent.putExtra("regno", regnumber);
                intent.putExtra("password",password);
                startActivity(intent);

            }
        });

    }




}
