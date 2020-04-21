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
                if (!checkFibo(A))
                    lbKetQua.setText("Số A bạn đã nhập không phái số thuộc dãy Fibonacci");
                else if(!checkFibo(B))
                    lbKetQua.setText("Số B bạn đã nhập không phải số thuộc dãy Fibonacci");
                else if(Fibonacci(A,B,C)) {
                    lbKetQua.setText("--- Ba số này là ứng cứ viên của dãy Fibonacci ---");
                }
                else
                    lbKetQua.setText("--- Ba số này không phải là ứng cứ viên của dãy Fibonacci ---");

            }
        });

    }

    private boolean Fibonacci(int A,int B,int C){
        if(A+B == C){
            return true;
        }
        return false;
    }

    private boolean checkFibo( int ele ){
        int fn1, fn2, fn;
        fn1 = 0;
        fn2 = 1;
        if( ele == fn1 || ele == fn2 )
            return true;
        else{
            while( true ){
                fn = fn1 + fn2;
                fn1 = fn2;
                fn2 = fn;
                if( ele == fn )
                    return true;
                if( ele < fn )
                    return false;
            }
        }
    }
}
