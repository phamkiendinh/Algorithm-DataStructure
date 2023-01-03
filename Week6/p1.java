/*
 * Implement Selection sort and Bubble sort and display the array being sorted after each iteration of the outer loop.
 * For example, if the array to be sorted is: [5, 1, 9, 6, 2]
 * Then, the Selection sort's intermediate results are
 * [5, 1, 9, 6, 2] (original state)
 * [1, 5, 9, 6, 2] (after the 1st iteration)
 * [1, 2, 9, 6, 5] (after the 2nd iteration)
 * [1, 2, 5, 6, 9] (after the 3rd iteration)
 * [1, 2, 5, 6, 9] (after the 4th iteration)
 */
public class p1 {
    public static void main(String[] args) {
        int[] array = {5,1,9,6,2}; 
        // selectionSort(array);
        bubbleSort(array);
        for (int i : array) {
            System.out.println(i + "\n");
        }
    }
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
            System.out.println((i + 1) + " iteration");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println("\n");
        }
    }
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println((i + 1) + " iteration\n");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println("\n");
        }
    }
}


