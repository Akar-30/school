public class Main {
    public static void main(String[] args) {

        // Array first TASK
        // int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // System.out.println("Element at index 1: " + arr[0]);
        // System.out.println("Element at index 2: " + arr[1]);
        // System.out.println("Element at index 3: " + arr[2]);
        // System.out.println("Element at index 4: " + arr[3]);
        // System.out.println("Element at index 5: " + arr[4]);

        // for (int i = 0; i < arr.length; i++) {
        // System.out.println("Element at index " + i + ": " + arr[i]);
        // }

        // System.out.println("\n\nArray length: " + arr.length);

        // Array second TASK
        // char[] charArray = { 'A', 'K', 'A', 'R' };
        // System.out.print("Elements of the aarray together are: ");
        // for (int i = 0; i < charArray.length; i++) {
        // System.out.print(charArray[i]);
        // }
        // System.out.println();
        // for (int i = 0; i < charArray.length; i++) {
        // System.out.println("Element at index " + i + ": " + charArray[i]);
        // }
        // System.out.println("Updating the letter of the 2nd index " + charArray[1] + "
        // to: 'S'");
        // charArray[1] = 'S';

        // System.out.print("Elements of the aarray together are: ");
        // for (int i = 0; i < charArray.length; i++) {
        // System.out.print(charArray[i]);
        // }
        // System.out.println();
        // for (int i = 0; i < charArray.length; i++) {
        // System.out.println("Element at index " + i + ": " + charArray[i]);
        // }

        // Array third TASK
        String[] stringArray = { "Akar", "Hassan", "Abdalqadir" };
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println("Element at index " + i + ": " + stringArray[i]);
        }
        System.out.print("Full Name: ");
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print(stringArray[i] + " ");
        }
    }
}