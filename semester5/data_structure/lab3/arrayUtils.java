package semester5.data_structure.lab3;

public class arrayUtils {
    // This Util Class has all utils for 3D array

    // Get total elements in 3D array
    public int getTotalElements(int[][][] arr) {
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

    // Get total elements in 3D char array
    public int getTotalElementsInChar(char[][][] arr) {
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

    // Print 3D array
    public void print3DArray(int[][][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    System.out.printf("arr[%d][%d][%d]: " + arr[i][j][k] + "\n", i, j, k);
                }
            }
        }
    }

    // `print3DCharArray` prints 3D char array
    public void print3DCharArray(char[][][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    System.out.printf("arr[%d][%d][%d]: " + arr[i][j][k] + "\n", i, j, k);
                }
            }
        }
    }

    public arrayUtils() {
    }

}
