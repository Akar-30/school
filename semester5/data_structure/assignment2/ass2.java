package semester5.data_structure.assignment2;

import java.util.Scanner;

/*
Assignment2: 
Write a Java program that allows you to input this array {"your 1st name", "your 2nd name", "your 3rd name", "your Department"},
then sort it by using Selection Sort algorithm a. Ascending. b. Descending.submit the java file here, try to understand each line of code,
I will ask you question about it next lecture.

output will be like this:
Enter the elements of the array (separated by space):
Bakhan Tofiq Ahmed Software.Engineering
Array sorted in ascending order:
Ahmed Bakhan Software.Engineering Tofiq
Array sorted in descending order:
Tofiq Software.Engineering Bakhan Ahmed

 */

public class ass2 {
    public static void descendingSelectionSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareToIgnoreCase(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                // swap arr[i] and arr[maxIndex]
                String temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }

    public static void ascendingSelectionSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareToIgnoreCase(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // swap arr[i] and arr[maxIndex]
                String temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quit = 0;
        while (quit == 0) {
            int n = 4;
            String[] arr = new String[n];
            System.out.print("Enter Your First Name: ");
            arr[0] = scanner.nextLine();
            System.out.print("Enter Your Second Name: ");
            arr[1] = scanner.nextLine();
            System.out.print("Enter Your Third Name: ");
            arr[2] = scanner.nextLine();
            System.out.print("Enter Your Department: ");
            arr[3] = scanner.nextLine();
            System.out.println("Your information:");
            for (String i : arr) {
                System.out.print(i + " ");
            }
            System.out.println("\n***********************************\n\n");
            while (quit == 0) {
                System.out.print("What do you want to do?\n1. Ascending\n2. Descending\n3. Exit\nEnter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        ascendingSelectionSort(arr);
                        System.out.println("\n\nAscending sorted array:\n--------------------------------");
                        break;
                    case 2:
                        descendingSelectionSort(arr);
                        System.out.println("\n\nDescending sorted array:\n--------------------------------");
                        break;
                    case 3:
                        System.out.println("\n\nExiting...");
                        quit = 1;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                for (String i : arr) {
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
