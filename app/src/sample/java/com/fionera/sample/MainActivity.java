package com.fionera.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fionera.crash.R;
import com.fionera.ioc.BindView;
import com.fionera.ioc.IocInjector;
import com.fionera.ioc.ViewInjector;

public class MainActivity
        extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IocInjector.inject(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "It works", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
