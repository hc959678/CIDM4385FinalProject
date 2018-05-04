package com.androidchatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ContactUs extends AppCompatActivity {

    ImageButton BackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        BackButton = (ImageButton) findViewById(R.id.btnback);

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });


    }

    public void openHomeActivity() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}
