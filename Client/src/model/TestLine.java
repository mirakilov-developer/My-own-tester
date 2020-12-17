package model;

public class TestLine {
    private final String testName;
    private final int numberOfQuestions;

    public TestLine(Test test) {
        testName = test.getName();
        numberOfQuestions = test.getQuestions().size();
    }

    public String getTestName() {
        return testName;
    }


    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
}
