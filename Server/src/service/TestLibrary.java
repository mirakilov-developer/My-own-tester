package service;

import model.Question;
import model.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestLibrary {
    private static final ArrayList<Test> testLibrary = new ArrayList<>();
    private static final File libraryFile = new File("E:\\I_am_back\\Tester\\Server\\src\\resources\\library.txt");

    public static void fillTestLibrary() {
        try (Scanner scanner = new Scanner(libraryFile)) {
            ArrayList<Test> tests = new ArrayList<>();
            int testsSize = Integer.parseInt(scanner.nextLine().substring(12));

            for (int i = 0; i < testsSize; i++) {
                scanner.nextLine();
                scanner.nextLine();
                scanner.nextLine();

                String testName = scanner.nextLine().trim().substring(14);
                int questionsSize = Integer.parseInt(scanner.nextLine().trim().substring(16));
                ArrayList<Question> questions = new ArrayList<>();

                for (int j = 0; j < questionsSize; j++) {
                    scanner.nextLine();
                    scanner.nextLine();

                    String questionText = scanner.nextLine().trim().substring(10);
                    int variantsSize = Integer.parseInt(scanner.nextLine().trim().substring(15));
                    int correctVariantIndex = Integer.parseInt(scanner.nextLine().trim().substring(23)) - 1;
                    ArrayList<String> variants = new ArrayList<>();
                    String correctVariant = "";

                    for (int k = 0; k < variantsSize; k++) {
                        String variant = scanner.nextLine().trim().substring(((k + 1) / 10) + 3);
                        if (k == correctVariantIndex) correctVariant = variant;

                        variants.add(variant);
                    }

                    questions.add(new Question(questionText, correctVariant, variants));
                }

                tests.add(new Test(testName, questions));
            }

            testLibrary.addAll(tests);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getLibrarySize(){
        return testLibrary.size();
    }

    public static Test getTestFromIndex(int index) {
        return testLibrary.get(index);
    }

    public static Test getTestFromName(String name) {
        for (Test test : testLibrary) {
            if (test.getName().equals(name)) return test;
        }
        return null;
    }

    public static void addToLibrary(Test test) {
        testLibrary.add(test);
    }

    public static void saveLibrary() {
        try (FileWriter writer = new FileWriter(libraryFile)) {
            writer.write(textTypeOfTests());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String textTypeOfTests() {
        StringBuilder text = new StringBuilder();

        text.append("Tests size: ").append(TestLibrary.testLibrary.size()).append("\n\n\n");

        for (int i = 0; i < TestLibrary.testLibrary.size(); i++) {

            text.append("Test number ").append(i + 1).append("\n");
            text.append(TestLibrary.testLibrary.get(i).toString()).append("\n");
        }
        return text.toString();
    }
}
