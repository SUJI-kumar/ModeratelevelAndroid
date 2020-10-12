package com.example.nss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class contactus extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] country={"India","America","Russia","Uk","Australia"};
    String[] Subject={" ","Volunteer","new member"};
    TextView mobile;
    EditText number;
    LinearLayout ll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        mobile=findViewById(R.id.mobile);
        number=findViewById(R.id.number);
        ll=findViewById(R.id.Linearll);
        //contextmwnu adding
        registerForContextMenu(mobile);
        //spinner
        Spinner spin1 = (Spinner) findViewById(R.id.subject);
        final ArrayAdapter<String> a = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Subject);
        a.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin1.setAdapter(a);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Subject:" + Subject[i], Toast.LENGTH_LONG).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }
        });
        Spinner spin = (Spinner) findViewById(R.id.country);
        spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        final ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin.setAdapter(aa);


    }
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            getMenuInflater().inflate(R.menu.innermain,menu);
            menu.setHeaderTitle("Select Action");
        }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String mb= number.getText().toString();
        if (item.getItemId() == R.id.call_action) {
            Toast.makeText(this, "Call Selected", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + mb));
            if(mb.trim().length()==10)
            {
                startActivity(intent);

            }else
            {
                Snackbar snack=Snackbar.make(ll,"number shoulb be 10 digit only",Snackbar.LENGTH_SHORT);
                View svView =snack.getView();
                svView.setBackgroundColor(Color.BLUE);
                TextView textview= svView.findViewById(com.google.android.material.R.id.snackbar_text);
                textview.setTextColor(Color.YELLOW);
                textview.setAllCaps(true);
                snack.show();

            }

            return true;
        } else if (item.getItemId() == R.id.SMS_action) {
            Snackbar snack=Snackbar.make(ll,"Sms sent",Snackbar.LENGTH_SHORT);
            View svView =snack.getView();
            svView.setBackgroundColor(Color.BLUE);
            TextView textview= svView.findViewById(com.google.android.material.R.id.snackbar_text);
            textview.setTextColor(Color.YELLOW);
            textview.setAllCaps(true);
            snack.show();
        }else{
            return false;
        }
        return true;
    }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(getApplicationContext(), "Country:" + country[i] , Toast.LENGTH_LONG).show();

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }

}