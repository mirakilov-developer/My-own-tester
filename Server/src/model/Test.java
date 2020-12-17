package model;

import java.util.*;

public class Test {
    private List<Question> questions;
    private String name;

    public Test(String name, List<Question> questions) {
        this.name = name;
        this.questions = deleteDuplicates(questions);
    }



    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = deleteDuplicates(questions);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static ArrayList<Question> deleteDuplicates(List<Question> questions) {
        Set<Question> set = new LinkedHashSet<>(questions);
        return new ArrayList<>(set);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append("\tName of test: ").append(name).append("\n");
        res.append("\tQuestions size: ").append(questions.size()).append("\n\n");
        for (int i = 0; i < questions.size(); i++) {
            res.append("\t").append("Question number ").append(i+1).append("\n");
            res.append(questions.get(i).toString()).append("\n");
        }

        return res.toString();
    }
}
