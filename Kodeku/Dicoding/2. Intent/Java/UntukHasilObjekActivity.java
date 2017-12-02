package com.example.aran.intentku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UntukHasilObjekActivity extends AppCompatActivity implements View.OnClickListener {
    public static int KODE_HASIL_B = 41;
    public Button btnAmbilObjek;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_untuk_hasil_objek);
        btnAmbilObjek = findViewById(R.id.btn_ambil_objek);
        btnAmbilObjek.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btn_ambil_objek){

            Parcelable ObjekPengirim = new Parcelable();
            ObjekPengirim.setNimMahasiswa(16650068);
            ObjekPengirim.setNamaMahasiswa("Aran Irahan");
            ObjekPengirim.setJurusanMahasiswa("Teknik Informatika");
            ObjekPengirim.setIpkMahasiswa((float) 4.00);

            Intent pindahDenganObjekIntent = new Intent(UntukHasilObjekActivity.this, MainActivity.class);
            pindahDenganObjekIntent.putExtra(MainActivity.OBJEK_EXTRA_B, ObjekPengirim);
            setResult(KODE_HASIL_B, pindahDenganObjekIntent);
            //finish();
        }
    }
}
