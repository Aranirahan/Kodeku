package com.example.aran.intentku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DenganObjekActivity extends AppCompatActivity {
    public static String OBJEK_EXTRA_A = "objek_extra";
    TextView tampilkanObjekDiterima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dengan_objek);
        tampilkanObjekDiterima = findViewById(R.id.tampilkan_objek_diterima);
        Parcelable objekPenerima = getIntent().getParcelableExtra(OBJEK_EXTRA_A);
        String tampilanData = "NIM : " + objekPenerima.getNimMahasiswa() +
                "\nNama : " + objekPenerima.getNamaMahasiswa() +
                "\nJurusan : " + objekPenerima.getJurusanMahasiswa() +
                "\nIPK : " + objekPenerima.getIpkMahasiswa();
        tampilkanObjekDiterima.setText(tampilanData);
    }
}
