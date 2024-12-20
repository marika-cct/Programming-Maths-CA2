import java.util.InputMismatchException;
import java.util.Scanner;

// https://github.com/marika-cct/Programming-Maths-CA2

public class Task2 {
    public static void main(String[] args) {
        // I am using the scanner class to take and use user input
        Scanner scanner = new Scanner(System.in);
        // Creating a variable we will store user input
        int n = 0;
        // Creating a boolean variable for my error handling
        boolean correctInput = false;

        // Using loop to keep asking for correct user input. And using try and catch to make sure the correct
        // input is given and if so, we can leave the loop, otherwise we catch the exception and ask for input again...
        while (!correctInput) {
            try {
                // Asking user to input their desired array size
                System.out.print("Enter a size for your array: ");
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

        // Initialising a 2D array (of type int) of size n (row and column) that we got from user
        int[][] tableArray = new int[n][n];

        // I am looping through the nxn 2D array, first row (int r) the column (int c) level, and I am
        // populating the empty 2D array with the outcome of r and c. I am doing [r-1] and [c-1] to access
        // the first index 0, since I initialised r and c as 1. I did that so the multiplication table starts
        // at 1 and ends at n, and not starting at 0 and ending at n-1.
        for (int r = 1; r <= n; r++){
            for (int c = 1; c <= n; c++){
                tableArray[r-1][c-1] = r * c;
            }
        }

        // Here I am simply accessing the newly populated 2D array and printing each element, so that it displays
        // as a multiplication table. I have achieved that effect by using print in the inner for, to make all the
        // printed elements be on the same line with a tab between, and on the outer for, I am using system our println
        // to make the row sit on a new line.
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                System.out.print(tableArray[r][c] + "\t");
            }
            System.out.println();
        }

        // closing scanner
        scanner.close();
    }
}
