import java.util.Arrays;
import java.util.Random;
import java.util.random.*;

/*
 * Implement Merge sort and Quick sort.
 * Generate an array of 1,000,000 random integers and use Merge sort and Quick sort to sort it. Compare the running between them.
 * Can you use Selection sort or Bubble sort to sort an array of this size?
 */
public class p1 {
    public static void main(String[] args) {
        int[] mergeArray = new int[1000000];
        int[] quickArray = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < mergeArray.length; i++) {
            int num = random.nextInt(500) + 1;
            mergeArray[i] = num;
            quickArray[i] = num;
        }
        long startTime = System.nanoTime();
        merge(mergeArray);
        long endTime = System.nanoTime() - startTime;
        System.out.println("Merge Sort took: " + endTime +"\n");
        // for (int i : mergeArray) {
        //     System.out.println(i +  "\n");
        // }

        startTime = System.nanoTime();
        quickSort(quickArray, 0 , quickArray.length - 1);
        endTime = System.nanoTime() - startTime;
        System.out.println("Quick Sort took: " + endTime + "\n");
        // for (int i : quickArray) {
        //     System.out.println(i +  "\n");
        // }
    }   

    public static void merge(int[] array) {
        if (array.length == 1) {
            return;
        }
        int middle = array.length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[array.length - middle];
        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }
        int index = 0;
        for (int i = middle; i < array.length; i++) {
            rightArray[index] = array[i];
            index++;
        }
        merge(leftArray);
        merge(rightArray);
        mergeSort(array, leftArray, rightArray);
    }

    public static void mergeSort(int[] array, int[] leftArray, int[] rightArray) {
        int arrayIndex = 0; 
        int leftIndex = 0;
        int rightIndex = 0;

        while(leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                array[arrayIndex] = leftArray[leftIndex];
                arrayIndex++;
                leftIndex++;
            }
            else {
                array[arrayIndex] = rightArray[rightIndex];
                arrayIndex++;
                rightIndex++;
            }
        }

        while(leftIndex != leftArray.length) {
            array[arrayIndex] = leftArray[leftIndex];
            leftIndex++;
            arrayIndex++;
        }

        while(rightIndex != rightArray.length) {
            array[arrayIndex] = rightArray[rightIndex];
            rightIndex++;
            arrayIndex++;
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            partition(array, left, pivot - 1);
            partition(array, pivot + 1, right);
        }
    }
    public static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int index = left;
        
        for (int i = left; i < right; i++) {
            if (array[i] < pivot) {
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
                index++;
            }
        }
        int temp = array[index];
        array[index] = array[right];
        array[right] = temp;

        return index;
    }


}