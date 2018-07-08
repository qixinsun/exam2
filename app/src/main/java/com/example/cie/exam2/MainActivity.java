package com.example.cie.exam2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b;
    private static TextView text;
    private static Handler handler = new Handler();
    private static int size;
    private static String TAG = "xiaoxi";
    public static void UpdateGUI(int refreshDouble){
        size = refreshDouble;
        handler.post(RefreshLable);
        Log.d(TAG, "try1 this is my " + String.valueOf(size));
    }

    private static Runnable RefreshLable = new Runnable(){
        @Override
        public void run() {
            text.setTextSize(size);
            Log.d(TAG, "try1  " + String.valueOf(size));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);
        text = findViewById(R.id.textView);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent, 1);
            }
        });

        final Intent serviceIntent = new Intent(this, MyService.class);
        startService(serviceIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            String number = data.getStringExtra("number");
            if (requestCode == 1) {
                text.setText(number);
            }
        }
    }


}
