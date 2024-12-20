import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Task1 {
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
        while (!correctInput){
            try {
                // Asking user to input their desired array size
                System.out.print("Enter desired array size: ");
                // Using scanner.nextInt() I am saving the next int input from the user as the variable n
                n = scanner.nextInt();
                // Once the correct input is given we can set correctInput as true to leave the loop
                correctInput = true;
            }
            catch (InputMismatchException e){
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
                System.out.print("Enter " + n + " elements for your array each on single line: ");
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

        // creating a variable for the firstRepeat function result. The result of this will either be -1 or
        // the number that was repeated first.
        int answer = firstReapt(userArray, n);

        // I am using an if to send the appropriate message for the given result
        if (answer == -1 ){
            System.out.println("There was no duplicates!");
        }
        else {
            System.out.printf("The first array duplicate is " + answer);
        }

        // closing scanner
        scanner.close();
    }

    // This is the method that does the logic behind finding the first repeating element of a given array
    // I am using set, which is a collection interface, and it represents a collection of unique elements
    // which make it very simple to find any repeat elements, making it perfect for this solution.
    private static int firstReapt(int[] a, int n) {
        // First I am creating int set object, calling it set.
        Set<Integer> set = new HashSet<Integer>();

        // I am iterating through the array that is given as an argument in the method, and trying to add
        // each element into the set, but if the element already exists it will return false, therefore in
        // if I am looking for a false response (!set.add...), if the statement is false, return the element
        // a[i] as the first repeat.
        for (int i = 0; i < n; i++){
            if (!set.add(a[i])) {
                return a[i];
            }
        }
        // If there are no repeats we automatically return -1
        return -1;
    }
}
