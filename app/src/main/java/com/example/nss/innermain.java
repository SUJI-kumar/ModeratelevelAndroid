package com.example.nss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class innermain extends AppCompatActivity {
    TextView data;
    LinearLayout lc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innermain);
        data=findViewById(R.id.data);
        Intent intent =getIntent();
        final String addition= (String)intent.getSerializableExtra("user");
        final String pass= (String)intent.getSerializableExtra("pass");
        final String admin= (String)intent.getSerializableExtra("Admin_name");
        final String admin_pass= (String)intent.getSerializableExtra("Admin_pass");
        if(addition.equals(admin)&&pass.equals(admin_pass))
        {
            data.setText("LPU NSS\n");
            data.append("Welcome Sujit"+"\n Good to See you");

        }else
        {
            data.setText("Welcome "+addition);
        }

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        lc=findViewById(R.id.lc);

        int id = item.getItemId();
        switch (id){
            case R.id.contact:
                Toast.makeText(getApplicationContext(),"Contact",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), contactus.class);
                startActivity(i);
                return true;

            case R.id.about:
                Toast.makeText(getApplicationContext(),"Aboutus",Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(getApplicationContext(), aboutus.class);
                startActivity(i2);
                return true;
            case R.id.help:
                lc.setBackgroundColor(Color.RED);
                data.setText("COVID19 Helpline Number\t1950\n" +
                        "Police Control Room\t0124-2316100\n" +
                        "SMS to Police Control Room\t0124100\n" +
                        "Cyber Crime Cell\t0124-2211033\n" +
                        "Traffic Helpline Numbers\t9213020404");
                Toast.makeText(getApplicationContext(),"Help",Toast.LENGTH_SHORT).show();
                return true;
            default:

                return super.onOptionsItemSelected(item);

        }
    }
}
