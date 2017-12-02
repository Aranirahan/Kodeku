package com.ngoding.aran.activtymengirimobjek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btnPindahActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPindahActivity = findViewById(R.id.btnPindahActivity);
        btnPindahActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Parcelable mParcelable = new Parcelable();
        mParcelable.setData1("Khamdan Nahari");
        mParcelable.setData2("Indramayu");
        mParcelable.setData3(3);
        mParcelable.setData4(4);
        Intent intentDenganObjek = new Intent(MainActivity.this, PenerimaActivity.class);
        intentDenganObjek.putExtra(PenerimaActivity.EXTRA_PENERIMA, mParcelable);
        startActivity(intentDenganObjek);
    }
}
