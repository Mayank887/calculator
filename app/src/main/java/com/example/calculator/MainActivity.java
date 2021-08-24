package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Input.InputListener {
    Input input1;
    Output output1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1=new Input();
        output1=new Output();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.outputid,output1)
                .replace(R.id.inputid,input1)
                .commit();

    }

    @Override
    public void onInput(String input,String data) {
        output1.update(input,data);
    }
}