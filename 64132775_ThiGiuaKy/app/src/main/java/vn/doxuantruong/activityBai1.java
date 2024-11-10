package vn.doxuantruong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activityBai1 extends AppCompatActivity {
    //khai báo biến
    Button btntinh, btnreset;
    TextView txtcc, txtcn, txttlkq1, txttlkq2, txtkq;

    void getControls() {
        btntinh = findViewById(R.id.btnTinh);
        btnreset = findViewById(R.id.btnReset);
        txtcc = findViewById(R.id.txtChieucao);
        txtcc = findViewById(R.id.txtChieucao);
        txtcn = findViewById(R.id.txtCannang);
        txttlkq1 = findViewById(R.id.txtTitleKq1);
        txttlkq2 = findViewById(R.id.txtTitleKq2);
        txtkq = findViewById(R.id.txtKQ);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai1);
        getControls();
    }
    //xử lý sự kiện tính BMI
    public void tinhBMI(View v) {
        float chieucao = Float.parseFloat(txtcc.getText().toString());
        float cannang = Float.parseFloat(txtcn.getText().toString());
        float kq = cannang/(chieucao*chieucao);
        txttlkq1.setText("Chỉ số BMI của bạn là: ");
        txtkq.setText(String.format("%.2f",kq));
        //in nhận xét
        if (kq < 18.5) {
            txttlkq2.setText("Bạn gầy");
        }
        else if (kq < 25) {
            txttlkq2.setText("Bạn bình thường");
        }
        else if (kq <30 ) {
            txttlkq2.setText("Bạn thừa cân");
        }
        else txttlkq2.setText("Bạn béo phì");
    }
    //reset
    public void LamMoi(View v) {
        txtcc.setText("");
        txtcn.setText("");
        txttlkq1.setText("");
        txttlkq2.setText("");
        txtkq.setText("");
    }
    //ve trang main
    public void returnMain(View v) {
        //Lay intent ve
        Intent iPageMain = new Intent(activityBai1.this,MainActivity.class);
        startActivity(iPageMain);
    }
}