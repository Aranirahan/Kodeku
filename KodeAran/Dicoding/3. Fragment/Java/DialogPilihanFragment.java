package com.example.aran.flexibelfragmentku;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;


/**
 * A simple {@link Fragment} subclass.
 */
// TODO (D.1) Buat kelas DialogPilihanFragment
    //TODO (D.10) Jadikan inherit ke class DialogFragment
public class DialogPilihanFragment extends DialogFragment implements View.OnClickListener {
    //TODO (D.3) Buat variabel dr id di xml
    private Button btnPilih, btnTutup;
    private RadioGroup rgPilihan;
    private RadioButton rbSaf, rbMou, rbLvg, rbMoyes;


    //TODO (D.4) Buat interface OnDialogPilihanListener
    public interface OnDialogPilihanListener{
        void OnDialogPilihanListener(String text);
    }

    //TODO (D.5) Buat variabel OnDialogPilihanListener
    private OnDialogPilihanListener onDialogPilihanListener;

    //TODO (D.6) Buat getter setter OnDialogPilihanListener
    public OnDialogPilihanListener getOnDialogPilihanListener() {
        return onDialogPilihanListener;
    }
    public void setOnDialogPilihanListener(OnDialogPilihanListener onDialogPilihanListener) {
        this.onDialogPilihanListener = onDialogPilihanListener;
    }

    public DialogPilihanFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //TODO (D.7) Jadkan XMl ke objek view
        View view = inflater.inflate(R.layout.fragment_dialog_pilihan, container, false);
        //TODO (D.8) Buat cast dan setOnClik
        btnPilih = view.findViewById(R.id.btn_pilih);
        btnTutup = view.findViewById(R.id.btn_tutup);
        btnPilih.setOnClickListener(this);
        btnTutup.setOnClickListener(this);
        rgPilihan = view.findViewById(R.id.rg_pilihan);
        rbMoyes = view.findViewById(R.id.rb_moyes);
        rbMou = view.findViewById(R.id.rb_mou);
        rbLvg = view.findViewById(R.id.rb_lvg);
        rbSaf = view.findViewById(R.id.rb_saf);
        return view;
    }
    //TODO (D.9) Buat Logika saat di klik
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tutup:
                //TODO (D.11) Panggil getDialog().cancel() untuk menutup dialog
                getDialog().cancel();
                break;
            case R.id.btn_pilih:
                //TODO (D.12) Buat logika saat btn pilih di klik
                int centangRadioButtonId = rgPilihan.getCheckedRadioButtonId();
                if (centangRadioButtonId != -1){
                    //TODO (D.13) Buat string coach
                    String coach = null;
                    switch (centangRadioButtonId){
                        //TODO (D.14) Ambil text dari rb
                        case R.id.rb_saf:
                            coach = rbSaf.getText().toString().trim();
                            break;
                        case R.id.rb_mou:
                            coach = rbMou.getText().toString().trim();
                            break;
                        case R.id.rb_lvg:
                            coach = rbLvg.getText().toString().trim();
                            break;
                        case R.id.rb_moyes:
                            coach = rbMoyes.getText().toString().trim();
                            break;
                    }
                    //TODO (D.15) Panggil getOnDialogPilihanListener()
                    //TODO (D.16) Panggil interface OnDialogPilihanListener() dg parameter coach
                    getOnDialogPilihanListener().OnDialogPilihanListener(coach);
                    //TODO (D.17) Panggil getDialog().cancel(); jika sudah selesai
                    getDialog().cancel();
                }
                break;
        }

    }

}
