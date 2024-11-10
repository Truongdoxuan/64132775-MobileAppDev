package vn.doxuantruong;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ItemActivity extends AppCompatActivity {

    TextView txtRSSContent;
    public void getControls() {
        txtRSSContent = findViewById(R.id.txtRSSContent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item);
        getControls();
        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String rssUrl = intent.getStringExtra("rss_url");

        txtRSSContent.setText(rssUrl);
    }
}