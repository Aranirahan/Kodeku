package com.ngoding.aran.activitymengirimdatakebelakang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PengirimActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btnKembaliDgData;
    public static String EXTRA_DATA_1_PENGIRIM = "extra_data_1";
    public static String EXTRA_DATA_2_PENGIRIM = "extra_data_2";
    public static int KODE_VALUE_INTENT_PENGIRIM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengirim);
        btnKembaliDgData = findViewById(R.id.btnKembaliDgData);
        btnKembaliDgData.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String data1 = "Khamdan";
        int data2 = 2;

        Intent intentDenganData = new Intent();
        intentDenganData.putExtra(EXTRA_DATA_1_PENGIRIM, data1);
        intentDenganData.putExtra(EXTRA_DATA_2_PENGIRIM, data2);
        setResult(KODE_VALUE_INTENT_PENGIRIM, intentDenganData);
        finish();
    }
}
