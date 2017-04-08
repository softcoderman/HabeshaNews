package com.gebeya.habeshanews;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {


    public static final String USERNAME = "USER_NAME";
    public static final String PASSWORD = "PASSWORD";
    private static final int LOGIN_USER = 10 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      SharedPreferences sharedPreferences =  PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
      SharedPreferences.Editor editor =  sharedPreferences.edit();

        //put dummy username and password for login;
        editor.putString(USERNAME, "Gere");
        editor.putString(PASSWORD, "Gere");

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivityForResult(intent, LOGIN_USER);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == LOGIN_USER) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

              // startActivity(data);
            }
        }
    }
}
