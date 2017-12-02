package com.ngoding.aran.activitymembawadata;


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
        Intent intentDenganData = new Intent(MainActivity.this, PenerimaActivity.class);
        intentDenganData.putExtra(PenerimaActivity.EXTRA_DATA1, "Khamdan Nahari");
        intentDenganData.putExtra(PenerimaActivity.EXTRA_DATA2, 2);
        startActivity(intentDenganData);
    }
}

