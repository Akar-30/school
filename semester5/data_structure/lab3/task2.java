package semester5.data_structure.lab3;

public class task2 {
    public static void main(String[] args) {
        arrayUtils utils = new arrayUtils();
        /*
         * 1. Delete one element from a 3d array, find the java code, run it at
         * lab, and show me the result.
         * Suppose you have this: [1, 2]
         * [3, 4]
         * [5, 6]
         * [7, 8]
         * Remove 8, the output will be: [1, 2]
         * [3, 4]
         * [5, 6]
         * [7]
         */

        int[][][] array = {
                {
                        { 1, 2 },
                        { 3, 4 }
                },
                {
                        { 5, 6 },
                        { 7, 8 }
                }
        };
        utils.print3DArray(array);
        // Remove last one
        array[1][1] = new int[] { 7 };
        utils.print3DArray(array);

        /*
         * 2. Delete all elements in 3D array, find the java code, run it at lab,
         * and show me the result.
         */
        System.out.println("Delete all elements in 3D array");
        int depth = array.length;
        int row = array[0].length;
        int col = array[0][0].length;

        array = new int[depth][row][col];

        // for (int i = 0; i < depth; i++) {
        // for (int j = 0; j < row; j++) {
        // for (int k = 0; k < col; k++) {
        // try {
        // array[i][j][k] = 0;
        // } catch (Exception e) {
        // System.out.println("Error: " + e);
        // }

        // }
        // }
        // }

        utils.print3DArray(array);
    }
}
