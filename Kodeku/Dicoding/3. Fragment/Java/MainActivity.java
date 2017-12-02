package com.example.aran.flexibelfragmentku;


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
        // TODO (A.6) Panggil getSupportFragmentManager()
        // -untuk mengorganisir obyek fragment yang terdapat didalam Activity (support Library v4/bisa kompatibel ke versi Android sebelumnya)
        FragmentManager mFragmentManager =getSupportFragmentManager();
        // TODO (A.7) Panggil beginTransaction()
        // -agar bisa melakukan operasi pada fragment, seperti add(), replace(), commit() dsb
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        // TODO (A.8) Buat objek dr class UtamaFragment
        UtamaFragment mUtamaFragment = new UtamaFragment();
        // TODO (A.9) Panggil add()
        // -untuk menambahkan objek mUtamaFragment ke mFragmentTransaction
        mFragmentTransaction.add(R.id.frame_wadah, mUtamaFragment, UtamaFragment.class.getSimpleName());
        //(container berada pd frame_wadah, yg dijadikan transaksi = objek fragment, tag nya = nama class itu sendiri)
        Log.d("FlexibleFragmentKu", "Nama Fragment :"+UtamaFragment.class.getSimpleName());
        // TODO (A.10) Panggil commit()
        // -untuk melakukan pemasangan obyek secara asynchronous yg ditampilkan di UI
        mFragmentTransaction.commit();

    }
}
