package th.doxuantruong.simplemath;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //khai báo biến
    TextView textA, textB, ketqua;
    RadioGroup radioGroup;
    Button tinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textA = findViewById(R.id.txt_a);
        textB = findViewById(R.id.txt_b);
        radioGroup = findViewById(R.id.radioGroup);
        tinh = findViewById(R.id.btn_tinh);
        ketqua = findViewById(R.id.txt_kq);

        tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinhtoan();
            }
        });
    }
    public void tinhtoan() {
        double soA = Double.parseDouble(textA.getText().toString());
        double soB = Double.parseDouble(textB.getText().toString());
        double kq = 0;
        int duocchon = radioGroup.getCheckedRadioButtonId();

        if (duocchon == R.id.rd_cong) {
            kq = soA + soB;
        }
        else if (duocchon == R.id.rd_tru) {
            kq = soA - soB;
        }
        else if (duocchon == R.id.rd_nhan) {
            kq = soA * soB;
        }
        else if (duocchon == R.id.rd_chia) {
            kq = soA / soB;
        }
        ketqua.setText("Kết quả: " +kq);
    }
}