package semester5.data_structure.lab7;

/*
A java program that get inputs (char) from a user, then sort it by insertion algorithm. 
 */

import java.util.Scanner;

public class lab7Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        char[] arr = new char[size];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.next().charAt(0);
        }
        System.out.println("The array before sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        insertionSort(arr);
        System.out.println("The array after sorting --Ascending: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        insertionDescendingSort(arr);
        System.out.println("The array after sorting --Descending: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        input.close();
    }

    public static void insertionSort(char[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            char currentElement = arr[i];
            int k = i - 1;
            while (k >= 0 && arr[k] > currentElement) {
                arr[k + 1] = arr[k];
                k--;
            }
            arr[k + 1] = currentElement;
        }

    }

    public static void insertionDescendingSort(char[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            char currentElement = arr[i];
            int k = i - 1;
            while (k >= 0 && arr[k] < currentElement) {
                arr[k + 1] = arr[k];
                k--;
            }
            arr[k + 1] = currentElement;
        }
    }

    public static void printArray(char[] arr) {
        for (char i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}