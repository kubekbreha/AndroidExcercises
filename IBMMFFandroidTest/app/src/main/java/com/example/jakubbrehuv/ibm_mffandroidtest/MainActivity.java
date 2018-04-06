package com.example.jakubbrehuv.ibm_mffandroidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.submit_button);
        TextView textView = findViewById(R.id.text_view);

        button.setTransformationMethod(null);
        button.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.submit_button ){

        }
    }
}
