package matrix_tuanvm2;

public class Manager {
    
    // display menu
    public static int menu() {
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multi Matrix");
        System.out.println("4. Quit");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkIntLimit(1, 4);
        return choice;
    }

    // create matrix
    private static int[][] intputMatrix(int n) {
        System.out.print("Enter Row Matrix " + n + ": ");
        int row = Validation.checkInputSizeMatrix(n, 1, Integer.MAX_VALUE);
        System.out.print("Enter Colum Matrix " + n + ": ");
        int col = Validation.checkInputSizeMatrix(n, 1, Integer.MAX_VALUE);
        int[][] matrix = new int[row][col];
        // Create matrix 1 by double loop
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix " + n + " [" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                matrix[i][j] = Validation.checkInputMatrix(n, i, j);
            }
        }
        return matrix;
    }
    
    // display the matrix
    private static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    // Addition 2 matrixes
    public static void additionMatrix() {
        System.out.println("----- Addition matrix -----");
        int[][] matrix1 = intputMatrix(1);
        // loop until user enter size correctlys
        while (true) {
            // input size matrix 2
            System.out.print("Enter Row Matrix " + 2 + ": ");
            int row2 = Validation.checkInputSizeMatrix(1, 1, Integer.MAX_VALUE);
            System.out.print("Enter Colum Matrix " + 2 + ": ");
            int col2 = Validation.checkInputSizeMatrix(1, 1, Integer.MAX_VALUE);
            int[][] matrix2 = new int[row2][col2];
            //check size of 2 matrixes. If matching, add 2 matrixes. else re-input size
            if (Validation.checkAddSubMatrixes(matrix1, matrix2)) {
                // Create matrix 2 by double loop
                for (int i = 0; i < row2; i++) {
                    for (int j = 0; j < col2; j++) {
                        System.out.print("Enter Matrix " + 2 + " [" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                        matrix2[i][j] = Validation.checkInputMatrix(1, i, j);
                    }
                }
                // display addition
                System.out.println("----- Result -----");
                displayMatrix(matrix1);
                System.out.println("+");
                displayMatrix(matrix2);
                System.out.println("=");
                int row = matrix1.length;
                int col = matrix1[0].length;
                // display total 2 matrices   
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        System.out.print("[" + (matrix1[i][j] + matrix2[i][j]) + "]");
                    }
                    System.out.println();
                }
                return;
            }
        }

    }

    //subtraction 2 matrixes
    public static void subtractionMatrix() {
        System.out.println("----- Subtraction matrix -----");
        // input size matrix 1
        int[][] matrix1 = intputMatrix(1);
        // loop until user enter size correctlys
        while (true) {
            System.out.print("Enter Row Matrix " + 2 + ": ");
            int row2 = Validation.checkInputSizeMatrix(1, 1, Integer.MAX_VALUE);
            System.out.print("Enter Colum Matrix " + 2 + ": ");
            int col2 = Validation.checkInputSizeMatrix(1, 1, Integer.MAX_VALUE);
            int[][] matrix2 = new int[row2][col2];
            //check size of 2 matrixes. If matching, add 2 matrixes. else re-input size
            if (Validation.checkAddSubMatrixes(matrix1, matrix2)) {
                // Create matrix 2 by double loop
                for (int i = 0; i < row2; i++) {
                    for (int j = 0; j < col2; j++) {
                        System.out.print("Enter Matrix " + 2 + " [" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                        matrix2[i][j] = Validation.checkInputMatrix(1, i, j);
                    }
                }
                // display subtraction
                System.out.println("----- Result -----");
                displayMatrix(matrix1);
                System.out.println("-");
                displayMatrix(matrix2);
                System.out.println("=");
                int row = matrix1.length;
                int col = matrix1[0].length;
                // display 2 matrix signals
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        System.out.print("[" + (matrix1[i][j] - matrix2[i][j]) + "]");
                    }
                    System.out.println();
                }
                return;
            }
        }
    }

    // multiplication of 2 matrices
    public static void multiplicationMatrix() {
        System.out.println("----- Multipication matrix -----");
        // input size matrix 1
        int[][] matrix1 = intputMatrix(1);
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        //If the import does not match the size, re-enter it until you enter it correctly
        while (true) {
            // input size matrix 2
            System.out.print("Enter Row Matrix " + 2 + ": ");
            int row2 = Validation.checkInputSizeMatrix(1, 1, Integer.MAX_VALUE);
            System.out.print("Enter Colum Matrix " + 2 + ": ");
            int col2 = Validation.checkInputSizeMatrix(1, 1, Integer.MAX_VALUE);
            int[][] matrix2 = new int[row2][col2];

            //Check conditions for multiplying 2 matrices (column matrix 1 = row matrix 2)
            if (col1 == row2) {
                // Create matrix by double loop
                for (int i = 0; i < row2; i++) {
                    for (int j = 0; j < col2; j++) {
                        System.out.print("Enter Matrix " + 2 + " [" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                        matrix2[i][j] = Validation.checkInputMatrix(1, i, j);
                    }
                }
                // display multiplication
                System.out.println("----- Result -----");
                displayMatrix(matrix1);
                System.out.println("*");
                displayMatrix(matrix2);
                System.out.println("=");
                // create a result matrix 
                int[][] matrixResult = new int[row1][col2];
                for (int i = 0; i < row1; i++) {
                    for (int j = 0; j < col2; j++) {
                        matrixResult[i][j] = 0;
                    }
                }
                // result(i,j) = (ma1)i1*(ma2)j1+(ma1)i2*(ma2)j2+... (ma1)in*(ma2)jn
                for (int i = 0; i < row1; i++) {
                    for (int j = 0; j < col2; j++) {
                        for (int k = 0; k < col1; k++) {
                            matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                        }
                    }
                }
                displayMatrix(matrixResult);
                return;
            } else {
                System.err.println("Multiplication 2 matrixes must have column1 = row 2");
            }

        }
    }

}
