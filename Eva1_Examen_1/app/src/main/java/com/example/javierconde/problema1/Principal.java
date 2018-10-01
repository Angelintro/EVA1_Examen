package com.example.javierconde.problema1;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    EditText  edPi, edRadio, edGrad, edRes;
    RadioGroup rdgOpe;
    RadioButton rdVol, rdArea,rdVolCuña;
    TextView txtAcc, txtGrad, txtM3, txtRes;
    String total;
    Button btnCalc, btnCerrar;
    double dArea,dVol,dEsfera;
    static int i =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        edPi = findViewById(R.id.edPi);
        edRadio = findViewById(R.id.edRadio);
        edGrad = findViewById(R.id.edGrad);
        rdVol = findViewById(R.id.rdVol);
        rdArea = findViewById(R.id.rdArea);
        rdVolCuña = findViewById(R.id.rdVolCuña);
        txtAcc = findViewById(R.id.txtAcc);
        txtGrad = findViewById(R.id.txtGrad);
        txtM3 = findViewById(R.id.txtM3);
        txtRes = findViewById(R.id.txtRes);
        rdgOpe = findViewById(R.id.rdgOpe);
        btnCalc = findViewById(R.id.btnCalc);
        btnCerrar = findViewById(R.id.btnCerrar);
        rdgOpe.setOnCheckedChangeListener(this);
        //INICIANDO LA APP SE VULVE INVISIBLE
        txtGrad.setVisibility(View.INVISIBLE);
        edGrad.setVisibility(View.INVISIBLE);
        edPi.setText("3.1416");

        //CALCULAR RESULTADO
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double dRadio = Double.parseDouble(edRadio.getText().toString());

                double dPi = Double.parseDouble(edPi.getText().toString());

                if(v.getId()== R.id.btnCalc){
                    if(i==1){
                        dVol=(4*dPi*(dRadio*dRadio*dRadio))/3;

                        txtRes.setText(Double.toString(dVol));
                    }else if(i==2){
                        dArea=(4*dPi*(dRadio*dRadio));

                        txtRes.setText(Double.toString(dArea));
                    }else if(i==3){
                        double dGra = Double.parseDouble(edGrad.getText().toString());
                        //SE INICIALIZA SOLO EN DONDE SE VA A USAR SI NO, LANZA ERROR
                        dEsfera=(((4/3)*((dPi*dRadio*dRadio*dRadio)/360))*dGra);
                        txtRes.setText(Double.toString(dEsfera));
                    }
                }
            }
        });
        //CERRAR APP
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
                /*Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);*/
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        //CAMBIO DE TEXTO EN LOS TXT
        if(i == R.id.rdVol){
            txtAcc.setText(R.string.rd_volumen);
            txtM3.setText(R.string.txt_m3);
        }else if(i == R.id.rdArea){
            txtAcc.setText(R.string.rd_area);
            txtM3.setText(R.string.txt_m2);
        }else if(i == R.id.rdVolCuña){
            txtAcc.setText(R.string.rd_volumen_cuña);
            txtM3.setText(R.string.txt_m3);
        }
        //HACER VISIBLE O INVISIBLE SEGUN EL RADIOBUTTON QUE SE PRESIONE
        switch (i){
            case R.id.rdVol: {
                i = 1;
                txtGrad.setVisibility(View.INVISIBLE);
                edGrad.setVisibility(View.INVISIBLE);
            }break;
            case R.id.rdArea: {
                i = 2;
                txtGrad.setVisibility(View.INVISIBLE);
                edGrad.setVisibility(View.INVISIBLE);
            }break;
            case R.id.rdVolCuña: {
                i = 3;
                txtGrad.setVisibility(View.VISIBLE);
                edGrad.setVisibility(View.VISIBLE);
            }break;
        }
    }
}
