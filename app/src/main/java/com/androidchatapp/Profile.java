package com.androidchatapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.support.v7.app.AppCompatActivity;

public class Profile extends AppCompatActivity{
    ImageButton homeButton, usersButton, profileButton;
    int id;
    String userid, pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

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

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setUserid(String userid){
        this.userid = userid;
    }

    public String getUserid(){
        return this.userid;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public String getPass(){
        return this.pass;
    }
}
