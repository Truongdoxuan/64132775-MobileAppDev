package th.doxuantruong.chuyenmanhinh_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //khai báo biến
    Button eng, math, programming;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        eng = findViewById(R.id.btn_eng);
        math = findViewById(R.id.btn_math);
        programming = findViewById(R.id.btn_lt);

        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EngPage(view);
            }
        });
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathPage(view);
            }
        });
        programming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                programPage(view);
            }
        });
    }
    public void EngPage(View view) {
        Intent engPage = new Intent(MainActivity.this, EngPage.class);
        startActivity(engPage);
        finish();
    }
    public void mathPage(View view) {
        Intent mPage = new Intent(MainActivity.this, MathPage.class);
        startActivity(mPage);
        finish();
    }
    public void programPage(View view) {
        Intent prPage = new Intent(MainActivity.this, ProgrammingPage.class);
        startActivity(prPage);
        finish();
    }
}