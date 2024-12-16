package th.doxuantruong.quizappgui2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Questions_Activity extends AppCompatActivity {

    private TextView txtQuestion, txtCheck;
    private Button btnA, btnB, btnC, btnD, btnNext;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private Question currentQuestion;

    private List<Question> questionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        txtQuestion = findViewById(R.id.txt_question);
        txtCheck = findViewById(R.id.txt_check);
        btnA = findViewById(R.id.caua);
        btnB = findViewById(R.id.caub);
        btnC = findViewById(R.id.cauc);
        btnD = findViewById(R.id.caud);
        btnNext = findViewById(R.id.btn_next);

        setupQuestions();
        displayQuestion();

        View.OnClickListener answerListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button selectedButton = (Button) v;
                checkAnswer(selectedButton);
            }
        };

        btnA.setOnClickListener(answerListener);
        btnB.setOnClickListener(answerListener);
        btnC.setOnClickListener(answerListener);
        btnD.setOnClickListener(answerListener);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestionIndex++;
                if (currentQuestionIndex < questionList.size()) {
                    resetButtonColors();
                    displayQuestion();
                } else {
                    txtQuestion.setText("Quiz completed!\n Your score: "+score);
                    btnA.setVisibility(View.GONE);
                    btnB.setVisibility(View.GONE);
                    btnC.setVisibility(View.GONE);
                    btnD.setVisibility(View.GONE);
                    btnNext.setVisibility(View.GONE);
                    txtCheck.setVisibility(View.GONE);
                }
            }
        });
    }

    private void setupQuestions() {
        questionList.add(new Question("What is the capital of France?", "Paris", "Berlin", "Madrid", "Rome", "Paris"));
        questionList.add(new Question("What is 2 + 2?", "3", "4", "5", "6", "4"));
        questionList.add(new Question("What is the city of Khanh Hoa'?", "Nha Trang", "Đa Nang", "Da Lat", "Lam Dong", "Nha Trang"));
        questionList.add(new Question("What is 10% of 100", "20", "30", "10", "5", "10"));
        questionList.add(new Question("What is the meaning of NTU ?","Nha Trang University","Van Lang University","Khanh Hoa University", "Ton Duc Thang University","Nha Trang University"));
        Collections.shuffle(questionList);
    }

    private void displayQuestion() {
        txtCheck.setText("");
        currentQuestion = questionList.get(currentQuestionIndex);
        txtQuestion.setText(currentQuestion.getQuestionText());
        btnA.setText(currentQuestion.getOptionA());
        btnB.setText(currentQuestion.getOptionB());
        btnC.setText(currentQuestion.getOptionC());
        btnD.setText(currentQuestion.getOptionD());
    }

    private void checkAnswer(Button selectedButton) {
        String selectedAnswer = selectedButton.getText().toString();
        if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
            txtCheck.setText("Correct!");
            score += 2;
            txtCheck.setTextColor(ContextCompat.getColor(this, R.color.green));
            selectedButton.setBackgroundResource(R.drawable.color_button_true);
        } else {
            txtCheck.setText("Wrong!");
            txtCheck.setTextColor(ContextCompat.getColor(this, R.color.red));
            selectedButton.setBackgroundResource(R.drawable.color_button_false);
        }
    }

    private void resetButtonColors() {
        btnA.setBackgroundResource(R.drawable.color_button);
        btnB.setBackgroundResource(R.drawable.color_button);
        btnC.setBackgroundResource(R.drawable.color_button);
        btnD.setBackgroundResource(R.drawable.color_button);
    }

}
