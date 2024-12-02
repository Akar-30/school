/*
 * Write a java program to sort a 2D array of prime numbers that is sorted by merge algorithm --Descending
 */

package semester5.data_structure.lab8;

public class lab8Acrivity {

    // merging method

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] >= r[j]) { // Change comparison to descending
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static int[] towDTo1d(int[][] arr2d) {
        int n = arr2d.length;
        int m = arr2d[0].length;
        int[] arr1d = new int[n * m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr1d[index++] = arr2d[i][j];
            }
        }
        return arr1d;
    }

    public static int[][] oneDTo2d(int[] arr1d, int n, int m) {
        int[][] arr2d = new int[n][m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr2d[i][j] = arr1d[index++];
            }
        }
        return arr2d;
    }

    public static void print2dArray(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] primes = {
                { 37, 31, 29, 23 },

                { 19, 17, 13, 11 },

                { 7, 5, 3, 2 },

                { 43, 29, 31, 37 }
        };

        int row = primes.length;
        int columns = primes[0].length;

        System.out.println("BEFORE SORTING");
        print2dArray(primes);

        int[] arr1D = towDTo1d(primes);
        mergeSort(arr1D, arr1D.length);

        primes = oneDTo2d(arr1D, row, columns);

        System.out.println("AFTER SORTING");
        print2dArray(primes);
    }
}
// pay attention

// how much should I pay attention

// 30$
