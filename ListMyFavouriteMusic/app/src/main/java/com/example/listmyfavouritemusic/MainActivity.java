package com.example.listmyfavouritemusic;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsBaiHat;
    ListView lsBaiHat;
    Button btnThemBH;
    EditText editTextTenBaiHat;
    ArrayAdapter<String> adapterBaiHat;

    void getControl() {
        lsBaiHat = findViewById(R.id.lvBH);
        btnThemBH = findViewById(R.id.btnThemBH);
        editTextTenBaiHat = findViewById(R.id.edtTenBH);
    }

    ArrayList<String> getData() {
        ArrayList<String> lstTenBaiHat = new ArrayList<>();
        lstTenBaiHat.add("Catch me if you can");
        lstTenBaiHat.add("Trói em lại");
        lstTenBaiHat.add("Tình đầu quá chén");
        lstTenBaiHat.add("Mưa đá");
        lstTenBaiHat.add("Thủy triều");
        lstTenBaiHat.add("Cứ để anh ta rời đi");
        return lstTenBaiHat;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControl();

        dsBaiHat = getData();
        adapterBaiHat = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsBaiHat);
        lsBaiHat.setAdapter(adapterBaiHat);

        lsBaiHat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                XuLyKhiClickVaoVtriThu(position);
            }
        });

        btnThemBH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenbai = editTextTenBaiHat.getText().toString().trim();
                if (!tenbai.isEmpty()) {
                    dsBaiHat.add(tenbai);
                    adapterBaiHat.notifyDataSetChanged();
                    editTextTenBaiHat.setText(""); // Clear input after adding
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên bài hát", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void XuLyKhiClickVaoVtriThu(int pos) {
        String item = dsBaiHat.get(pos);
        Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
    }
}
