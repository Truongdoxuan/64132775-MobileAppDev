package truong.demo.chuyenmanhinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page2);
    }
    public void ReturnPage1 (View v) {
        //Lay itent ve
        Intent iNhanDuoc = getIntent();
        //Boc du lieu
        String data = iNhanDuoc.getStringExtra("ten");
        //hien thi
        Toast.makeText(getBaseContext(),data,Toast.LENGTH_LONG).show();
        //chuyen ve page1
        Intent iPage1 = new Intent(Page2.this,MainActivity.class);
        startActivity(iPage1);
    }
}