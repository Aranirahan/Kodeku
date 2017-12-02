package com.example.aran.flexibelfragmentku;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
//TODO (C.1) Buat DetailKategoriFragment
public class DetailKategoriFragment extends Fragment implements View.OnClickListener {
    // TODO (C.3) Buat 4 private variabel (2tv dan 2btn)
    private TextView tvNamaKategori;
    private TextView tvDeskripsiKategori;
    private Button btnProfil;
    private Button btnTampilkanDialog;
    // TODO (C.4) Buat public static String EXTRA_NAMA
    public static String EXTRA_NAMA = "extra_nama";
    // TODO (C.5) Buat private String deskripsi
    private String deskripsi;

    public DetailKategoriFragment() {
        // Required empty public constructor
    }

    // TODO (C.6) Buat getter setter deskripsi
    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO (C.6) Inflate layout fragment ini
        View objekView = inflater.inflate(R.layout.fragment_detail_kategori, container, false);
        // TODO(C.7) Buat cast semua variabel
        tvNamaKategori = objekView.findViewById(R.id.tv_nama_kategori);
        tvDeskripsiKategori = objekView.findViewById(R.id.tv_deskripsi_kategori);
        btnProfil = objekView.findViewById(R.id.btn_profil);
        btnProfil.setOnClickListener(this);
        btnTampilkanDialog = objekView.findViewById(R.id.btn_tampilkan_dialog);
        btnTampilkanDialog.setOnClickListener(this);
        return objekView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO (C.8) getArguments().getString(EXTRA_NAMA) di onActivityCreated
        // -untuk menerima data objek bundle
        String namaKategori = getArguments().getString(EXTRA_NAMA);
        // TODO (C.9) Masukan namaKategori ke tvNamaKategori
        tvNamaKategori.setText(namaKategori);
        // TODO (C.10) Masukan getDeskripsi ke tvDeskripsiKategori
        tvDeskripsiKategori.setText(getDeskripsi());
    }

    // TODO (C.11) Buat logika saat klik btn
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_profil:
                break;
            case R.id.btn_tampilkan_dialog:
                // TODO (D.18) Buat objek class DialogPilihanFragment
                DialogPilihanFragment mDialogPilihanFragment = new DialogPilihanFragment();
                //TODO (D.19) setOnDialogPilihanListener untuk memunculkan toast
                mDialogPilihanFragment.setOnDialogPilihanListener(new DialogPilihanFragment.OnDialogPilihanListener() {
                    @Override
                    public void OnDialogPilihanListener(String text) {
                        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
                    }
                });
                // TODO (D.20) Panggil getChildFragmentManager()
                // -untuk mengorganisir obyek fragment yang terdapat didalam Activity
                FragmentManager mFragmentManager = getChildFragmentManager();
                // TODO (D.21) Panggil show()
                // -untuk menampilkan obyek dialog fragment yang (DialogPilihanFragment) pada obyek fragment yang sedang tampil saat ini (DetailKategoriFragment)
                mDialogPilihanFragment.show(mFragmentManager, DialogPilihanFragment.class.getSimpleName());
                break;
        }
        //TODO (E.4) Pindah dr DetailKategoriFragment ke ProfilActivity dg menggunakan intent
        Intent mIntent = new Intent(getActivity(), ProfilActivity.class);
        startActivity(mIntent);

    }
}
