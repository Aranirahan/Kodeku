package com.example.aran.serviceku;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

//TODO (A.3) Buat service (otomatis terdaftar di AndroidManifest)
public class OriginService extends Service {
    //TODO (A.4) Buat public static final String ORIGIN_SERVICE
    public static final String ORIGIN_SERVICE = "OriginService";

    public OriginService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    //TODO (A.5) Override onStartCommand

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO (A.10) Buat Log.d
        Log.d(ORIGIN_SERVICE, "OriginService dijalankan");
        //TODO (A.11) Buat objek ProcessAsync
        ProcessAsync mProcessAsync = new ProcessAsync();
        //TODO (A.12) Eksekusi mProcessAsync
        mProcessAsync.execute();
        //TODO (A.13) return START_STICKY;
        return START_STICKY;
    }

    //TODO (A.6) Buat private class ProcessAsync extends AsycnTask
    private class ProcessAsync extends AsyncTask<Void, Void, Void> {

        //TODO (A.7) Buat sleep di doInBackground
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        //TODO (A.8) Buat Log.d dan Panggil stopSelf di onPostExecute
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(ORIGIN_SERVICE, "StopService");
            stopSelf();
        }
    }

    //TODO (A.9) Buat Log.d di onDestroy
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(ORIGIN_SERVICE, "onDestroy()");
    }
}
