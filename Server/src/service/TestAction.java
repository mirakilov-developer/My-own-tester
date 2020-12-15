package service;

import com.sun.tools.javac.Main;
import model.Answer;
import model.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestAction {
    private Test test;
    private List<Answer> answers;

    public TestAction(int testNumber) {
        this.test = TestLibrary.getTestFromIndex(testNumber);
    }

    public int doTest(Map<Integer, String> map){
        int counter = 0;

        answers = new ArrayList<>();

        for (Map.Entry<Integer, String> el: map.entrySet()) {
            Answer answer = new Answer(test.getQuestions().get(el.getKey()), el.getValue());
            answers.add(answer);
        }

        for (Answer a: answers){
            if (a.isCorrect()) counter++;
        }

        return counter;
    }
}
