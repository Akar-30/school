/*
Lab3-Task1: Write a java program to create 3D-array and apply the
followings methods on it:
 */

package semester5.data_structure.lab3;

import java.util.Arrays;

/**
 * task1
 */
public class lab3Task1 {
    private static int getTotalElements(int[][][] arr) {
        int totalElements = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    totalElements++;
                }
            }
        }
        return totalElements;
    }

    private static int getTotalElementsInChar(char[][][] arr) {
        int totalElements = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    totalElements++;
                }
            }
        }
        return totalElements;
    }

    public static void main(String[] args) {

        // 1. Use Indirect declaration to create a 3D array (named arr1) that has 2
        // layers, 3 rows, 2 columns.

        int[][][] arr1 = new int[2][3][2];

        // 2. Add elements to the array you created in point 1, started value = 12, then
        // decrease e.g. 11, 10, etc.

        int startedValue = 12;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                for (int k = 0; k < arr1[i][j].length; k++) {
                    arr1[i][j][k] = startedValue--;
                }
            }
        }

        // 3. Print all elements of point 2.

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                for (int k = 0; k < arr1[i][j].length; k++) {
                    System.out.printf("arr1[%d][%d][%d]: " + arr1[i][j][k] + "\n", i, j, k);
                }
            }
        }

        // 4. Use Direct declaration, to create a 3D array (named arr2) that has 1
        // layers, 2 rows, 4 columns, fill it with the letters of TIUS2025.
        // The output should be like this:
        // arr2 contents:
        // T I U S
        // 2 0 2 5

        char[][][] arr2 = { { { 'T', 'I', 'U', 'S' }, { '2', '0', '2', '5' } } };

        // 5. Find total number of elements of arr1 and arr2. Output:
        // Total elements of arr1:
        // Total elements of arr2:

        int totalElementsArr1 = getTotalElements(arr1);
        int totalElementsArr2 = getTotalElementsInChar(arr2);
        System.out.println("Total elements of arr1: " + totalElementsArr1);
        System.out.println("Total elements of arr2: " + totalElementsArr2);

        // 6. Display all elements of arr1 and arr2

        System.out.print("Elements of arr1: ");
        System.out.println(Arrays.deepToString(arr1));
        System.out.print("Elements of arr2: ");
        System.out.println(Arrays.deepToString(arr2));

        // 7. Search for a specific element in arr1 and arr2 by using search method.
        // ...

    }
}