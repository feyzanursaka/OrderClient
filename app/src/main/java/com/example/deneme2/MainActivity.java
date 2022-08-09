package com.example.deneme2;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1; //isim girmek için edittext tanımlama
    Typeface tf1; //yazı tipi uygulamak için typeface tanımlama

    CheckBox kahve;
    CheckBox cay;
    CheckBox soda;
    CheckBox seker;

    //checkboxta seçilen ürünleri stringlere eklemek için tanımlama
    String kahve_ = "";
    String cay_ = "";
    String soda_ = "";
    String seker_ = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.editTextTextPersonName); //girilen isim edittextini id den bulup e1'e atama
        tf1 = Typeface.createFromAsset(getAssets(), "fonts/Cantata.ttf"); //yazıtipi atama
        tanimla(); //her checkcox için ürün isimleri ile tanımlama
        sec(); //checkbox seçim yapma ve bırakma
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
                    kahve_ += "kahve ";//kahve seçildiyse stringe kahve yazısı ekle
                } else {
                    kahve_ = "";//seçim kalktıysa stringten sil
                }
            }
        });
        cay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cay.isChecked()) {
                    cay_ += "cay ";//çay seçildiyse stringe çay yazısı ekle
                } else {
                    cay_ = "";//seçim kalktıysa stringten sil
                }
            }
        });
        soda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soda.isChecked()) {
                    soda_ += "soda ";//soda seçildiyse stringe soda yazısı ekle
                } else {
                    soda_ = "";//seçim kalktıysa stringten sil
                }
            }
        });
        seker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seker.isChecked()) {
                    seker_ += "seker ";//seker seçildiyse stringe seker yazısı ekle
                } else {
                    seker_ = "";//seçim kalktıysa stringten sil
                }
            }
        });
    }

    public void send(View v) {
        if (e1.getText().toString().equals("")) {//isim kısmı boşsa uyarı ver
            e1.setError("İsim Girin");
        } else if (!(seker.isChecked() || kahve.isChecked() || soda.isChecked() || cay.isChecked())) {//ürünlerden herhangi biri seçili değilse uyarı ver
            Toast.makeText(this, "Seçim Yapın", Toast.LENGTH_SHORT).show();
        } else {//isim ve seçimler girildiyse sipariş ver işlemini gerçekleştir
            MessageSender messageSender = new MessageSender();
            messageSender.execute(e1.getText().toString().toUpperCase() + ": " + cay_ + soda_ + kahve_ + seker_);//MessageSendera girilen ismi ve seçimleri gönder

            Toast.makeText(this, "Siparişiniz Gönderildi", Toast.LENGTH_SHORT).show();//siparişiniz gönderildi bildirimi ver

            //seçimleri temizle
            cay.setChecked(false);
            soda.setChecked(false);
            kahve.setChecked(false);
            seker.setChecked(false);

            //isim girilen kısmı temizle
            e1.setText("");

            //string ürünleri temizle
            cay_ = "";
            soda_ = "";
            kahve_ = "";
            seker_ = "";
        }
    }
}