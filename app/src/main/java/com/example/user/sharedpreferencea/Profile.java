package com.example.user.sharedpreferencea;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
TextView ProName,ProEmail,ProAge,ProPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ProName=(TextView)findViewById(R.id.pronme);
        ProEmail=(TextView)findViewById(R.id.proemail);
        ProAge=(TextView)findViewById(R.id.proag);
        ProPassword=(TextView)findViewById(R.id.propassword);
        SharedPreferences shred=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
        String hn=shred.getString("Namekey",null);
        String ab=shred.getString("Emailkey",null);
        String ji=shred.getString("Agekey",null);
        String bh=shred.getString("Passwordkey",null);
        ProName.setText(hn);
        ProEmail.setText(ab);
        ProAge.setText(ji);
        ProPassword.setText(bh);
    }

    public void upldpoto(View view) {
        Intent i=new Intent(Profile.this,Gallery.class);
        startActivity(i);
    }
}
