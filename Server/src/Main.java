import model.Question;
import model.Test;
import service.TestLibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TestLibrary.fillTestLibrary();

        System.out.println("Enter tests size: ");
        int testsSize = scan.nextInt();

        for (int i = 0; i < testsSize; i++) {
            scan.nextLine();
            System.out.println("Enter name of test: ");
            String name = scan.nextLine();

            ArrayList<Question> questions = fillTest(scan);
            TestLibrary.addToLibrary(new Test(name, questions));
        }


        TestLibrary.saveLibrary();
    }

    private static ArrayList<Question> fillTest(Scanner scan) {
        ArrayList<Question> questions = new ArrayList<>();

        System.out.print("Enter size of question list: ");
        int length = scan.nextInt();
        System.out.println(" ");

        for (int i = 0; i < length; i++) {
            System.out.println((i + 1) + ":\nEnter text of question: ");
            scan.nextLine();
            String questionText = scan.nextLine();

            System.out.println("Enter size of variants: ");
            int sizeOfVariants = Integer.parseInt(scan.nextLine());

            System.out.println("Enter variants: (" + sizeOfVariants + ")");
            ArrayList<String> variantsList = new ArrayList<>();

            for (int j = 0; j < sizeOfVariants; j++) {
                System.out.print((j + 1) + ".) ");
                String e = scan.nextLine();

                variantsList.add(e);
            }

            System.out.println("\nEnter correct variant number: ");
            for (int j = 0; j < variantsList.size(); j++) {
                System.out.println((j + 1) + ".) " + variantsList.get(j));
            }

            String correctAnswer = variantsList.get(scan.nextInt() - 1);

            questions.add(new Question(questionText, correctAnswer, variantsList));

            System.out.println(" ");
        }

        return questions;
    }
}
