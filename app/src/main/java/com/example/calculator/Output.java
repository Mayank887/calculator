package com.example.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Output extends Fragment {
    TextView tv,tv1;

    @Nullable

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.output,null);
        tv=v.findViewById(R.id.textView2);
        tv1=v.findViewById(R.id.textView);
        return v;
    }
    public void update(String res,String data){
        tv.setText(res);
        tv1.setText(data);
    }

}
