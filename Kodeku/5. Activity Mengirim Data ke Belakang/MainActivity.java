package com.ngoding.aran.activitymengirimdatakebelakang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public TextView tvKeteranagan;
    public TextView tvData;
    public Button btnPindahKeActivityPengirim;
    public int KODE_VALUE_INTENT_PERMINTAAN = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvKeteranagan = findViewById(R.id.tvKeterangan);
        tvData = findViewById(R.id.tvData);
        btnPindahKeActivityPengirim = findViewById(R.id.btnPindahKeActivityPengirim);
        btnPindahKeActivityPengirim.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intentMemintaData = new Intent(MainActivity.this, PengirimActivity.class);
        startActivityForResult(intentMemintaData, KODE_VALUE_INTENT_PERMINTAAN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == KODE_VALUE_INTENT_PERMINTAAN){
            if(resultCode == PengirimActivity.KODE_VALUE_INTENT_PENGIRIM){
                String data1Diterima = data.getStringExtra(PengirimActivity.EXTRA_DATA_1_PENGIRIM);
                int data2Diterima = data.getIntExtra(PengirimActivity.EXTRA_DATA_2_PENGIRIM,0);
                tvKeteranagan.setText("(Sudah Menerima Data)");
                tvData.setText("Data 1  = "+data1Diterima+ "\nData 2 = "+data2Diterima);
            }
        }
    }
}

