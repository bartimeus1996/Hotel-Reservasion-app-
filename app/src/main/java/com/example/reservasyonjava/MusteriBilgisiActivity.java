package com.example.reservasyonjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MusteriBilgisiActivity extends AppCompatActivity {

    TextView adi, eposta, teleNum, pasaportNum, checkin,checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteri_bilgisi);
        adi=findViewById(R.id.tvAd);
        eposta=findViewById(R.id.tvEmail);
        teleNum=findViewById(R.id.tvteleNum);
        pasaportNum=findViewById(R.id.tvPasNum);
        checkin=findViewById(R.id.tvcheckin);
        checkout=findViewById(R.id.tvchekout);

        Intent intent = getIntent();

        String Adi = intent.getStringExtra("adi");
        String Eposta = intent.getStringExtra("eposta");
        String TelefonNum = intent.getStringExtra("telefonNum");
        String PasaportNum = intent.getStringExtra("pasaportNum");
        String CheckInTarihi = intent.getStringExtra("checkIn");
        String CheckOutTarihi =intent.getStringExtra("checkOut");

        adi.setText("adi :" + Adi);
        eposta.setText( "Eposta : " +Eposta);
        teleNum.setText( "Telefon : "+ TelefonNum);
        pasaportNum.setText( "Pasaport Num : "+ PasaportNum);
        checkin.setText("CheckIn Tarihi :"+ CheckInTarihi);
        checkout.setText("CheckOut Tarihi: "+ CheckOutTarihi);


    }

}