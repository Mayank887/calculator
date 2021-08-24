package com.example.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.zip.Inflater;

public class Input extends Fragment {
    @Nullable
            InputListener listener;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16,tv17,tv18,tv19,tv20;
    public interface InputListener{
        void onInput(String input,String data);

    }
    String input="";

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.input,null);
        TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16,tv17,tv18,tv19,tv20;
        tv1=v.findViewById(R.id.a1); tv2=v.findViewById(R.id.a2); tv3=v.findViewById(R.id.a3); tv4=v.findViewById(R.id.a4); tv5=v.findViewById(R.id.a5);
        tv6=v.findViewById(R.id.a6); tv7=v.findViewById(R.id.a7); tv8=v.findViewById(R.id.a8); tv9=v.findViewById(R.id.a9); tv10=v.findViewById(R.id.a10);
        tv11=v.findViewById(R.id.a11); tv12=v.findViewById(R.id.a12); tv13=v.findViewById(R.id.a13); tv14=v.findViewById(R.id.a14); tv15=v.findViewById(R.id.a15);
        tv16=v.findViewById(R.id.a16); tv17=v.findViewById(R.id.a17); tv18=v.findViewById(R.id.a18); tv19=v.findViewById(R.id.a19); tv20=v.findViewById(R.id.a20);
        tv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"1";
                listener.onInput("",input);

            }
        });
        tv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"1";
                listener.onInput("",input);

            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input="";
                listener.onInput("",input);

            }
        });
        tv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"2";
                listener.onInput("",input);

            }
        });
        tv15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"3";
                listener.onInput("",input);

            }
        });
        tv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"4";
                listener.onInput("",input);

            }
        });
        tv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"5";
                listener.onInput("",input);

            }
        });
        tv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"6";
                listener.onInput("",input);

            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"7";
                listener.onInput("",input);

            }
        });
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"8";
                listener.onInput("",input);

            }
        });
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"9";
                listener.onInput("",input);

            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.length()!=0){
                input=input.substring(0,input.length()-1);}
                listener.onInput("",input);

            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"%";
                listener.onInput("",input);

            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"/";
                listener.onInput("",input);

            }
        });
        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"X";
                listener.onInput("",input);

            }
        });
        tv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"-";
                listener.onInput("",input);

            }
        });
        tv16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"+";
                listener.onInput("",input);

            }
        });
        tv17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"00";
                listener.onInput("",input);

            }
        });
        tv18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+"0";
                listener.onInput("",input);

            }
        });


        tv19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input+".";
                listener.onInput("",input);

            }
        });
        tv20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input.replaceAll("X","*");
                input=input.replaceAll("%","/100");
                input=input.replaceAll("/","/");
                input=input.replaceAll("X","*");
                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);
                String result="";
                Scriptable scriptable=rhino.initStandardObjects();
                result=rhino.evaluateString(scriptable,input,"Javascript",1,null).toString();
                listener.onInput(result,input);


            }
        });

        return v;
    }

    @Override
    public void onAttach(@NonNull  android.content.Context context) {
        super.onAttach(context);
        if(context instanceof InputListener){
            listener=(InputListener)context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
