package com.rku_18fotca11001.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity
{
     TextView txtout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle bundle = getIntent().getExtras();

         String fname = bundle.getString("fname");
         String lname = bundle.getString("lname");
         String email = bundle.getString("email");
         String password = bundle.getString("password");
        String  select = bundle.getString("branch");
        String  radiobtn = bundle.getString("radio");
         String  scountry  = bundle.getString("country");
         String  checkbox = bundle.getString("status");


        txtout = findViewById(R.id.txtoutput);

        txtout.setText(fname+"\n"+lname+"\n"+email+"\n"+"*****"+"\n"+select+"\n"+radiobtn+"\n"+scountry+"\n"+checkbox);


    }
}