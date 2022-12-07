package com.example.aula_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button);
        TextView texto = (TextView)findViewById(R.id.tv);
        EditText edPraPegar = (EditText)findViewById(R.id.et_name);

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                texto.setText(edPraPegar.getText());
            }
        });
    }


}