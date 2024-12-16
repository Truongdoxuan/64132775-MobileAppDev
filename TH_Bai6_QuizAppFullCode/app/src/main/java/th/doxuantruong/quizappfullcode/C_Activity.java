package th.doxuantruong.quizappfullcode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class C_Activity extends AppCompatActivity {
    //khai báo biến
    TextView question;
    Button btnA, btnB, btnC, btnD, btnNext;
    ArrayList<Questions> questionList = new ArrayList<>();
    int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_c);

        question = findViewById(R.id.txt_question);
        btnA = findViewById(R.id.btn_a);
        btnB = findViewById(R.id.btn_b);
        btnC = findViewById(R.id.btn_c);
        btnD = findViewById(R.id.btn_d);
        btnNext = findViewById(R.id.btn_next);

        // Gọi phương thức gán OnClickListener cho các nút
        setupAnswerButtons();

        // Tạo danh sách câu hỏi
        loadQuestions();

        // Hiển thị câu hỏi đầu tiên
        showQuestion(currentIndex);

        // Xử lý sự kiện nút Next
        btnNext.setOnClickListener(v -> {
            currentIndex++;
            if (currentIndex < questionList.size()) {
                // Đặt lại màu của các nút đáp án trước khi hiển thị câu hỏi mới
                resetButtonColors();
                showQuestion(currentIndex);
            }
        });
    }

    // Tạo danh sách câu hỏi
    private void loadQuestions() {
        ArrayList<String> questionText1 = new ArrayList<>();
        questionText1.add("What is the output of the following C code?");
        questionText1.add("int x = 5; printf('%d', x);");

        ArrayList<String> answers1 = new ArrayList<>();
        answers1.add("5");
        answers1.add("x");
        answers1.add("Error");
        answers1.add("None of the above");

        questionList.add(new Questions(questionText1, answers1, 0));
    }

    // Hiển thị câu hỏi
    private void showQuestion(int index) {
        Questions currentQuestion = questionList.get(index); // Đổi tên biến để rõ ràng hơn

        // Hiển thị nội dung câu hỏi
        question.setText(
                currentQuestion.getQuestionText().get(0) + "\n" +
                        currentQuestion.getQuestionText().get(1)
        );

        // Hiển thị đáp án
        btnA.setText("A. " + currentQuestion.getAnswers().get(0));
        btnB.setText("B. " + currentQuestion.getAnswers().get(1));
        btnC.setText("C. " + currentQuestion.getAnswers().get(2));
        btnD.setText("D. " + currentQuestion.getAnswers().get(3));
    }

    private void setupAnswerButtons() {
        View.OnClickListener answerClickListener = v -> {
            int selectedAnswerIndex = -1;
            if (v.getId() == R.id.btn_a) selectedAnswerIndex = 0;
            else if (v.getId() == R.id.btn_b) selectedAnswerIndex = 1;
            else if (v.getId() == R.id.btn_c) selectedAnswerIndex = 2;
            else if (v.getId() == R.id.btn_d) selectedAnswerIndex = 3;

            if (selectedAnswerIndex == questionList.get(currentIndex).getCorrectAnswerIndex()) {
                v.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
            } else {
                v.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
            }
        };

        btnA.setOnClickListener(answerClickListener);
        btnB.setOnClickListener(answerClickListener);
        btnC.setOnClickListener(answerClickListener);
        btnD.setOnClickListener(answerClickListener);
    }

    private void resetButtonColors() {
        btnA.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        btnB.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        btnC.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        btnD.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
    }
}