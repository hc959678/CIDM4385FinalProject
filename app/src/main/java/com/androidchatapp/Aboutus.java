package com.androidchatapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Aboutus extends AppCompatActivity {

    ImageButton BackButton;
    ImageButton HosuC, LukeF, DBabb;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        HosuC = (ImageButton) findViewById(R.id.hosu);
        HosuC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/king.hosu/"));
                startActivity(intent);
            }

        });

                LukeF = (ImageButton) findViewById(R.id.luke);
                LukeF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/luke.ford.374"));
                        startActivity(intent);
                    }

                });

                        DBabb = (ImageButton) findViewById(R.id.babb);
                        DBabb.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wtamu.edu/academics/jeffry-babb-bio.aspx"));
                                startActivity(intent);
                            }

                        });

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



