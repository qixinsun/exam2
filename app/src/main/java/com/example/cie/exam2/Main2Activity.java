package com.example.cie.exam2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {


    Button bu;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bu = findViewById(R.id.button2);
        ed = findViewById(R.id.editText);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sss = ed.getText().toString();

                Intent data = new Intent();
                data.putExtra("number", sss);
                setResult(100, data);
                finish();
                //关闭当前的activity 然后传递数据给 调用者 调用者就会执行 onactivityResult的方法


            }
        });
    }
}
