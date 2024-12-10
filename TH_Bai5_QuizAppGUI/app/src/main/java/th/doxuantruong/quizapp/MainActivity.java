package th.doxuantruong.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //khai báo biến
    ImageButton btnC, btnJava, btnPython;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnC = findViewById(R.id.btn_c);
        btnJava = findViewById(R.id.btn_java);
        btnPython = findViewById(R.id.btn_python);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CPage(view);
            }
        });

        btnJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JavaPage(view);
            }
        });

        btnPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PythonPage(view);
            }
        });
    }
    //hàm thực hiện chuyển trang
    public void CPage(View view) {
        Intent cpage = new Intent(MainActivity.this, C_Activity.class);
        startActivity(cpage);
        finish();
    }
    public void JavaPage(View view) {
        Intent javapage = new Intent(MainActivity.this, Java_Activity.class);
        startActivity(javapage);
        finish();
    }
    public void PythonPage(View view) {
        Intent pythonpage = new Intent(MainActivity.this, Python_Activity.class);
        startActivity(pythonpage);
        finish();
    }
}