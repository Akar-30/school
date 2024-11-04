package semester5.data_structure.lab5;

/*
    Create a 3D array then convert it to 1D array by java, find the code and run
    it explain it.
 */
public class lab5Task2 {
    public static void main(String[] args) {
        int[][][] arr3D = {
                {
                        { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 }
                },
                {
                        { 10, 11, 12 },
                        { 13, 14, 15 },
                        { 16, 17, 18 }
                },
                {
                        { 19, 20, 21 },
                        { 22, 23, 24 },
                        { 25, 26, 27 }
                }
        };

        // Converting 3d array to 1d array
        int[] arr1D = new int[27];
        for (int i = 0; i < arr3D.length; i++) {
            for (int j = 0; j < arr3D[0].length; j++) {
                for (int k = 0; k < arr3D[0][0].length; k++) {
                    arr1D[i * arr3D[0].length * arr3D[0][0].length + j * arr3D[0][0].length + k] = arr3D[i][j][k];
                }
            }
        }

        System.out.println("3D array:");
        for (int i = 0; i < arr3D.length; i++) {
            for (int j = 0; j < arr3D[0].length; j++) {
                for (int k = 0; k < arr3D[0][0].length; k++) {
                    System.out.print(arr3D[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("\n1D array:");
        for (int i = 0; i < arr1D.length; i++) {
            System.out.print(arr1D[i] + " ");
        }
    }
}
