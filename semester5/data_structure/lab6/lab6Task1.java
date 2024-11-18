package semester5.data_structure.lab6;

/*
 * Write a java program sort an array (named arr1, size of arr1 is 10,
   filled with random number less than 30, sort arr1 by using Selection
   Sort algorithm (Descending Order).
 */
public class lab6Task1 {
    public static void descendingSelectionSort(int[] arr) {
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
                arr[maxIndex] = arr[i] - arr[maxIndex];
                arr[i] -= arr[maxIndex];
            }
        }
    }

    public static void ascendingSelectionSort(int[] arr) {
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
                arr[minIndex] = arr[i] - arr[minIndex];
                arr[i] -= arr[minIndex];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[10];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (Math.random() * 30);
        }
        System.out.println("Before sorting:");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
        descendingSelectionSort(arr1);
        System.out.println("After sorting:");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
        ascendingSelectionSort(arr1);
        System.out.println("After sorting:");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
