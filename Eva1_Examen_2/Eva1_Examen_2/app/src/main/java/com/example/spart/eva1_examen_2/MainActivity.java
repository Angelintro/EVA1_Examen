package com.example.spart.eva1_examen_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, Button.OnClickListener {
    TextView TxtVwa1, TxtVwa2, TxtVwa3,  TxtVwa4, TxtVwa5,TxtVw8;
    RadioGroup RDG1;
    Button button;
    RadioButton RBtnalge,RBtnarit;
    int num1;
    double num2;
    int error=0;
    Random ran=new Random();
    EditText Etxtfaltante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TxtVwa1=findViewById(R.id.TxtVwa1);
RDG1=findViewById(R.id.RDG1);
        RBtnalge=findViewById(R.id.RBtnalge);
        RBtnarit=findViewById(R.id.RBtnarit);
        TxtVwa2=findViewById(R.id.TxtVwa2);
        TxtVwa3=findViewById(R.id.TxtVwa3);
        TxtVwa4=findViewById(R.id.TxtVwa4);
        TxtVwa5=findViewById(R.id.TxtVwa5);
        TxtVw8=findViewById(R.id.TxtVw8);
        Etxtfaltante=findViewById(R.id.Etxtfaltante);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        RDG1.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.RBtnalge:{
                int p=0;
                int z=0;
                int x=0;
                int m=0;
                int n=0;
                n=ran.nextInt(10);

                p=n;
                z=n+(2-1)*5;
                num1=n+(3-1)*5;
                x=n+(4-1)*5;
                m=n+(5-1)*5;
             TxtVwa1.setText(String.valueOf(p));
             TxtVwa2.setText(String.valueOf(z));
             TxtVwa3.setText("--");
             TxtVwa4.setText(String.valueOf(x));
             TxtVwa5.setText(String.valueOf(m));
            }break;
            case R.id.RBtnarit:{
                double p=0;
                double z=0;
                double x=0;
                double m=0;
                int n=0;
                int u=0;
                n=ran.nextInt(10);
                u=ran.nextInt(10)+1;
                p=n;
                z= (int) (n*Math.pow(u,1));
                num2=(int) (n*Math.pow(u,2));
                x=(int) (n*Math.pow(u,3));
                m=(int) (n*Math.pow(u,4));
                TxtVwa1.setText(String.valueOf(p));
                TxtVwa2.setText(String.valueOf(z));
                TxtVwa3.setText("--");
                TxtVwa4.setText(String.valueOf(x));
                TxtVwa5.setText(String.valueOf(m));
            }

        }
    }
    @Override
    public void onClick(View v) {
if (v.getId()==R.id.button){
    if (RBtnalge.isChecked()){
        if (num1==Integer.parseInt(Etxtfaltante.getText().toString())){
        TxtVw8.setText("Correcto");
            Toast.makeText(this,"Ganastes",Toast.LENGTH_SHORT).show();
        }else {
            TxtVw8.setText("Incorrecto");
            error++;
            if(error==3){
                TxtVwa1.setText("");
                TxtVwa2.setText("");
                TxtVwa3.setText("");
                TxtVwa4.setText("");
                TxtVwa5.setText("");
                TxtVw8.setText("Perdistes");
                Toast.makeText(this,"Perdistes",Toast.LENGTH_SHORT).show();
                error=0;
            }
        }
        }
        if (RBtnarit.isChecked()){
        if (num2==Double.parseDouble(Etxtfaltante.getText().toString())){
            TxtVw8.setText("Correcto");
            Toast.makeText(this,"Ganastes",Toast.LENGTH_SHORT).show();
        }else {
            TxtVw8.setText("Incorrecto");
            error++;
            if(error==3){
                TxtVwa1.setText("");
                TxtVwa2.setText("");
                TxtVwa3.setText("");
                TxtVwa4.setText("");
                TxtVwa5.setText("");
                TxtVw8.setText("Perdistes");
                error=0;
                Toast.makeText(this,"Perdistes",Toast.LENGTH_SHORT).show();
            }
        }

}
    }
}
}
