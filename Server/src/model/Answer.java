package model;

import java.util.List;

public class Answer {
    private final Question question;
    private final String answerText;
    private boolean isCorrect = false;

    public Answer(Question question, String answerText) {
        this.question = question;
        this.answerText = answerText;

        List<String> questionVariants = question.getVariants();

        if (question.getVariants().contains(this.answerText))
            if (questionVariants.indexOf(this.answerText) == question.getCorrectVariant()) isCorrect = true;
    }


    public Question getQuestion() {
        return question;
    }

    public String getQuestionText() {
        return question.getQuestionText();
    }

    public String getAnswerText() {
        return answerText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
