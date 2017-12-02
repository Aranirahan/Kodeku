package com.example.aran.intentku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DenganDataActivity extends AppCompatActivity {
    static String NAMA_EXTRA = "nama_extra";
    static String UMUR_EXTRA = "umur_extra";
    TextView tampilkanDataDiterima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dengan_data);
        tampilkanDataDiterima = findViewById(R.id.tampilkan_data_diterima);

        String nama = getIntent().getStringExtra(NAMA_EXTRA);
        int umur = getIntent().getIntExtra(UMUR_EXTRA, 0);
        String tampilanData = "Nama : "+nama+"\nUmur : "+umur;
        tampilkanDataDiterima.setText(tampilanData);

    }
}
