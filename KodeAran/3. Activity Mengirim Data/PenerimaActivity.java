package com.ngoding.aran.activitymembawadata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PenerimaActivity extends AppCompatActivity {
    public static String EXTRA_DATA1 = "extra_data_1";
    public static String EXTRA_DATA2 = "extra_data_2";
    public TextView tvTampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penerima);
        tvTampil = findViewById(R.id.tvData);
        String data1 = getIntent().getStringExtra(EXTRA_DATA1);
        int data2 = getIntent().getIntExtra(EXTRA_DATA2, 0);
        tvTampil.setText("Data 1 (String)= "+data1+"\nData 2 (int)= "+data2);
    }
}
