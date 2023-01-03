
/*
 * Convert an array of integers into a max heap. You need to implement the heapify operation for the conversion.
 */
public class p3 {
    public static void main(String[] args) {
        int array[] = {4,1,3,2,16,9,10,14,8,7};
        // int[] array = {6,4,3,5,2,1};


        for (int i = array.length / 2; i >= 0; i--) {
            heapify(array, i);
        }


        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + "\n");
        }
    }

    public static void heapify(int arr[], int i) {
        int largest = i; //1
        int l = 2 * i + 1;//7
        int r = 2 * i + 2;//16 index 4

        if (l < arr.length && arr[l] > arr[largest]) {
            largest = l;//7
        }

        if (r < arr.length && arr[r] > arr[largest]) {
            largest = r;//16
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;//swap 1 and 16
            heapify(arr, largest);//16
        }

    }
}
