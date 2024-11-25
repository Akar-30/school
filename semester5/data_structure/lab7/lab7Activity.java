package semester5.data_structure.lab7;

import java.util.Scanner;

/*
 * GROUP 5:
 * CREW MEMBERS:
 * 1. AKAR HASSAN
 * 2. SANA LATIF
 * 3. MUHAMMAD JALAL
 * 4. MUSLIM MAHMOOD
 * 
 * 
 * PROBLEM: Sort a 2D array by using insertion sort algorithm --Ascending. 
 */

public class lab7Activity {

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

    public static char[] towDTo1d(char[][] arr2d) {
        int n = arr2d.length;
        int m = arr2d[0].length;
        char[] arr1d = new char[n * m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr1d[index++] = arr2d[i][j];
            }
        }
        return arr1d;
    }

    public static char[][] oneDTo2d(char[] arr1d, int n, int m) {
        char[][] arr2d = new char[n][m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr2d[i][j] = arr1d[index++];
            }
        }
        return arr2d;
    }

    public static void print2dArray(char[][] arr) {
        for (char[] i : arr) {
            for (char j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // GETTING ARRAY FROM USER
        System.out.print("Enter the number of rows: ");
        int n = input.nextInt();
        System.out.print("Enter the number of columns: ");
        int m = input.nextInt();
        char[][] arr2d = new char[n][m];
        System.out.println("Enter the elements of the array: \n\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("array at index " + i + " " + j + " is : ");
                arr2d[i][j] = input.next().charAt(0);
                System.out.println();
            }
        }

        // PROCESSING THE ARRAY
        System.out.println("The array before sorting: ");
        print2dArray(arr2d);
        char[] arr1d = towDTo1d(arr2d);
        insertionSort(arr1d);
        arr2d = oneDTo2d(arr1d, n, m);
        System.out.println("The array after sorting: ");
        print2dArray(arr2d);
        input.close();
    }
}
