package com.example.aran.intentku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

//TODO (E.1) Buat activity dg nama UntukHasilActivity
public class UntukHasilActivity extends AppCompatActivity implements View.OnClickListener {
    //TODO(E.3) Buat variabel button dan radio group
    private Button tombolPilih;
    private RadioGroup rgNomer;
    //TODO (E.6) Buat string variabel untuk id nilai
    public static String EXTRA_NILAI_YANG_DIPILIH = "extra_nilai_yg_dipilih";
    // TODO (E.7) Buat int variabel untuk kode result
    public static int KODE_HASIL_A = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_untuk_hasil);
        //TODO (E.4) Buat cast button dan radio group
        tombolPilih = findViewById(R.id.tombol_pilih);
        rgNomer = findViewById(R.id.rg_nomer);
        //TODO (E.5) Set tombol saat diklik
        tombolPilih.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tombol_pilih){
            if(rgNomer.getCheckedRadioButtonId() != 0){
                int nilai = 0;
                switch (rgNomer.getCheckedRadioButtonId()){
                    case R.id.rb_300:
                        nilai = 300;
                        break;
                    case R.id.rb_200:
                        nilai = 200;
                        break;
                    case R.id.rb_100:
                        nilai = 100;
                        break;
                }
                // TODO (E.8) Buat objek activity (membawa data)
                Intent hasilIntent = new Intent();
                hasilIntent.putExtra(EXTRA_NILAI_YANG_DIPILIH, nilai);
                // TODO (E.9) Kirimkan data ke ac tivity sebelumnya
                setResult(KODE_HASIL_A, hasilIntent);
                // TODO (E.10) Hancurkan activity saat ini
                finish();
            }

        }
    }
}
