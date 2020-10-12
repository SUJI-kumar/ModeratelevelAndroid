package com.example.nss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button Login,Signup;
    RelativeLayout Rellayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username= findViewById(R.id.user);
        password= findViewById(R.id.pass);
        Login=findViewById(R.id.Login);
        Signup=findViewById(R.id.SignUp);
        Rellayout=findViewById(R.id.Rellayout);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String Admin_name="Sujit";
                String Admin_password="abc@123";

                if(user.trim().isEmpty())
                {

                    Snackbar snack=Snackbar.make(Rellayout,"Please Enter username",Snackbar.LENGTH_SHORT);
                    View svView =snack.getView();
                    svView.setBackgroundColor(Color.BLUE);
                    TextView textview= svView.findViewById(com.google.android.material.R.id.snackbar_text);
                    textview.setTextColor(Color.YELLOW);
                    textview.setAllCaps(true);
                    snack.show();

                }
                else if(user.length() < 5)
                {
                    Toast.makeText(getApplicationContext(),"Username is too short min length required is 5 ",Toast.LENGTH_SHORT).show();

                }
                else if(pass.trim().isEmpty())
                {
                    Snackbar snack=Snackbar.make(Rellayout,"Please Enter Passowrd",Snackbar.LENGTH_SHORT);
                    View svView =snack.getView();
                    svView.setBackgroundColor(Color.BLUE);
                    TextView textview= svView.findViewById(com.google.android.material.R.id.snackbar_text);
                    textview.setTextColor(Color.YELLOW);
                    textview.setAllCaps(true);
                    snack.show();


                }
                else if(pass.length()<5)
                {
                    Toast.makeText(getApplicationContext(),"Password can't less then 5",Toast.LENGTH_SHORT).show();

                }
                else if(user.equals(Admin_name)&&pass.equals(Admin_password))
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Welcome Mr "+user,Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                    Intent i= new Intent(getApplicationContext(),innermain.class);
                    i.putExtra("user", user);
                    i.putExtra("pass",pass);
                    i.putExtra("Admin_name",Admin_name);
                    i.putExtra("Admin_pass",Admin_password);
                    startActivity(i);

                }
                else
                {

                    Toast.makeText(getApplicationContext(),"Invalid Credential",Toast.LENGTH_SHORT).show();
                }

                Intent intent =getIntent();
                final String create_user= (String)intent.getSerializableExtra("new_user");
                final String create_pass= (String)intent.getSerializableExtra("new_pass");
                if(user.equals(create_user)&&pass.equals(create_pass))
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Welcome Mr "+create_user,Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                    Intent i= new Intent(getApplicationContext(),innermain.class);
                    i.putExtra("user", create_user);
                    i.putExtra("pass",create_pass);
                    startActivity(i);

                }
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2= new Intent(getApplicationContext(),signup.class);
                startActivity(i2);

            }
        });
    }
}