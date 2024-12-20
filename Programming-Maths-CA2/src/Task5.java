import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

// https://github.com/marika-cct/Programming-Maths-CA2

public class Task5 {
    public static void main(String[] args) {
        // I am using the scanner class to take and use user input
        Scanner scanner = new Scanner(System.in);
        // Creating a variable we will store user input
        int n = 0;
        // Creating a boolean variables for my error handling
        boolean correctInput = false;
        boolean correctValues = false;

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

        // Initialising an array (of type int) of size n that we got from user
        int[] userArray = new int[n];

        // Using loop to keep asking for correct user input. And using try and catch to make sure the correct
        // input is given and if so, we can leave the loop, otherwise we catch the exception and ask for input again...
        while (!correctValues){
            try{
                // Just like above, I am asking the user to input the elements of their array
                System.out.print("Enter " + n + " elements for your array on one line with space between them: ");
                // Here I am iterating through the response from the user and setting each of the numbers input as
                // elements of the array. The user needs to input a number per line.
                for (int i = 0; i < n; i++){
                    userArray[i] = scanner.nextInt();
                }
                // Once the correct input is given we can set correctInput as true to leave the loop
                correctValues = true;
            }
            catch (InputMismatchException e){
                System.out.println("That's not a valid number, please try again.");
                // I am clearing the input that was invalid
                scanner.next();
            }
        }

        // Calling the print array method I created to print the unsorted array
        System.out.print("Unsorted array: ");
        printArray(userArray);

        // Creating an object array to store the result from the bubble sort method
        Object[] result = bubbleSort(userArray, n);

        // Here I am extracting the two items in the object array, first (Object[0]) the sorted array, which I had to
        // cast to an int array. Second (Object[1]) I am extracting the swap count, and casting to an int.
        int[] sortedUserArray = (int[]) result[0];
        int swapCount = (int) result[1];

        // Printing results to user
        System.out.println("Sorted array: " + Arrays.toString(sortedUserArray) + "\n" + "Amount of swaps: " + swapCount);

        // closing scanner
        scanner.close();
    }

    // Simple method to print the unsorted array
    private static void printArray(int[] a){
        System.out.println(Arrays.toString(a));
    }

    // I created a method that returns an object array, and takes in 2 params, an array, and an int.
    private static Object[] bubbleSort(int[] a, int n) {
        // Initialising my variables for checking with boolean if a swap was made, and an int to count the amount of
        // swaps happening.
        boolean swapped;
        int countSwaps = 0;

        // Firstly I am using a for loop to control how many times we have to loop through the inner for, only allowing
        // for max n - 1 loop amount.
        for (int i = 0; i < n - 1; i++) {
            // setting my swapped boolean as false as we have yet to have swapped any elements of the array.
            swapped = false;

            // This is the loop that iterates through the array, to sort the elements in ascending order
            for (int j = 0; j < n - i - 1; j++) {
                // While iterating through the array we are checking if the first of two elements, is larger than the
                // second element of the two.
                if (a[j] > a[j + 1]) {
                    // I am assigning the first element of the couple, to a variable to perform the swap of their spaces
                    // in the array
                    int swappedNum = a[j];

                    // Assigning the second element as the first, if the first element is larger
                    a[j] = a[j + 1];

                    // Assigning the first element I saved in the variable above, as the second element of the couple.
                    a[j + 1] = swappedNum;

                    // There was a swap happening, so we assign the boolean var as true
                    swapped = true;

                    // I am incrementing the count swaps for the result at the end
                    countSwaps++;
                }
            }

            // If no two elements were swapped by inner loop, then break the code
            if (!swapped){
                break;
            }
        }
        // Returning the object array with the sorted array as [0], and the swap count as [1]
        return new Object[] {a, countSwaps};
    }
}
