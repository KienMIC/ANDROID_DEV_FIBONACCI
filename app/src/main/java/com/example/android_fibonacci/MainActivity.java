package com.example.android_fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView lbNhapA,lbNhapB,lbNhapC,lbKetQua;
    EditText txtA,txtB,txtC;
    Button btnKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.RegisterControlAndEvent();

        Toast toast = Toast.makeText(this.getApplicationContext(),"Cảm ơn bạn đã sử dụng ứng dụng !",Toast.LENGTH_SHORT);
        toast.show();

        Context context = this.getApplicationContext();
    }

    private void RegisterControlAndEvent(){
        this.lbNhapA = (TextView)this.findViewById(R.id.tV_NhapSoA);
        this.lbNhapB = (TextView)this.findViewById(R.id.tV_NhapSoB);
        this.lbNhapC = (TextView)this.findViewById(R.id.tV_NhapSoC);
        this.lbKetQua = (TextView)this.findViewById(R.id.tV_KetQua);

        this.txtA = (EditText)this.findViewById(R.id.eT_A);
        this.txtB = (EditText)this.findViewById(R.id.eT_B);
        this.txtC = (EditText)this.findViewById(R.id.eT_C);

        this.btnKetQua = (Button)this.findViewById(R.id.btnKetQua);


        this.btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int A = Integer.parseInt(txtA.getText().toString());
                int B = Integer.parseInt(txtB.getText().toString());
                int C = Integer.parseInt(txtC.getText().toString());
                if(Fibonacci(A,B,C)) {
                    lbKetQua.setText("--- Đây là dãy fibonacci ---");
                }
                else
                    lbKetQua.setText("--- Đây không phải dãy fibonacci ---");

            }
        });

    }

    private boolean Fibonacci(int A,int B,int C){
        if(A+B == C){
            return true;
        }
        return false;
    }
}
