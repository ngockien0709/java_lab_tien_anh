package matrix_tuanvm2;

import java.util.Scanner;

public class Validation {
    // check input limit
    public static int checkIntLimit(int min, int max) {
        Scanner in = new Scanner(System.in);
        // loop until user input correctly
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine().trim());
                if (n >= min && n <= max) {
                    return n;
                } else {
                    System.err.println("You can only choose from options " + min + " to " + max);
                System.out.print("Enter your choice: ");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Invalid number");
                System.out.print("Enter your choice: ");
            }
        }
    }
    
    public static int checkInputSizeMatrix(int m,int min, int max) {
        Scanner in = new Scanner(System.in);
        // loop until user input correctly
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine().trim());
                if (n >= min && n <= max) {
                    return n;
                } else {
                    System.err.println("The size of the matrix must be an integer and greater than 0");
                System.out.print("Enter Row Matrix " + m + ": ");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Invalid number");
                System.out.print("Enter Row Matrix " + m + ": ");
            }
        }
    }
    // check input Integer number
    public static int checkInputMatrix(int n,int i,int j) {
        Scanner in = new Scanner(System.in);
        // loop until user input correctly
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Values of matrix is digit");
                System.out.print("Enter Matrix " + n + " [" + (i+1) + "]" + "[" + (j+1) + "]:");
            }
        }

    }
// Check 2 matrices of the same size

    public static boolean checkAddSubMatrixes(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        if (col1 == col2 && row1 == row2) {
            return true;
        } else {
            System.err.println("Can't calculator");
            System.err.println("2 matrices must be the same size");
            return false;
        }
    }

}
