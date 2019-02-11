package com.example.user.sharedpreferencea;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText Name, Email, Age, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name = (EditText) findViewById(R.id.regnme);
       // Name=finn bn
        Email = (EditText) findViewById(R.id.regeml);
        Age = (EditText) findViewById(R.id.Regage);
        Password = (EditText) findViewById(R.id.regpswd);
    }

    public void Regclick(View view) {


        String regName = Name.getText().toString();
        String regEmail  = Email.getText().toString();
        String regAge = Age.getText().toString();
        String regPassword = Password.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (regName.isEmpty())

        {
           // Toast.makeText(, "HHHH", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
            Name.setError("Enter Name");
        } else if (regEmail.isEmpty()) {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
            Email.setError("Enter Email");
        } else if (regAge.isEmpty()) {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
            Age.setError("Enter age");
        } else if (regPassword.isEmpty()) {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
            Password.setError("Enetr password");

        }

        else if(regEmail.matches(emailPattern)) {
            Toast.makeText(this, "succesfully registered ", Toast.LENGTH_SHORT).show();
            SharedPreferences shred=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
            SharedPreferences.Editor rt=shred.edit();
            rt.putString("Emailkey",regEmail);
            rt.putString("Namekey",regName);

            rt.putString("Agekey",regAge);
            rt.putString("Passwordkey",regPassword);
            rt.commit();
            Intent in = new Intent(Register.this, Login.class);
            startActivity(in);
        }
        else
        {
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
        }
    }
}
