package com.example.kenyapoliceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



import com.google.android.material.textfield.TextInputEditText;


public class id extends AppCompatActivity {

    TextInputEditText editTextRegNo;
    Button buttonContinue;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);

        editTextRegNo = findViewById(R.id.editTextRegNumber);
        buttonContinue = findViewById(R.id.buttonContinue);


        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String regnumber = editTextRegNo.getText().toString().trim();

                if (regnumber.isEmpty()) {
                    editTextRegNo.setError("Please enter a valid reg number.");
                    editTextRegNo.requestFocus();
                    return;
                }

                Intent intent = new Intent(id.this, Password.class);
                intent.putExtra("regno", regnumber);
                startActivity(intent);

            }
        });

    }


    public void Login_as_Guest(View view) {
        Intent intent = new Intent(id.this, Password.class);
        startActivity(intent);
    }
}
