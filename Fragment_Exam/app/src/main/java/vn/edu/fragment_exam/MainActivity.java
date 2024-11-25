package vn.edu.fragment_exam;

import android.os.Bundle;

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

        //fragment đầu tiên
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frag, new Content_Fragment())
                .commit();

        //fragment thứ 2
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.footer_frag, new Footer_Fragment())
                .commit();
    }
}