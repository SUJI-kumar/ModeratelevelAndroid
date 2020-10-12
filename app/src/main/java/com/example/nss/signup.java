package com.example.nss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText user,pass,email,address,mobile;
    Button submit,cancel;
    RadioButton Male, Female,other;
    String hobby = "", gender;
    String sel = "", baby = "";
    CheckBox veg, non_veg, mix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        user = findViewById(R.id.edt1);
        pass = findViewById(R.id.edt2);
        email =findViewById(R.id.edt3);
        address = findViewById(R.id.edt4);
        mobile =findViewById(R.id.edt5);
        Male = findViewById(R.id.male);
        Female = findViewById(R.id.female);
        other =findViewById(R.id.other);
        veg = findViewById(R.id.hindi);
        non_veg=findViewById(R.id.english);
        mix = findViewById(R.id.hr);
        submit =findViewById(R.id.submit);
        cancel= findViewById(R.id.cancel);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = user.getText().toString();
                String p=pass.getText().toString();
                String m = Male.getText().toString();
                String fe = Female.getText().toString();
                String ot= other.getText().toString();
                String em=email.getText().toString();
                String mo=mobile.getText().toString();

                if (Male.isChecked()) {
                    gender = m;
                    sel = "1";
                } else if (Female.isChecked()) {
                    gender = fe;
                    sel = "1";
                }else if(other.isChecked())
                {
                    gender = ot;
                    sel = "1";

                }

                if (veg.isChecked()) {
                    hobby += veg.getText().toString();
                    baby = "1";
                }
                if (non_veg.isChecked()) {
                    hobby += non_veg.getText().toString();
                    baby = "1";
                }
                if (mix.isChecked()) {
                    hobby += mix.getText().toString();
                    baby = "1";
                }

                if (u.trim().length() == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter Your Name", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 150);
                    toast.show();

                }
                else if(u.length() < 5)
                {
                    Toast.makeText(getApplicationContext(), "Username can't be less than 5", Toast.LENGTH_SHORT).show();
                }
                else if (p.trim().length()==0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter Your password", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 150);
                    toast.show();
                }
                else if(p.length() < 5)
                {
                    Toast.makeText(getApplicationContext(), "password can't be less than 5", Toast.LENGTH_SHORT).show();
                }
                else if (sel.isEmpty())
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Provide Your Gender", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 150);
                    toast.show();

                }
                else if(baby.isEmpty())
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Choose your food", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 150);
                    toast.show();

                }
                else if(em.trim().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Enter you Email id", Toast.LENGTH_SHORT).show();
                }
                else if(mo.trim().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Enter you Mobile number", Toast.LENGTH_SHORT).show();

                }
                else {
                    if(mo.length()<10)
                    {
                        Toast.makeText(getApplicationContext(), "Mobile number cant  be < 10 digit", Toast.LENGTH_SHORT).show();

                    }else if(mo.length()>10)
                    {
                        Toast.makeText(getApplicationContext(), "Mobile number cant be > 10 digit", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(), "Submitted the record\n" + "User:" + u + "\n" + "Password:" + p + "\n" + "Gener:" + gender + "\n" + "Food:" + hobby + "\n" +"email:"+em+"\nMobile"+mo, Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.TOP, 0, 100);
                        toast.show();
                        gender = " ";

                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        i.putExtra("new_user",u);
                        i.putExtra("new_pass",p);
                        startActivity(i);

                    }

                }
                hobby=" ";
                baby=" ";

            }

        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}