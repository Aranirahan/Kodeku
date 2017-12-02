package com.ngoding.aran.activitymemanggilfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnPanggil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPanggil = findViewById(R.id.btn_panggil_fragment);
        btnPanggil.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        FragmentManager mFragmentManager =getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        UtamaFragment mUtamaFragment = new UtamaFragment();
        mFragmentTransaction.add(R.id.frame_wadah, mUtamaFragment, UtamaFragment.class.getSimpleName());

        mFragmentTransaction.commit();
    }
}
