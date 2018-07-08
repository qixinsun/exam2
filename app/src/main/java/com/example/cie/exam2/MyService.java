package com.example.cie.exam2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private Thread workThread;
    int size = 10;
    String TAG = "xiaoxi";
    @Override
    public void onCreate() {
        super.onCreate();
        workThread = new Thread(null,backgroudWork,"WorkThread");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (!workThread.isAlive()){
            workThread.start();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        workThread.interrupt();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private Runnable backgroudWork = new Runnable(){
        @Override
        public void run() {
            try {
                while(!Thread.interrupted()){
                    size += 5;
                    if(size>400)
                        size = 10;
                    MainActivity.UpdateGUI(size);
                    Thread.sleep(200);
                    Log.d(TAG, "try");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

}
