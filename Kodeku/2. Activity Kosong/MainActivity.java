package com.ngoding.aran.activitykosong;

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
        Intent intentTanpaData = new Intent(MainActivity.this, PenerimaActivity.class);
        startActivity(intentTanpaData);
    }
}
