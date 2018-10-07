package com.androidchatapp;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import static android.app.Activity.RESULT_OK;

public class Profile extends AppCompatActivity{
    ImageButton settingsButton, usersButton, profileButton;
    int id;
    String userid, pass;

    private Button mUploadButton;
    private ImageView imageView;
    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private ProgressDialog mProgress;
    EditText nameOfUser;
    private static final String SAVED_TEXT_KEY = "";


    @Override
    public void onSaveInstanceState(Bundle outState){
        outState.putString(SAVED_TEXT_KEY, nameOfUser.getText().toString());
        super.onSaveInstanceState(outState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        nameOfUser.setText(savedInstanceState.getString(SAVED_TEXT_KEY));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        nameOfUser = (EditText)findViewById(R.id.nameOfUser);
        if(savedInstanceState != null){
            nameOfUser.setText(savedInstanceState.getString(SAVED_TEXT_KEY));
        }

        this.imageView = (ImageView)this.findViewById(R.id.imageView);
        mUploadButton = (Button)this.findViewById(R.id.takePicButton);
        mUploadButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkSelfPermission(Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA},
                            MY_CAMERA_PERMISSION_CODE);
                }else {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });

        settingsButton = (ImageButton)findViewById(R.id.usersSettingsButton);

        settingsButton.setOnClickListener(new View.OnClickListener(){
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

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new
                        Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }

        }
    }

        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(photo);
            }
        }




    public void openChatActivity(){
        Intent intent = new Intent(this, Users.class);
        startActivity(intent);
    }

    public void openHomeActivity(){
        Intent intent = new Intent(this, Settings.class);
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
