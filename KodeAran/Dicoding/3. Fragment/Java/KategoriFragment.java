package com.example.aran.flexibelfragmentku;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
// TODO (B.1) Buat fragment dg nama KategoriFragment
public class KategoriFragment extends Fragment implements View.OnClickListener {
    // TODO (B.3) Buat private btn
    private Button btnDetailKategori;

    public KategoriFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // TODO (B.4) Buat objek view dari layout fragment_kategori
        View objekView = inflater.inflate(R.layout.fragment_kategori, container, false);
        // TODO (B.5) Buat cast btn yg sudah berada di objek view
        btnDetailKategori = objekView.findViewById(R.id.btn_detail_kategori);
        // TODO (B.6) Set btnDetailKategori saat di klik
        btnDetailKategori.setOnClickListener(this);
        return objekView;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_detail_kategori){
            // TODO (C.12) Buat objek class DetailKategoriFragment
            DetailKategoriFragment mDetailKategoriFragment = new DetailKategoriFragment();
            // TODO (C.13) Buat objek Bundle
            Bundle mBundle = new Bundle();
            // TODO (C.14) Kirim bundle ke
            mBundle.putString(DetailKategoriFragment.EXTRA_NAMA, "Gaya HIdup");
            mDetailKategoriFragment.setArguments(mBundle);
            // TODO (C.15) setDeskripsi
            String deskripsi = "Kategori ini berisi produk - produk gaya hidup";
            mDetailKategoriFragment.setDeskripsi(deskripsi);
            // TODO (C.16) Panggil getFragmentManager()
            // -untuk mengorganisir obyek fragment yang terdapat didalam Activity
            FragmentManager mFragmentManager = getFragmentManager();
            // TODO (C.17) Panggil beginTransaction()
            // -gar bisa melakukan operasi pada fragment, seperti add(), replace(), commit() dsb
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            // TODO (C.18) Panggil replace()
            // -untuk mengganti obyek fragment yang sedang tampil saat ini UtamaFragment() dengan obyek fragment yang baru (KategoriFragment)
            mFragmentTransaction.replace(R.id.frame_wadah, mDetailKategoriFragment, DetailKategoriFragment.class.getSimpleName());
            // TODO (C.19) Panggil addToBackStack(null)
            // -untuk menampilkasn objek fragment sebelumnya (UtamaFragment) ketika hardbutton back di tekan
            mFragmentTransaction.addToBackStack(null);
            // TODO (C.20) Panggil commit()
            // -untuk melakukan pemasangan obyek secara asynchronous yg ditampilkan di UI
            mFragmentTransaction.commit();


        }
    }
}
