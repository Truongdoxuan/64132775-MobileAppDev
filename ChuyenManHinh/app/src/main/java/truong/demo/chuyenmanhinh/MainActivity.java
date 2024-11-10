package truong.demo.chuyenmanhinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
    //
    public void NextPage2(View v) {
        //tao intent
        Intent iPage2 = new Intent(MainActivity.this,Page2.class);
        //goi du lieu
        iPage2.putExtra("ten","Xuan Truong");
        //chuyen man hinh
        startActivity(iPage2);
    }
}