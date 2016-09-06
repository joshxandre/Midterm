package com.example.joshxandre.midtermproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Button btnScanner;
    private Button btnSms;
    private Button btnEmail;
    private TextView tp;
    private String message;
    private double tprice = 0.0f;
    private ArrayList<ShoppingC> List = new ArrayList<ShoppingC>();
    ShoppingC shoppingAdd = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (List.isEmpty()) {
            Toast.makeText(this, "Cart is Empty!", Toast.LENGTH_LONG).show();
        }
        listView = (ListView) findViewById(R.id.listView);
        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!List.isEmpty()){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/html");

                    intent.putExtra(Intent.EXTRA_TEXT, message);

                    startActivity(Intent.createChooser(intent, "Send Email"));


                }

            }
        });
        tp= (TextView) findViewById(R.id.tp);
        btnSms= (Button) findViewById(R.id.btnSMS);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!List.isEmpty()){
                    Intent sIntent = new Intent(android.content.Intent.ACTION_VIEW);
                    sIntent.setType("vnd.android-dir/mms-sms");
                    sIntent.putExtra("address", "");
                    sIntent.putExtra("sms_body", message);
                    startActivity(sIntent);}
            }
        });
    }


    }

