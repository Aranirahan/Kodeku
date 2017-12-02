package com.example.aran.asynctaskku;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //TODO (A.2) Buat static final String DEMO_ASYNC
    public static final String DEMO_ASYNC = "DemoAsync";
    //TODO (A.3) Buat variabel tv
    private TextView tvStatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO (A.4) Buat cast
        setContentView(R.layout.activity_main);
        tvStatus = findViewById(R.id.tv_status);
        //TODO (A.15) Buat objek DemoAsync
        DemoAsync demoAsync = new DemoAsync();
        //TODO (A.16) Jalankan demoAsync
        demoAsync.execute("Halo Ini Demo AsyncTask");

    }
    //TODO (A.5) Buat private class DemoAsync extends AsyncTask
    private class DemoAsync extends AsyncTask<String, Void, String>{
        //TODO (A.6) Override onPreExecute
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //TODO (A.7) Set Text tvStatus
            tvStatus.setText("status : onPreExecute");
        }
        //TODO (A.8) Override doInBackground
        @Override
        //TODO (A.9) Ubah variabel string mjd params
        protected String doInBackground(String... params) {
            Log.d(DEMO_ASYNC, "status : doInBackground");
            //TODO (A.10) Buat try catch
            try{
                //TODO (A.11) Lakukan proses sleep/idle selama 5 detik (5000 miliseconds)
                Thread.sleep(5000);
            } catch (Exception e) {
                Log.d(DEMO_ASYNC, e.getMessage());
            }
            //TODO (A.12) Return nilai param[0]
            return params[0];
        }
        //TODO (A.13) Override onPostExecute
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //TODO (A.14) Set text tvStatus + hasil dr doInBackground
            tvStatus.setText("status : onPostExecute : "+s);
        }
    }
}
