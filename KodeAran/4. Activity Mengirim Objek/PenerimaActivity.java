package com.ngoding.aran.activtymengirimobjek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PenerimaActivity extends AppCompatActivity {
    public static String EXTRA_PENERIMA = "extra_penerima";
    public TextView tvTampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penerima);
        tvTampil = findViewById(R.id.tvData);
        Parcelable mParcelable = getIntent().getParcelableExtra(EXTRA_PENERIMA);

        tvTampil.setText("Data 1 (String) = "+mParcelable.getData1()+
                "\nData 2 (String) = " +mParcelable.getData2()+
                "\nData 3 (int) = "+mParcelable.getData3()+
                "\nData 4 (int) = "+mParcelable.getData4());
    }
}
