package com.fionera.receiver;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * MaintainActivity
 * Created by fionera on 17-8-14 in IocProcessor.
 */

public class MaintainActivity
        extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("Maintain Application");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendBroadcast(new Intent("com.fionera.receiver.RECEIVE"));
            }
        });
        setContentView(textView);
    }
}
