package th.doxuantruong.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //khai báo biến
    TextView chieucao, cannang, ketqua, nhanxet;
    CheckBox isChauA;
    Button tinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        chieucao = findViewById(R.id.txt_chieucao);
        cannang = findViewById(R.id.txt_cannang);
        isChauA = findViewById(R.id.cb_asian);
        tinh = findViewById(R.id.btn_tinh);
        ketqua = findViewById(R.id.kqua);
        nhanxet = findViewById(R.id.nxet);

        //khi nhấn btn tính
        tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinhBMI();
            }
        });
    }
    //hàm thực hiện tính
    public void tinhBMI() {
        double ccao = Double.parseDouble(chieucao.getText().toString());
        double cnang = Double.parseDouble(cannang.getText().toString());
        boolean isAsia = isChauA.isChecked();
        String cmt;

        //cth tính
        double bmi = cnang / (ccao * ccao);
        ketqua.setText(String.format("%.2f",bmi));

        //nhận xét
        if (isAsia) {
            if (bmi < 18.5) {
                cmt = "Gầy";
            } else if (bmi < 23) {
                cmt = "Bình thường";
            } else if (bmi < 27.5) {
                cmt = "Thừa cân";
            } else {
                cmt = "Béo phì";
            }
        } else {
            if (bmi < 18.5) {
                cmt = "Gầy";
            } else if (bmi < 23) {
                cmt = "Bình thường";
            } else if (bmi < 30) {
                cmt = "Thừa cân";
            } else {
                cmt = "Béo phì";
            }
        }
        nhanxet.setText(cmt);
    }
}