package vn.edu.quanlichitieu;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    //Khai báo biến
    private Button luu;
    private EditText money, text;
    private RadioButton chi, tieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //khởi tạo các thành phần giao diện
        luu = findViewById(R.id.btn_luu);
        money = findViewById(R.id.txt_money);
        text = findViewById(R.id.txt_text);
        chi = findViewById(R.id.radio_chi);
        tieu = findViewById(R.id.radio_thu);

        //lấy nội dung từ textfield
        String textValue = text.getText().toString().trim();
        String moneyValue = money.getText().toString().trim();

        //kiểm tra radio button thuộc loại nào
        String radioType;
        if (chi.isChecked()) {
            radioType = "Chi";
        } else if (tieu.isChecked()) {
            radioType = "Thu";
        }
        

        //Đẩy dữ liệu lên firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                //xử lý dữ liệu
                Toast.makeText(getBaseContext(),"Value is" + value, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getBaseContext(), "Failed to read value.",Toast.LENGTH_LONG).show();
            }
        });
    }
}