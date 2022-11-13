package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calculator extends AppCompatActivity {
    private Button b1;
    private EditText ed1,ed2,ed3;
    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        b1=(Button)findViewById(R.id.b1);
        ed1=(EditText) findViewById(R.id.num1);
        ed2=(EditText) findViewById(R.id.num2);
        ed3=(EditText) findViewById(R.id.cal2);
        t1=(TextView)findViewById(R.id.t1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String num1 = ed1.getText().toString();
                    String num3 = ed2.getText().toString();
                    String num2 = ed3.getText().toString();
                    String num4 = "+";
                    String num5 = "-";
                    Double n1 = Double.parseDouble(num1);
                    Double n3 = Double.parseDouble(num3);
                    if (num2.equals(num4)) {
                        Double sum = n1 + n3;
                        String sum2 = String.valueOf(sum);
                        t1.setText(sum2);
                    } else if (num2.equals(num5)) {
                        Double sub = n1 - n3;
                        String sub2 = String.valueOf(sub);
                        t1.setText(sub2);
                    } else if (num2.equals("*")) {
                        Double mul = n1 * n3;
                        String mul2 = String.valueOf(mul);
                        t1.setText(mul2);
                    } else if (num2.equals("/")) {
                        Double div = n1 / n3;
                        String div2 = String.valueOf(div);
                        t1.setText(div2);
                    } else {
                        t1.setText("Enter any operation first(+,-,*,/)");
                    }
                }catch (Exception e)
                {
                    Toast.makeText(calculator.this, "SORRY", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}