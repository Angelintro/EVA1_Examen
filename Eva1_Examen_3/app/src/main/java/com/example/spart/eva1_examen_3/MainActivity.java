package com.example.spart.eva1_examen_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,Button.OnClickListener {
    RadioGroup rGB;
    RadioButton rbDificil,rbMedio,rbFacil;
    Button bIntento,bOk;
    CheckBox cbX;
    TextView tvExacto,tvIntento,tvLetras;
    EditText etLetra;
    int i,m;
    String palabras[]={"apostar","dividir","conquistar","megaman","gobernar","vikingos","metodologia","inmortal","mensajero","cereales"};

    Random rand = new Random();
    int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvExacto=findViewById(R.id.tvExacto);
        tvIntento=findViewById(R.id.tvIntento);
        etLetra=findViewById(R.id.etLetras);
        tvLetras=findViewById(R.id.tvLetras);
        rGB=findViewById(R.id.rgb);
        rbDificil=findViewById(R.id.rbDificil);
        rbMedio=findViewById(R.id.rbMedio);
        rbFacil=findViewById(R.id.rbFacil);
        bIntento=findViewById(R.id.bIntento);
        bOk=findViewById(R.id.bOk);
        cbX=findViewById(R.id.cbX);

        rGB.setOnCheckedChangeListener(this);
        bIntento.setOnClickListener(this);
        bOk.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
switch (checkedId){
    case R.id.rbDificil:
i=1;
break;
    case R.id.rbMedio:
        i=2;
        break;
    case R.id.rbFacil:
i=3;
break;
}

    }

    @Override
    public void onClick(View v) {
if(v.getId()== R.id.bIntento){
    n=rand.nextInt(10);
    if (i == 1) {
        tvIntento.setText("2");

for (int b=0;b<palabras[n].length();b++){
    if(b==0)
        tvExacto.setText("");
    if (b%2==0){
        tvExacto.append("_");
    }else
    tvExacto.append(String.valueOf(palabras[n].charAt(b)));
}
    }if (i == 2) {
        tvIntento.setText("4");
        for (int b=0;b<palabras[n].length();b++){
            if(b==0)
                tvExacto.setText("");
            if (b%2==0){
                tvExacto.append("_");
            }else
                tvExacto.append(String.valueOf(palabras[n].charAt(b)));
        }
    }if (i == 3) {
        tvIntento.setText("8");
        for (int b=0;b<palabras[n].length();b++){
            if(b==0)
                tvExacto.setText("");
            if (b%2==0){
                tvExacto.append("_");
            }else
                tvExacto.append(String.valueOf(palabras[n].charAt(b)));
        }
    }
}
if(v.getId()==R.id.bOk){
checarLetra(etLetra.getText().charAt(0));
}
    }
    public void checarLetra(char letra){
        String sPalabra = palabras[n];
        String sJue =tvExacto.getText().toString();
        for (int i =0;i<sPalabra.length();i++){
            if (letra==sPalabra.charAt(i)){
                Toast.makeText(this,"Correcto",Toast.LENGTH_SHORT);
            if (i==sPalabra.length()-1){
                sJue=sJue.substring(0,i)+letra;
            }else {
                sJue= sJue.substring(0,i)+letra+sJue.substring(i+1);
            }
            }
        }
        tvExacto.setText(sJue);
    }
}
