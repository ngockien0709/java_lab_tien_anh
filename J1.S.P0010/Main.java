
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main mn = new Main();
        mn.doSearch();
    }

    public int inputArray(int mode) {
        int positive = 0;
        Scanner sc = new Scanner(System.in);
        if (mode == 1) {
            System.out.println("Enter number of array: ");
        } else {
            System.out.println("Enter search value: ");
        }

        while (positive <= 0) {
            try {
                positive = Integer.parseInt(sc.nextLine());
                if (positive <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                System.out.println("You must input a number greater than 0");
                System.out.println("Please enter again: ");
            }
        }

        return positive;
    }

    public void doSearch() {
        LinearSearch searcher = new LinearSearch();
        int[] array = searcher.generate(inputArray(1));
        System.out.print("The Array: ");
        searcher.displayArray(array);
        int search = inputArray(2);
        int foundIndex = searcher.linearSearch(array, search);
        if (foundIndex != -1) {
            System.out.println("\nFound " + search + " at index: " + foundIndex);
        } else {
            System.out.println("Not found");
        }
    }

}
