package com.example.listmyfavouritemusic;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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

public class MainActivity extends AppCompatActivity {
    //Nguon du lieu
    ArrayList<String> dsBaiHat;
    //
    ListView lsBaiHat;
    Button btnThemBH;
    EditText editTextTenBaiHat;
    ArrayAdapter<String> adapterBaiHat;
    void getControl() {
        //tim dieu khien
        lsBaiHat = findViewById(R.id.lvBH);
        btnThemBH = findViewById(R.id.btnThemBH);
        editTextTenBaiHat = findViewById(R.id.edtTenBH);
    }
    //ham doc du lieu tu 1 nguon bat ky
    ArrayList<String> getData() {
        ArrayList<String> lstTenBaiHat = new ArrayList<String>();
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
        adapterBaiHat = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,dsBaiHat);
        lsBaiHat.setAdapter(adapterBaiHat);
        adapterBaiHat.notify();

        lsBaiHat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                XuLyKhiClickVaoVtriThu(position);
            }

        });
        btnThemBH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lay du lieu
                String tenbai = editTextTenBaiHat.getText().toString();
                //Them vao nguon du lieu
                dsBaiHat.add(tenbai);
                //bao apdater cap nhat
                adapterBaiHat.notifyDataSetChanged();
            }
        });
    }//end Create
    void  XuLyKhiClickVaoVtriThu(int pos) {
        //Lay phan tu
        String item = dsBaiHat.get(pos);
        Toast.makeText(getApplicationContext(),item,Toast.LENGTH_SHORT).show();
    }
}