package vn.doxuantruong;

import android.app.usage.UsageEvents;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    //cau1
    public void nextPage1(View v) {
        Intent iBai1 = new Intent(MainActivity.this,activityBai1.class);
        startActivity(iBai1);
    }
    //cau2
    public void nextPage2(View v) {
        Intent iBai2 = new Intent(MainActivity.this,activityBai2.class);
        startActivity(iBai2);
    }
    //cau3
    public void nextPage3(View v) {
        Intent iBai3 = new Intent(MainActivity.this,activityBai3.class);
        startActivity(iBai3);
    }
    //cau4
    public void nextPage4(View v) {
        Intent iBai4 = new Intent(MainActivity.this,activityBai4.class);
        startActivity(iBai4);
    }
}