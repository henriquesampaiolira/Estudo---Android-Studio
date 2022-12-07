package com.example.aula_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {
    double num1,num2,res;
    EditText et_v1;
    EditText et_v2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSomar = (Button)findViewById(R.id.somar);
        Button btnSubtrair = (Button)findViewById(R.id.subtrair);
        Button btnDividir = (Button)findViewById(R.id.dividir);
        Button btnMultiplicar = (Button)findViewById(R.id.multiplicar);
        et_v1 = (EditText)findViewById(R.id.et_v1);
        et_v2 = (EditText)findViewById(R.id.et_v2);
        tv = (TextView)findViewById(R.id.resultado);


        /*btnSomar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                num1 = Double.parseDouble(et_v1.getText().toString());
                num2 = Double.parseDouble(et_v2.getText().toString());
                res=num1+num2;
                tv.setText(String.valueOf(res));
            }
        });
        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                num1 = Double.parseDouble(et_v1.getText().toString());
                num2 = Double.parseDouble(et_v2.getText().toString());
                res=num1-num2;
                tv.setText(String.valueOf(res));
            }
        });
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                num1 = Double.parseDouble(et_v1.getText().toString());
                num2 = Double.parseDouble(et_v2.getText().toString());
                res=num1*num2;
                tv.setText(String.valueOf(res));
            }
        });
        btnDividir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                num1 = Double.parseDouble(et_v1.getText().toString());
                num2 = Double.parseDouble(et_v2.getText().toString());
                res=num1/num2;
                tv.setText(String.valueOf(res));
            }
        });*/

    }
    public void somar(){
        num1 = Double.parseDouble(et_v1.getText().toString());
        num2 = Double.parseDouble(et_v2.getText().toString());
        res=num1+num2;
        tv.setText(String.valueOf(res));
    }
    public void subtrair(){
        num1 = Double.parseDouble(et_v1.getText().toString());
        num2 = Double.parseDouble(et_v2.getText().toString());
        res=num1-num2;
        tv.setText(String.valueOf(res));
    }
    public void multiplicar(){
        num1 = Double.parseDouble(et_v1.getText().toString());
        num2 = Double.parseDouble(et_v2.getText().toString());
        res=num1*num2;
        tv.setText(String.valueOf(res));
    }
    public void dividir(){
        num1 = Double.parseDouble(et_v1.getText().toString());
        num2 = Double.parseDouble(et_v2.getText().toString());
        res=num1/num2;
        tv.setText(String.valueOf(res));
    }

    public void opera(View v){
        switch (v.getId()){
            case R.id.somar:
                somar();
                break;
            case R.id.subtrair:
                subtrair();
                break;
            case R.id.dividir:
                dividir();
                break;
            default:
                multiplicar();
        }
    }
}