package com.example.spart.eva1_examen_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, Button.OnClickListener {
    TextView txtIp, txtMsk, txtSubR, txtPrf;
    EditText edIp1, edIp2, edIp3, edIp4, edMk1, edMk2, edMk3, edMk4;
    Button btnCal, btnBorr;
    RadioGroup dbgForm;
    RadioButton rdBin, rdDec;
    int ip1,ip2,ip3,ip4, mk1, mk2, mk3, mk4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtIp = findViewById(R.id.txtIp);
        txtMsk = findViewById(R.id.txtMsk);
        txtSubR = findViewById(R.id.txtSubR);
        txtPrf = findViewById(R.id.txtPrf);
        edIp1 = findViewById(R.id.edIp1);
        edIp2 = findViewById(R.id.edIp2);
        edIp3 = findViewById(R.id.edIp3);
        edIp4 = findViewById(R.id.edIp4);
        edMk1 = findViewById(R.id.edMk1);
        edMk2 = findViewById(R.id.edMk2);
        edMk3 = findViewById(R.id.edMk3);
        edMk4 = findViewById(R.id.edMk4);
        btnCal = findViewById(R.id.btnCal);
        btnBorr = findViewById(R.id.btnBorr);
        dbgForm = findViewById(R.id.dbgForm);
        rdBin = findViewById(R.id.rdBin);
        rdDec = findViewById(R.id.rdDec);

        dbgForm.setOnCheckedChangeListener(this);
        btnCal.setOnClickListener(this);
        btnBorr.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rdBin:{

                int deci = Integer.parseInt(edIp1.getText().toString());
                int d =Integer.parseInt(edIp2.getText().toString());
                int e =Integer.parseInt(edIp3.getText().toString());
                int i= Integer.parseInt(edIp4.getText().toString());
                txtIp.setText(Integer.toBinaryString(deci)+"-"+Integer.toBinaryString(d)+"-"+Integer.toBinaryString(e)+"-"+Integer.toBinaryString(i));
                //txtIp.setText(Integer.toBinaryString(ip1)+"-"+Integer.toBinaryString(ip2)+"-"+Integer.toBinaryString(ip3)+"-"+Integer.toBinaryString(ip4));
                int s = Integer.parseInt(edMk1.getText().toString());
                int a = Integer.parseInt(edMk2.getText().toString());
                int f = Integer.parseInt(edMk3.getText().toString());
                int g = Integer.parseInt(edMk4.getText().toString());
                txtMsk.setText(Integer.toBinaryString(s)+"-"+Integer.toBinaryString(a)+"-"+Integer.toBinaryString(f)+"-"+Integer.toBinaryString(g));
            }
                break;
            case R.id.rdDec: {
                txtIp.setText(edIp1.getText() + "-" + edIp2.getText() + "-" + edIp3.getText() + "-" + edIp4.getText());
                txtMsk.setText(edMk1.getText()+"-"+edMk2.getText()+"-"+edMk3.getText()+"-"+edMk4.getText());
                ip1 = Integer.parseInt(edIp1.getText().toString());
            }
            break;


        }

    }

    @Override
    public void onClick(View v) {
if (v.getId()==R.id.btnCal){
    txtSubR.setText(edIp1.getText()+"-"+edIp2.getText()+"-"+edIp3.getText()+"-"+edMk4.getText());
    int x=0,c=0,t=0,p=0;
    int deci = Integer.parseInt(edIp1.getText().toString());
    int d =Integer.parseInt(edIp2.getText().toString());
    int e =Integer.parseInt(edIp3.getText().toString());
    int g = Integer.parseInt(edMk4.getText().toString());
    char Letra;
    int suma=0;
    Letra = 1;
    String s1=Integer.toBinaryString(deci);
    for (int i=0;i<s1.length();i++){
          if(s1.charAt(i)==Letra) {
              x++;
              suma= suma+x;
          }
}
    String s2=Integer.toBinaryString(d);
    for (int i=0;i<s2.length();i++){
        if(s2.charAt(i)==Letra)
            c++;
        suma=suma+c;
    }
    String s3=Integer.toBinaryString(e);
    for (int i=0;i<s3.length();i++){
        if(s3.charAt(i)==Letra)
            t++;
        suma=suma+t;
    }
    String s4=Integer.toBinaryString(g);
    for (int i=0;i<s4.length();i++) {
        if (s4.charAt(i) == Letra)
            p++;
        suma=suma+p;
    }

    String sub = String.valueOf(suma);
    txtPrf.setText(sub);
}
if (v.getId()==R.id.btnBorr){
    txtPrf.setText("");
    txtSubR.setText("");
    txtMsk.setText("");
    txtIp.setText("");
    edIp1.setText("");
    edIp2.setText("");
    edIp3.setText("");
    edIp4.setText("");
    edMk1.setText("");
    edMk2.setText("");
    edMk3.setText("");
    edMk4.setText("");

}
}
}
