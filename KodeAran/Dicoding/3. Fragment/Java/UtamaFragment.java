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
// TODO (A.2) Buat fragment utama
public class UtamaFragment extends Fragment implements View.OnClickListener {


    public UtamaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // TODO (A.4) Ubah layout berupa file xml kedalam obyek View
        View objekView = inflater.inflate(R.layout.fragment_utama, container, false);
        // TODO (A.5) Buat cast btn yg sudah berada di objek view
        Button btnKategori = objekView.findViewById(R.id.btn_kategori);
        // TODO(A.11) Set btnKategori saat dikilik
        btnKategori.setOnClickListener(this);
        return objekView;
    }

    //TODO (A.12) Buat logika saat onClick
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_kategori) {
            // TODO (B.7) Buat objek dr class KategoriFragment
            KategoriFragment mKategoriFragment = new KategoriFragment();
            // TODO (B.8) Panggil getFragmentManager()
            // -untuk mengorganisir obyek fragment yang terdapat didalam Activity
            FragmentManager mFragmentManager = getFragmentManager();
            // TODO (B.9) Panggil beginTransaction()
            // -gar bisa melakukan operasi pada fragment, seperti add(), replace(), commit() dsb
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            // TODO (B.10) Panggil replace()
            // -untuk mengganti obyek fragment yang sedang tampil saat ini UtamaFragment() dengan obyek fragment yang baru (KategoriFragment)
            mFragmentTransaction.replace(R.id.frame_wadah, mKategoriFragment, KategoriFragment.class.getSimpleName());
            // TODO (B.11) Panggil addToBackStack(null)
            // -untuk menampilkasn objek fragment sebelumnya (UtamaFragment) ketika hardbutton back di tekan
            mFragmentTransaction.addToBackStack(null);
            // TODO (B.12) Panggil commit()
            // -untuk melakukan pemasangan obyek secara asynchronous yg ditampilkan di UI
            mFragmentTransaction.commit();
        }

    }
}
