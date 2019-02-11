package com.example.user.sharedpreferencea;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText LogEmail, LogPswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LogEmail = (EditText) findViewById(R.id.logemil);
        LogPswd = (EditText) findViewById(R.id.logpsswd);
    }


    public void nwusrclick(View view) {


            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        }

    public void okclick(View view) {
        String Eml = LogEmail.getText().toString();
         String Pswd = LogPswd.getText().toString();
        SharedPreferences shred=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
        String ab=shred.getString("Emailkey",null);
        String bh=shred.getString("Passwordkey",null);

         if((Eml.equals(ab))&&(Pswd.equals(bh)))
        {
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            Intent jk=new Intent(Login.this,Profile.class);
            startActivity(jk);
        }
        else
         {
             Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
         }

    }
}

