package semester5.data_structure;

public class ex2 {
    public static void main(String[] args) {

        int startingValue = 1;
        int[][][] arr3 = new int[2][3][4];
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                for (int k = 0; k < arr3[i][j].length; k++) {
                    arr3[i][j][k] = startingValue++;
                }
            }
        }
        // print the array
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                for (int k = 0; k < arr3[i][j].length; k++) {
                    System.out.print(arr3[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
