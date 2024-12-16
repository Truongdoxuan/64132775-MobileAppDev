package th.doxuantruong.quizappfullcode;

import java.util.ArrayList;

public class Questions {
    private ArrayList<String> questionText;
    private ArrayList<String> answers;
    private int correctAnswerIndex;

    public Questions(ArrayList<String> questionText, ArrayList<String> answers, int correctAnswerIndex) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public ArrayList<String> getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    // Phương thức để khởi tạo danh sách câu hỏi
    public static void initializeQuestions() {
        // Danh sách câu hỏi cho C
        ArrayList<Questions> dsCauHoiC = new ArrayList<>();
        ArrayList<String> questionTextC = new ArrayList<>();
        questionTextC.add("What is the output of the following C code?");
        questionTextC.add("int x = 5; printf('%d', x);");

        ArrayList<String> answersC = new ArrayList<>();
        answersC.add("5");
        answersC.add("x");
        answersC.add("Error");
        answersC.add("None of the above");

        dsCauHoiC.add(new Questions(questionTextC, answersC, 0)); // Đáp án đúng là A (chỉ số 0)

        // Danh sách câu hỏi cho Java
        ArrayList<Questions> dsCauHoiJava = new ArrayList<>();
        ArrayList<String> questionTextJava = new ArrayList<>();
        questionTextJava.add("Which method is the entry point in a Java application?");
        questionTextJava.add("public static void main(String[] args)");

        ArrayList<String> answersJava = new ArrayList<>();
        answersJava.add("main method");
        answersJava.add("start method");
        answersJava.add("run method");
        answersJava.add("None of the above");

        dsCauHoiJava.add(new Questions(questionTextJava, answersJava, 0)); // Đáp án đúng là A (chỉ số 0)

        // Danh sách câu hỏi cho Python
        ArrayList<Questions> dsCauHoiPython = new ArrayList<>();
        ArrayList<String> questionTextPython = new ArrayList<>();
        questionTextPython.add("Which function is used to output data in Python?");
        questionTextPython.add("print('Hello World!')");

        ArrayList<String> answersPython = new ArrayList<>();
        answersPython.add("print()");
        answersPython.add("echo()");
        answersPython.add("output()");
        answersPython.add("printf()");

        dsCauHoiPython.add(new Questions(questionTextPython, answersPython, 0)); // Đáp án đúng là A (chỉ số 0)

    }
}
