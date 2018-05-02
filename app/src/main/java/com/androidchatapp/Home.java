package com.androidchatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {
    ImageButton homeButton, usersButton, profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeButton = (ImageButton)findViewById(R.id.usersHomeButton);

        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });

        usersButton = (ImageButton)findViewById(R.id.usersChatButton);

        usersButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openChatActivity();
            }
        });

        profileButton = (ImageButton)findViewById(R.id.usersProfileButton);

        profileButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openProfileActivity();
            }
        });
    }

    public void openChatActivity(){
        Intent intent = new Intent(this, Users.class);
        startActivity(intent);
    }

    public void openHomeActivity(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void openProfileActivity(){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}
