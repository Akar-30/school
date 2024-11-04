package semester5.data_structure.lab5;

import java.util.Scanner;

/*
 * 3.   Write a Java program that allows the user to input this an array
        {‘K’, ‘R’, ‘D’, ‘A’, ‘S’,’U’,’N’,’T’,’N’,’R’,’I’,’G’,’E’,’O’}, sorts it
        using the bubble sort algorithm (Ascending), and then displays the
        sorted array in the console.
        Output should be like this example:
        Enter the number of letters: 3
        Enter the letters: c a b
        Sorted letters: a b c
 */
public class lab5Task3 {

    public static void ascendingBubbleSortChar(char[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j + 1]
                    arr[j] += arr[j + 1];
                    arr[j + 1] = (char) (arr[j] - arr[j + 1]);
                    arr[j] -= arr[j + 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the number of letters:");
        int n = scanner.nextInt();
        char[] input = new char[n];
        System.out.println("Enter the letters:");
        for (int i = 0; i < n; i++) {
            input[i] = scanner.next().charAt(0);
        }

        ascendingBubbleSortChar(input);

        System.out.println("\nSorted letters:");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        scanner.close();
    }
}
