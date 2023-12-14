package com.example.reservasyonjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class ReservasyonActivity extends AppCompatActivity {
    final Calendar myCalendar = Calendar.getInstance();
    private EditText adi, email, telefonNum, PasaportNum, checkinTarihi, checkoutTarihi;

    private final Calendar checkInCalendar = Calendar.getInstance();
    private final Calendar checkOutCalendar = Calendar.getInstance();
    private Button KaydetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservasyon);
        adi=findViewById(R.id.edAdi);
        email=findViewById(R.id.edEmail);
        telefonNum=findViewById(R.id.edNumara);
        PasaportNum=findViewById(R.id.edPasaport);
        checkinTarihi=findViewById(R.id.edcheckin);
        checkoutTarihi=findViewById(R.id.edCheckout);
        KaydetBtn=findViewById(R.id.btnKaydet);

        KaydetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReservasyonActivity.this, MusteriBilgisiActivity.class);
                intent.putExtra("adi", adi.getText().toString());
                intent.putExtra("eposta", email.getText().toString());
                intent.putExtra("telefonNum", telefonNum.getText().toString());
                intent.putExtra("pasaportNum", PasaportNum.getText().toString());
                intent.putExtra("checkIn", checkinTarihi.getText().toString());
                intent.putExtra("checkOut", checkoutTarihi.getText().toString());
                startActivity(intent);
            }
        });
        checkinTarihi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(

                        ReservasyonActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                checkinTarihi.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });
        checkoutTarihi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        ReservasyonActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                checkoutTarihi.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });
    }

}