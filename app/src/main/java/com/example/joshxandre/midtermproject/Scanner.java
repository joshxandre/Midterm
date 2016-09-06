package com.example.joshxandre.midtermproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Scanner extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    private ZXingScannerView vScannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        vScannerView = new ZXingScannerView(this);
        setContentView(vScannerView);
        vScannerView.setResultHandler(this);
        vScannerView.startCamera();

    }

    @Override
    public void handleResult(Result result) {

        String data = result.getText();
        Intent intent = new Intent();

        intent.putExtra("myData",data);
        setResult(RESULT_OK, intent);
        AlertDialog.Builder diagBuilder = new AlertDialog.Builder(this);
        diagBuilder.setTitle("Success! Scan Result");

        int count = 0;
        ArrayList<String> Slist = new ArrayList<String>();
        StringTokenizer mTokenizer = new StringTokenizer(data,"|||");
        while(mTokenizer.hasMoreTokens()){
            Slist.add(mTokenizer.nextToken());
        }
        String message = "Item Name: "+Slist.get(0)+"     "+"Price: "+Slist.get(2);

        diagBuilder.setMessage(message);

        AlertDialog mAlert = diagBuilder.create();
        mAlert.show();
        Thread myThread = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(2000);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        vThread.start();




    }

    @Override
    protected void onPause() {
        super.onPause();
        vScannerView.stopCamera();
    }