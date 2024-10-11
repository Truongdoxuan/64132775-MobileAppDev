package com.example.bt2_sohocdongian;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //1. khai bao cac dieu khien (tham chieu den view)
    Button bCong, bTru, bNhan,bChia;
    EditText editTextA, editTextB;
    TextView textViewKetQua;

    //2. Ham tìm các điều khiển, cất vào biến ở trên
    void getControls () {
        bCong = findViewById(R.id.button);
        bTru= findViewById(R.id.button2);
        bNhan = findViewById(R.id.button3);
        bChia = findViewById(R.id.button4);
        editTextA = findViewById(R.id.editA);
        editTextB = findViewById(R.id.editB);
        textViewKetQua = findViewById(R.id.tvKQ);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        //3. gọi ham
        getControls();
    }

    //Xử lý sự kiện cộng
    public void XuLy_Cong(View v) {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        double kq = a + b;
        textViewKetQua.setText(String.valueOf(kq));
    }

    public void XuLy_Tru(View v) {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        double kq = a - b;
        textViewKetQua.setText(String.valueOf(kq));
    }

    public void XuLy_Nhan(View v) {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        double kq = a * b;
        textViewKetQua.setText(String.valueOf(kq));
    }

    public void XuLy_Chia(View v) {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        double kq = a / b;
        textViewKetQua.setText(String.valueOf(kq));
    }
}