package com.androidchatapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity {
    ImageButton homeButton, usersButton, profileButton;
    Button logoutButton;
    TextView aboutusButton, wtamuButton, faqsButton, contactusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        contactusButton = (TextView)findViewById(R.id.contactus);
        contactusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContactusActivity();
            }
        });

        faqsButton = (TextView)findViewById(R.id.faqs);
        faqsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFaqsActivity();
            }
        });


        aboutusButton = (TextView)findViewById(R.id.btnaboutus);
        aboutusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutUsActivity();
            }
        });

        faqsButton = (TextView) findViewById(R.id.faqs);
        faqsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFaqsActivity();

            }
        });

        wtamuButton = (TextView) findViewById(R.id.btnwtamu);
        wtamuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://wtamu.edu/"));
                startActivity(intent);
            }
        });

        logoutButton = (Button) findViewById(R.id.btnLogout);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });


        homeButton = (ImageButton) findViewById(R.id.usersHomeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });


        usersButton = (ImageButton) findViewById(R.id.usersChatButton);

        usersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity();
            }
        });

        profileButton = (ImageButton) findViewById(R.id.usersProfileButton);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileActivity();
            }
        });
    }

    public void openChatActivity() {
        Intent intent = new Intent(this, Users.class);
        startActivity(intent);
    }

    public void openHomeActivity() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void openProfileActivity() {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void openLoginActivity() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

       public void openAboutUsActivity(){
        Intent intent = new Intent(this, Aboutus.class);
        startActivity(intent);
    }
    public void openFaqsActivity(){
        Intent intent = new Intent(this, faqs.class);
        startActivity(intent);
    }
    public void openContactusActivity(){
        Intent intent = new Intent(this, ContactUs.class);
        startActivity(intent);
    }
    }






