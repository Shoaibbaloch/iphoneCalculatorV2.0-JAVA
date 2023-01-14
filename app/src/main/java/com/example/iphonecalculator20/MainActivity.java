package com.example.iphonecalculator20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    TextView Textview;
    Button btnAc,btnNeg,btnPercentage,btnDiv,btn8,btn9,btnMul,btn4,btn5,btn6,btnSub;
    Button Btn7,btn1,btn2,btn3,btnPlus,btn0,btnDot,btnEqual;
    String process ;
    Boolean CheckSign=false ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Textview =findViewById(R.id.Texview);
        Textview.setShowSoftInputOnFocus(false);
        btnAc =findViewById(R.id.btnAC);
        btnNeg =findViewById(R.id.btnNeg);
        btnPercentage =findViewById(R.id.btnPercentage);
        btnDiv =findViewById(R.id.btnDiv);
        Btn7 =findViewById(R.id.Btn7);
        btn8 =findViewById(R.id.btn8);
        btn9 =findViewById(R.id.btn9);
        btnMul =findViewById(R.id.btnMul);
        btn4 =findViewById(R.id.btn4);
        btn5 =findViewById(R.id.btn5);
        btn6 =findViewById(R.id.btn6);
        btnSub =findViewById(R.id.btnSub);
        btn1 =findViewById(R.id.btn1);
        btn2 =findViewById(R.id.btn2);
        btn3 =findViewById(R.id.btn3);
        btnPlus =findViewById(R.id.btnPlus);
        btn0=findViewById(R.id.btn0);
        btnDot =findViewById(R.id.btnDot);
        btnEqual =findViewById(R.id.btnEqual);

        Textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(getString(R.string.Textview).equals(Textview.getText().toString())){
                Textview.setText("");
            }
            }
        });
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Textview.setText("");
            }
        });
    btn0.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           process =  Textview.getText().toString();
            Textview.setText(process + "0");
        }
    });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "6");
            }
        });
        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "9");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + ".");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "*");
            }
        });
        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "%");
            }
        });
        btnNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                   process =  Textview.getText().toString();
                   Textview.setText(process + " ");
               }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "/");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "-");
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                Textview.setText(process + "+");
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process =  Textview.getText().toString();
                process = process.replace("×","*");
                process = process.replace("%", "/100");
                process = process.replace("÷", "/");

               Context rhino = Context.enter();
               rhino.setOptimizationLevel(-1);
               String finalresult ="";
               try {
                   Scriptable scriptable = rhino.initSafeStandardObjects();
                   finalresult = rhino.evaluateString(scriptable, process , "javascript", -1, null).toString();
               }
               catch(Exception e){
                   finalresult = "0";

               }
                Textview.setText(finalresult);

            }
        });
    }

}