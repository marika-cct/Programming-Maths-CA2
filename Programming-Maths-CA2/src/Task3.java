import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        // I am using the scanner class to take and use user input
        Scanner scanner = new Scanner(System.in);
        // Creating a variable we will store user input
        int n = 0;
        // Creating a boolean variable for my error handling
        boolean correctInput = false;
        boolean correctValues = false;

        // Using loop to keep asking for correct user input. And using try and catch to make sure the correct
        // input is given and if so, we can leave the loop, otherwise we catch the exception and ask for input again...
        while (!correctInput) {
            try {
                // Asking user to input their desired array size
                System.out.print("Enter desired squared matrix size: ");
                // Using scanner.nextInt() I am saving the next int input from the user as the variable n
                n = scanner.nextInt();
                // Once the correct input is given we can set correctInput as true to leave the loop
                correctInput = true;
            } catch (InputMismatchException e) {
                System.out.println("That's not a valid number, please try again.");
                // I am clearing the input that was invalid
                scanner.next();
            }
        }

        // Initialising an array (of type int) of size n that we got from user
        int[][] squareMatrix = new int[n][n];

        // Using loop to keep asking for correct user input. And using try and catch to make sure the correct
        // input is given and if so, we can leave the loop, otherwise we catch the exception and ask for input again...
        while (!correctValues) {
            try {
                // Just like above, I am asking the user to input the elements of their array
                System.out.print("Enter " + n + " elements for your squared matrix each on single line: ");
                // Here I am iterating through the response from the user and setting each of the numbers input as
                // elements of my 2D array. The first for is iterating through the row and the inner for is for the
                // column level, saving each element by element.
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        squareMatrix[r][c] = scanner.nextInt();
                    }
                }
                // Once the correct input is given we can set correctInput as true to leave the loop
                correctValues = true;
            } catch (InputMismatchException e) {
                System.out.println("That's not a valid number, please try again.");
                // I am clearing the input that was invalid
                scanner.next();
            }
        }

        // Printing the results to the user, using my two methods that calculate the main and secondary diagonals.
        System.out.println("The sum of the main diagonal elements is: " + mainDiagonalCalc(squareMatrix, n) + "\n" +
                "The sum of the secondary diagonal elements is: " + secondaryDiagonalCalc(squareMatrix, n));

        // closing scanner
        scanner.close();
    }

    private static int mainDiagonalCalc(int[][] a, int n) {
        // Creating a variable I will be using to calculate and store the main diagonal
        int mainDiag = 0;
        // I am iterating through the array that is given as an argument in the method, and I am iterating in one layer,
        // so I can access only the following elements in the array a[i][i], a[i+1][i+1], a[i+2][i+2] ... until I reach
        // a[n-1][n-1], which will yield me the main diagonal elements of the matrix array. Inside the loop I am adding the
        // element into the created variable, and at the end I return that variable as the main diagonal sum.
        for (int i = 0; i < n; i++){
            mainDiag += a[i][i];
        }
        return mainDiag;
    }

    private static int secondaryDiagonalCalc(int[][] a, int n) {
        // Creating a variable I will be using to calculate and store the secondary diagonal
        int secondaryDiag = 0;
        // Juts like above I am iterating through the array that is given as an argument in the method, and I am
        // iterating in one layer, so I can access only the following elements in the array a[n-1][n-1], a[n-2][n-3],
        // a[n-3][n-3] ... until I reach a[n-n][n-n], which will yield me the secondary diagonal elements of the matrix
        // array. Inside the loop I am adding the element into the created variable, and at the end I return that
        // variable as the secondary diagonal sum.
        for (int i = n-1; i >= 0; i--){
            secondaryDiag += a[i][i];
        }
        // If there are no repeats we automatically return -1
        return secondaryDiag;
    }
}
