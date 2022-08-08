package com.example.deneme2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText e1;
    String message = "";
    Typeface tf1;

    Font f;

    CheckBox kahve;
    CheckBox cay;
    CheckBox soda;
    CheckBox seker;

    String kahve_ = "";
    String cay_ = "";
    String soda_ = "";
    String seker_ = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.editTextTextPersonName);
        tf1= Typeface.createFromAsset(getAssets(),"fonts/Cantata.ttf");
        tanimla();
        sec();

    }

    public void tanimla() {
        cay = (CheckBox) findViewById(R.id.cay);
        cay.setTypeface(tf1);
        soda = (CheckBox) findViewById(R.id.soda);
        soda.setTypeface(tf1);
        kahve = (CheckBox) findViewById(R.id.kahve);
        kahve.setTypeface(tf1);
        seker = (CheckBox) findViewById(R.id.seker);
        seker.setTypeface(tf1);
    }

    public void sec() {
        kahve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kahve.isChecked()) {
                    kahve_ += "kahve ";
                } else {
                    kahve_ = "";
                }
            }
        });
        cay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cay.isChecked()) {
                    cay_ += "cay ";
                } else {
                    cay_ = "";
                }
            }
        });
        soda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soda.isChecked()) {
                    soda_ += "soda ";
                } else {
                    soda_ = "";
                }
            }
        });
        seker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seker.isChecked()) {
                    seker_ += "seker ";
                } else {
                    seker_ = "";
                }
            }
        });
    }

    public void send(View v) {
        System.out.println(seker.isChecked());
        if (e1.getText().toString().equals("")) {
            e1.setError("İsim Girin");
        }else if(!(seker.isChecked()||kahve.isChecked()||soda.isChecked()||cay.isChecked())){
            Toast.makeText(this, "Seçim Yapın", Toast.LENGTH_SHORT).show();
        }
            else{
            MessageSender messageSender = new MessageSender();
            messageSender.execute(e1.getText().toString().toUpperCase() + ": " + cay_ + soda_ + kahve_ + seker_);

            Toast.makeText(this, "Siparişiniz Gönderildi", Toast.LENGTH_SHORT).show();

            cay.setChecked(false);
            soda.setChecked(false);
            kahve.setChecked(false);
            seker.setChecked(false);

            e1.setText("");

            cay_ = "";
            soda_ = "";
            kahve_ = "";
            seker_ = "";
        }


    }

}