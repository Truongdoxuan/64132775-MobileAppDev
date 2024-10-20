package com.example.caroapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //khai bao
    private Button[][] buttons = new Button[3][3]; //mang 2 chieu 3x3
    private boolean firstplayer = true;
    private int roundcount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonId = "btn"+ i+j;
                int resId = getResources().getIdentifier(buttonId,"id",getPackageName());
                buttons[i][j] = findViewById(resId);
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!((Button) view).getText().toString().equals("")) {
                            return; //neu button da duoc nhan thi bo qua
                        }
                        if (firstplayer) {
                            ((Button)view).setText("X");
                        } else {
                            ((Button)view).setText("O");
                        }
                        roundcount++;
                        if (checkforWin()) {
                            if (firstplayer) {
                                player1Win();
                            } else {
                                player2Win();
                            }
                        } else if (roundcount == 9) {
                            draw();
                        } else {
                            firstplayer = !firstplayer; //doi luot nguoi choi
                        }
                    }
                });
            }
        }
    }

    //ktra nguoi thang
    private boolean checkforWin() {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        //kiem tra hang ngan
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals("")) {
                return true;
            }
        }
        //kiem tra hang ngan
        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals("")) {
                return true;
            }
        }
        //kiem tra duong cheo
        if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals("")) {
            return true;
        }
        if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("")) {
            return true;
        }
        return false;
    }
    //xu ly khi co nguoi win
    private void player1Win() {
        Toast.makeText(this,"Player X win !", Toast.LENGTH_SHORT).show();
        resetBoard(); //lam moi grid layout
    }
    private void player2Win() {
        Toast.makeText(this,"Player O win 1", Toast.LENGTH_SHORT).show();
        resetBoard();
    }
    //xu ly hoa
    private void draw() {
        Toast.makeText(this,"Draw !", Toast.LENGTH_SHORT).show();
        resetBoard();
    }
    //reset bang
    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        roundcount = 0; //reset so luot di
        firstplayer = true;
    }
}