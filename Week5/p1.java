import java.util.Arrays;
import java.util.Random;
public class p1 {
    public static void main(String[] args) {
        Random random = new Random();
        int a;
        int array[] = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            a = random.nextInt(1000000) + 1;
            array[i] = a;
        }
        
        long startTime = System.nanoTime();
        Arrays.sort(array);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Total time of normal sort: " + totalTime + "\n");

        startTime = System.nanoTime();
        countingSort(array);
        endTime = System.nanoTime();
        long totalTime2 = endTime - startTime;
        System.out.println("Total time of counting sort: " + totalTime2 + "\n");
        System.out.println("Normal Sort > Counting sort: " + (int)totalTime/totalTime2 + " times\n");
    }


    static void countingSort(int[] array) {
        int length = array.length;
        int output[] = new int[length];
        
        int count[] = new int[length * 2];


        //Copy over elements from array to output
        for (int i = 0; i < length; i++) {
            output[i] = array[i];
        }

        //Initialize counts of all elements to 0
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }

        //Increment counts of integers
        for (int i = 0; i < length; i++) {
            count[array[i]]++;
        }

        //Update count to hold indexes of the elements
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }

        
        for (int i = 0; i < length; i++) {
            int indexValue = output[i]; // indexValue is from 0 to 999999
            int index = count[indexValue] - 1; // index is from 0 to length - 1 
            count[indexValue]--;
            array[index] = output[i];
        }
    }
}