import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task4 {
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
        System.out.println("The spiral traverse order: " + Arrays.toString(spiralArray(squareMatrix, n)));

        // closing scanner
        scanner.close();
    }

    public  static int[] spiralArray(int[][] a, int n){
        // Creating an array to hold the spiral results as an array, the size of the array will be n x n
        int[] spiralResult = new int[n * n];
        // Creating a varible that will keep track of the current position in the result array
        int index = 0;
        // Creating variables to correlate to the side of the matrix storing the index I am on for calculations below
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        // While the top index is the same or less than the bottom, and left is the same or less as the right, I am
        // looping through the 2D array that is input through the parameters of the method (int[][] a), and inserting the
        // current element into our new spiral result array.
        while (top <= bottom && left <= right) {
            // I am first traversing from left to right across the top row, saving the elements from the top row into my
            // spiral result array
            for (int i = left; i <= right; i++) {
                spiralResult[index++] = a[top][i];
            }
            // I am incrementing top variable to cover all the top index elements in the 2d array
            top++;

            // Traversing from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                spiralResult[index++] = a[i][right];
            }
            // I am incrementing right variable like I did above.
            right--;

            // We are now going into the "inside" of the spiral, but first we need to check if the matrix is big enough
            // to do so, checking if the top var is still less or equal to bottom
            if (top <= bottom) {
                // Traversing from right to left across the bottom row.
                for (int i = right; i >= left; i--) {
                    spiralResult[index++] = a[bottom][i];
                }
                // This is repeating for all 4 directions, I am incrementing the bottom variable here
                bottom--;
            }

            // Again we ae going deeper into the spiral, first checking if the matrix is big enough
            // to do so, checking if the left var is still less or equal to right
            if (left <= right) {
                // Traversing from bottom to top along the left column.
                for (int i = bottom; i >= top; i--) {
                    spiralResult[index++] = a[i][left];
                }
                // I am incrementing the left variable here. Top ''', right '''|, bottom ___|, left |___, going in a
                // spiral pattern.
                left++;
            }
        }

        // At the end, we return the spiral result array, so we can use it in our main method to display the result to
        // the user
        return spiralResult;
    }
}
