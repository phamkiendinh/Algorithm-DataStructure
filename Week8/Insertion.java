import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int array[] = {2,4,6,1,3};
        System.out.println("Before: " + Arrays.toString(array));
        insert(array);
        System.out.println("After: " + Arrays.toString(array));

    }

    public static void insert(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > value) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = value;
        }
    }
}
