public class Main {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println("Element at index 1: " + arr[0]);
        System.out.println("Element at index 2: " + arr[1]);
        System.out.println("Element at index 3: " + arr[2]);
        System.out.println("Element at index 4: " + arr[3]);
        System.out.println("Element at index 5: " + arr[4]);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element at index " + i + ": " + arr[i]);
        }

        System.out.println("\n\nArray length: " + arr.length);
    }
}