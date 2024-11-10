package vn.doxuantruong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class activityBai2 extends AppCompatActivity {

    ListView lvRSS;
    ArrayList<String> rssFeeds;
    ArrayAdapter<String> adapterRSS;

    void getControl() {
        lvRSS = findViewById(R.id.lvRSS);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai2);
        getControl();
        rssFeeds = new ArrayList<>();
        rssFeeds.add("https://vnexpress.net/rss/tin-moi-nhat.rss");
        rssFeeds.add("https://tuoitre.vn/rss/tin-moi-nhat.rss");
        rssFeeds.add("https://thanhnien.vn/rss/tin-moi-nhat.rss");
        rssFeeds.add("https://nhandan.vn/rss/tin-moi-nhat.rss");
        adapterRSS = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rssFeeds);
        lvRSS.setAdapter(adapterRSS);

        lvRSS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String rssUrl = rssFeeds.get(position);
                Intent intent = new Intent(activityBai2.this, ItemActivity.class);
                intent.putExtra("rss_url", rssUrl);
                startActivity(intent);
            }
        });
    }

    //ve trang main
    public void returnMain(View v) {
        //Lay intent ve
        Intent iPageMain = new Intent(activityBai2.this,MainActivity.class);
        startActivity(iPageMain);
    }
}