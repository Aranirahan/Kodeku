package com.example.aran.serviceku;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //TODO (A.2) Deklarasikan, castingkan, dan set on click 2btn td
    private Button btnMulaiService;
    private Button btnMulaiIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMulaiService = findViewById(R.id.btn_mulai_service);
        btnMulaiIntentService = findViewById(R.id.btn_mulai_intent_service);
        btnMulaiService.setOnClickListener(this);
        btnMulaiIntentService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_mulai_service:
                //TODO (A.6) Buat intent yg menuju class OriginService
                Intent mMulaiServiceIntent = new Intent(MainActivity.this, OriginService.class);
                //TODO (A.7) Jalankan service
                startService(mMulaiServiceIntent);
                break;
            case R.id.btn_mulai_intent_service:
                Intent mMulaiIntentService = new Intent(MainActivity.this, DicodingIntentService.class);
                mMulaiIntentService.putExtra(DicodingIntentService.EXTRA_DURATION, 5000);
                startService(mMulaiIntentService);
                break;
        }
    }
}
