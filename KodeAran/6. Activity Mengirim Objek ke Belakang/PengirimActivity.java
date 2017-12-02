package com.ngoding.aran.activitymengirimobjekkebelakang;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class PengirimActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btnKembaliDgData;
    public static int KODE_VALUE_INTENT_PENGIRIM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengirim);
        btnKembaliDgData = findViewById(R.id.btnKembaliDgData);
        btnKembaliDgData.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        Parcelable mParcelable = new Parcelable();
        mParcelable.setData1("Khamdan Nahari");
        mParcelable.setData2("Indramayu");
        mParcelable.setData3(3);
        mParcelable.setData4(4);

        Intent intentDenganObjek = new Intent(PengirimActivity.this, MainActivity.class);
        intentDenganObjek.putExtra(MainActivity.EXTRA_OBJEK_PERMINTAAN, mParcelable);
        setResult(KODE_VALUE_INTENT_PENGIRIM, intentDenganObjek);
        finish();
    }
}

