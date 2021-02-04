package com.rku_18fotca11001.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;


public class Registration extends AppCompatActivity
{
    EditText fname,lname,email,password;
    Switch branch;
    RadioGroup sex;
    RadioButton radioButton;
    CheckBox status;
    Button registration;
    Spinner country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          fname = findViewById(R.id.edtfname);
          lname = findViewById(R.id.edtlname);
          email = findViewById(R.id.edtusername);
          password = findViewById(R.id.edtpassword);
          sex= (RadioGroup)findViewById(R.id.radiosex);
          status = findViewById(R.id.chkstatus);
          country = findViewById(R.id.city);
          registration = findViewById(R.id.btnregistration);
          branch = findViewById(R.id.swcbranch);

          registration.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  int selectdid = sex.getCheckedRadioButtonId();
                  radioButton = (RadioButton) findViewById(selectdid);
                  String firstname = fname.getText().toString();
                  String lastname = lname.getText().toString();
                  String emailadd = email.getText().toString();
                  String pass = password.getText().toString();
                  String countries = country.getSelectedItem().toString();
                  String stat = "";
                  String select = "";
                  if (firstname.equals(""))
                  {
                      Toast.makeText(Registration.this, "Fisrt name can't be Empty", Toast.LENGTH_SHORT).show();
                      return;
                  }
                  if (lastname.equals(""))
                  {
                      Toast.makeText(Registration.this, "Last name can't be Empty", Toast.LENGTH_SHORT).show();
                      return;
                  }
                  if (emailadd.equals(""))
                  {
                      Toast.makeText(Registration.this, "EmailAddress can't be Empty", Toast.LENGTH_SHORT).show();
                      return;
                  }
                  if (!Patterns.EMAIL_ADDRESS.matcher(emailadd).matches())
                  {
                      Toast.makeText(Registration.this, "Enter Valid Email Address", Toast.LENGTH_SHORT).show();
                      return;
                  }
                  if (pass.equals(""))
                  {
                      Toast.makeText(Registration.this, "Password can't be Empty", Toast.LENGTH_SHORT).show();
                      return;
                  }
                  if(branch.isChecked())
                  {
                      select = branch.getTextOn().toString();
                  }
                  else
                  {
                    select = branch.getTextOff().toString();
                  }
                  if(status.isChecked())
                  {
                      stat = "Active";
                  }
                  else
                  {
                      stat = "Inactive";
                  }
                  Intent intent = (new Intent(Registration.this,Profile.class));
                  intent.putExtra("fname",fname.getText().toString());
                  intent.putExtra("lname",lname.getText().toString());
                  intent.putExtra("email",email.getText().toString());
                  intent.putExtra("password",password.getText().toString());
                  intent.putExtra("country",countries);
                  intent.putExtra("radio",radioButton.getText().toString());
                  intent.putExtra("branch",select);
                  intent.putExtra("status",stat);
                  //intent.putExtra("check";
                  startActivity(intent);
                  finish();






              }
          });
    }
}