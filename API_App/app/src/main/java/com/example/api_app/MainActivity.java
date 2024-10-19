package com.example.api_app;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    //khai bao
    private EditText apiLink;
    private Button search, reload;
    private TextView apiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //khoi tao cac thanh phan giao dien
        apiLink = findViewById(R.id.txtInput);
        search = findViewById(R.id.btnSearch);
        reload = findViewById(R.id.btnReload);
        apiResult = findViewById(R.id.txtKQ);

        //action khi nhan nut reload
        reload.setOnClickListener(v -> {
            apiLink.setText("");//xoa link
            apiResult.setText("");//xoa nd textview
        });
        //action khi nhan nut search
        search.setOnClickListener(v -> {
            String apiURL = apiLink.getText().toString();
            if (!apiURL.isEmpty()) {
                new FetchApiData().execute(apiURL); //goi api
            }
        });
    }
    private class FetchApiData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String apiURL = params[0];
            try {
                URL url = new URL(apiURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line;
                while((line = reader.readLine()) != null) {
                    result.append(line);
                }
                reader.close();
                return result.toString();
            }catch (Exception e) {
                e.printStackTrace();
                return "Error Fetch Data!";
            }
        }
        @Override
        protected void onPostExecute(String apiResponse) {
            // Hiển thị kết quả lên TextView
            MainActivity.this.apiResult.setText(apiResponse);
        }
    }
}