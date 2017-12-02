package com.example.aran.intentku;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPindahTanpaDataActivity;
    Button btnPindahDenganDataAtivity;
    Button btnPindahDenganObjekAtivity;
    Button btnPindahKeAplikasiLainActivity;
    //TODO (E.11) Buat variabel btn dg nama btnPindahKeActivityResult
    Button btnPindahKeActivityResult;
    // TODO (E.14) Buat variabel tv dg nama tvHasil;
    TextView tvHasil;
    // TODO (E.16) Buat variabel int dg nama KODE_PERMINTAAN;
    public int KODE_PERMINTAAN_A = 12;
    Button btnPindahKeActivityObjekResult;
    public int KODE_PERMINTAAN_B = 22;

    public static String OBJEK_EXTRA_B = "objek_extra_b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPindahTanpaDataActivity = findViewById(R.id.btn_pindah_tanpa_data_acitvity);
        btnPindahTanpaDataActivity.setOnClickListener(this);
        btnPindahDenganDataAtivity = findViewById(R.id.btn_pindah_dengan_data_acitvity);
        btnPindahDenganDataAtivity.setOnClickListener(this);
        btnPindahDenganObjekAtivity = findViewById(R.id.btn_pindah_dengan_objek_acitvity);
        btnPindahDenganObjekAtivity.setOnClickListener(this);
        btnPindahKeAplikasiLainActivity = findViewById(R.id.btn_pindah_ke_aplikasi_lain_acitvity);
        btnPindahKeAplikasiLainActivity.setOnClickListener(this);
        // TODO (E.12) Buat cast btnPindahKeActivityResult
        btnPindahKeActivityResult = findViewById(R.id.btn_pindah_ke_result_activity);
        // TODO (E.13) Set tombol saat di klik
        btnPindahKeActivityResult.setOnClickListener(this);
        //TODO (E.15) Buat cast tvHasil;
        tvHasil = findViewById(R.id.tv_hasil);
        btnPindahKeActivityObjekResult = findViewById(R.id.btn_pindah_ke_objek_result_activity);
        btnPindahKeActivityObjekResult.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pindah_tanpa_data_acitvity:
                Intent pindahTanpaDataIntent = new Intent(MainActivity.this, TanpaDataActivity.class);
                startActivity(pindahTanpaDataIntent);
                break;
            case R.id.btn_pindah_dengan_data_acitvity:
                Intent pindahDenganDataIntent = new Intent(MainActivity.this, DenganDataActivity.class);
                pindahDenganDataIntent.putExtra(DenganDataActivity.NAMA_EXTRA, "Khamdan Nahari");
                pindahDenganDataIntent.putExtra(DenganDataActivity.UMUR_EXTRA, 20);
                startActivity(pindahDenganDataIntent);
                break;
            case R.id.btn_pindah_dengan_objek_acitvity:
                Parcelable ObjekPengirim = new Parcelable();
                ObjekPengirim.setNimMahasiswa(16650068);
                ObjekPengirim.setNamaMahasiswa("Khamdan Nahari");
                ObjekPengirim.setJurusanMahasiswa("Teknik Informatika");
                ObjekPengirim.setIpkMahasiswa((float) 4.00);

                Intent pindahDenganObjekIntent = new Intent(MainActivity.this, DenganObjekActivity.class);
                pindahDenganObjekIntent.putExtra(DenganObjekActivity.OBJEK_EXTRA_A, ObjekPengirim);
                startActivity(pindahDenganObjekIntent);
                break;
            case R.id.btn_pindah_ke_aplikasi_lain_acitvity:
                String nomorTelepon = "082137924654";
                Intent pindahKeAplikasiLainIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+nomorTelepon));
                startActivity(pindahKeAplikasiLainIntent);
                break;
            case R.id.btn_pindah_ke_result_activity:
                // TODO (E.17) Buat intent ke activity UntukHasilActivity (tanpa data)
                Intent pindahKeActivityResultIntent = new Intent(MainActivity.this, UntukHasilActivity.class);
                // TODO (E.18) Jalankan intent (dg membawa kode permintaan)
                startActivityForResult(pindahKeActivityResultIntent, KODE_PERMINTAAN_A);
                break;
            case R.id.btn_pindah_ke_objek_result_activity:
                Intent pindahKeObjekResultIntent = new Intent(MainActivity.this, UntukHasilObjekActivity.class);
                startActivityForResult(pindahKeObjekResultIntent, KODE_PERMINTAAN_B);
                break;

        }
    }
    // TODO (E.19) Buat logika ketika aplikasi menerima data Result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == KODE_PERMINTAAN_A){
            // jika requestCode berupa kode permintaan A
            if(resultCode == UntukHasilActivity.KODE_HASIL_A){
                // jika resultCode berupa kode hasil A
                // TODO (E.20) Isi intent data
                int hasilTerpilih = data.getIntExtra(UntukHasilActivity.EXTRA_NILAI_YANG_DIPILIH, 0);
                // TODO (E.21) Tampilkan hasilTerpilih
                tvHasil.setText(String.format("Hasil : %s", hasilTerpilih));
            }
        }
        if(requestCode == KODE_PERMINTAAN_B){
            if(resultCode == UntukHasilObjekActivity.KODE_HASIL_B){

                Parcelable objekPenerima2 = data.getParcelableExtra(OBJEK_EXTRA_B);
                String tampilanData = "NIM : " + objekPenerima2.getNimMahasiswa() +
                        "\nNama : " + objekPenerima2.getNamaMahasiswa() +
                        "\nJurusan : " + objekPenerima2.getJurusanMahasiswa() +
                        "\nIPK : " + objekPenerima2.getIpkMahasiswa();
                tvHasil.setText(tampilanData);
            }
        }
    }
}
