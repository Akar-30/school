package semester5.data_structure.lab5;

/*

1.  Write a java program sort this array {100, -2, 39,45,87, 9, -6, 0} use
    Bubble Sort algorithm (Ascending Order).
2.  Write a java program sort this array {100, -2, 39,45,87, 9, -6, 0} use
    Bubble Sort algorithm (Descending Order).
3.  Write a Java program that allows the user to input this an array
    {‘K’, ‘R’, ‘D’, ‘A’, ‘S’,’U’,’N’,’T’,’N’,’R’,’I’,’G’,’E’,’O’}, sorts it
    using the bubble sort algorithm (Ascending), and then displays the
    sorted array in the console.
    Output should be like this example:
    Enter the number of letters: 3
    Enter the letters: c a b
    Sorted letters: a b c
 */

public class lab5Task1 {
    public static void ascendingBubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j + 1]
                    arr[j] += arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] -= arr[j + 1];
                }
            }
        }
    }

    public static void descendingBubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // swap arr[j] and arr[j + 1]
                    arr[j] += arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] -= arr[j + 1];
                }
            }
        }
    }

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
        int[] arr = { 100, -2, 39, 45, 87, 9, -6, 0 };
        System.out.println("Original array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        ascendingBubbleSort(arr);
        System.out.println("\n\nAscending sorted array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        descendingBubbleSort(arr);
        System.out.println("\n\nDescending sorted array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        char[] arrChar = { 'K', 'R', 'D', 'A', 'S', 'U', 'N', 'T', 'N', 'R', 'I', 'G', 'E', 'O' };
        System.out.println("\n\nOriginal array:");
        for (int i = 0; i < arrChar.length; i++) {
            System.out.print(arrChar[i] + " ");
        }
        ascendingBubbleSortChar(arrChar);
        System.out.println("\n\nAscending sorted array:");
        for (int i = 0; i < arrChar.length; i++) {
            System.out.print(arrChar[i] + " ");
        }
    }
}
