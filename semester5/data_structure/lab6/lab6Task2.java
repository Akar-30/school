package semester5.data_structure.lab6;

import java.util.Scanner;

/*
    2. Write a java program that allows the user to input this array
        {D, S, E, N, G, I, T, 2, 0, 2, 4}, then sort it by using Selection Sort algorithm
        a. Ascending.
        b. Descending.
 */
public class lab6Task2 {
    public static void descendingSelectionSort(char[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                // swap arr[i] and arr[maxIndex]
                arr[i] += arr[maxIndex];
                arr[maxIndex] = (char) (arr[i] - arr[maxIndex]);
                arr[i] -= arr[maxIndex];
            }
        }
    }

    public static void ascendingSelectionSort(char[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // swap arr[i] and arr[maxIndex]
                arr[i] += arr[minIndex];
                arr[minIndex] = (char) (arr[i] - arr[minIndex]);
                arr[i] -= arr[minIndex];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quit = 0;
        while (quit == 0) {
            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();
            char[] arr = new char[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the element at index " + i + ": ");
                arr[i] = scanner.next().charAt(0);
            }
            System.out.println("Your array:");
            for (char i : arr) {
                System.out.print(i + " ");
            }
            System.out.println("\n***********************************\n\n");
            while (quit == 0) {
                System.out.print("What do you want to do?\n1. Ascending\n2. Descending\n3. Exit\nEnter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        ascendingSelectionSort(arr);
                        System.out.println("Ascending sorted array:");
                        break;
                    case 2:
                        descendingSelectionSort(arr);
                        System.out.println("Descending sorted array:");
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        quit = 1;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                for (char i : arr) {
                    System.out.print(i + " ");
                }
                System.out.println("\n***********************************\n");
            }
            System.out.print("Do you want to try again?\n1. Yes\n2. No\nEnter your choice: ");
            int opt = scanner.nextInt();
            if (opt == 1) {
                quit = 0;
            }
        }

        scanner.close();
    }

}
