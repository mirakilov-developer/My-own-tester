package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question {
    private List<String> variants;
    private String questionText;
    private int correctVariant;

    public Question(Question question) {
        this.questionText = question.questionText;
        this.variants = question.variants;
        this.correctVariant = question.correctVariant;
    }

    public Question(String questionText, String correctVariant, List<String> variants) {
        if (variants.size() == 0) try {
            throw new Exception("variants arr is empty");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        this.variants = new ArrayList<>();
        this.questionText = questionText;
        for (String variant : variants) {
            if (!this.variants.contains(variant)) this.variants.add(variant);
        }

        this.correctVariant = this.variants.indexOf(correctVariant);
    }

    public List<String> getVariants() {
        return variants;
    }

    public void setVariants(List<String> variants) {
        this.variants = variants;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCorrectVariantStr() {
        return variants.get(correctVariant);
    }

    public int getCorrectVariant() {
        return correctVariant;
    }

    public void setCorrectVariant(int correctVariant) {
        this.correctVariant = correctVariant;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append("\t\tQuestion: ").append(questionText).append("\n");
        res.append("\t\tVariants size: ").append(variants.size()).append("\n");
        res.append("\t\tCorrect variant index: ").append(correctVariant + 1).append("\n");
        for (int i = 0; i < variants.size(); i++) {
            res.append("\t\t\t").append(i+1).append(": ").append(variants.get(i)).append("\n");
        }

        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;
        if (question.getVariants().isEmpty()) return false;
        boolean res = true;

        for (int i = 0; i < variants.size(); i++) {
            if (!this.variants.get(i).equals(question.getVariants().get(i))) {
                res = false;
                break;
            }
        }

        return questionText.equals(question.questionText) && res;
    }

    public boolean equals(Question otherQue) {
        if (otherQue == null || otherQue.getVariants().isEmpty()) return false;
        return true;

        //        return answerVariant == question.answerVariant && Objects.equals(variants, question.variants) && questionText.equals(question.questionText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variants, questionText, correctVariant);
    }
}
