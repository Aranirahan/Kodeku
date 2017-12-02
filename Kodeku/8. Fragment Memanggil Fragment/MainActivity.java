package com.ngoding.aran.fragmentmemanggilfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager mFragmentManager =getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        UtamaFragment mUtamaFragment = new UtamaFragment();
        mFragmentTransaction.add(R.id.frame_wadah, mUtamaFragment, UtamaFragment.class.getSimpleName());
        Log.d("FlexibleFragmentKu", "Nama Fragment :"+UtamaFragment.class.getSimpleName());
        mFragmentTransaction.commit();
    }
}
