package Validate_and_InputData;

import java.util.Scanner;

public class InputData {

    //contain alphabet and space
    public static final String AlphaBet = "[a-zA-Z\\s]+";

    //contain apphabet, number from 1-9 and space
    public static final String AlphaBetNumber = "[a-zA-Z0-9\\s]+";

    //input integer number
    public static int inputIntegerNumber(int min, int max, String message) {
        Scanner in = new Scanner(System.in);
        int number;
        String checkEmpty;
        //if uses input positive decimal number, exit loop else continue
        while (true) {
            try {
                System.out.print(message);
                checkEmpty = in.nextLine().trim();

                //check String after remove space is empty or not
                if (checkEmpty.isEmpty()) {
                    System.out.println("You input nothing. Try again!");
                    continue;
                }
                number = Integer.parseInt(checkEmpty);
                //check povitive decimal number
                if (number < min || number > max) {
                    System.err.printf("Number must be in range [%d-%d]. Try again!\n",
                            min, max);
                    continue;
                }
                return number;
            } catch (NumberFormatException ex) {
                System.err.println("Number must not contain any character. Try again!");
            }
        }
    }

    //input data and check with regular expression
    public static String inputWord(String regex, String message, String error) {
        Scanner in = new Scanner(System.in);
        String word;
        //if uses input positive decimal number, exit loop else continue
        while (true) {
            System.out.print(message);
            word = in.nextLine().trim();
            //check String after remove space is empty or not
            if (word.isEmpty()) {
                System.err.println("You input nothing. Try again!");
                continue;
            }
            //check between any true word in have more than one space
            while (word.contains("  ")) {
                //change two spaces to one space
                word = word.replaceAll("  ", " ");
            }
            //check data with regular expression
            if (word.matches(regex)) {
                return word;
            } else {
                System.out.println(error);
            }
        }
    }
}
