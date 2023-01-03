import java.util.Arrays;

/*
 * Given an array V storing the values of N items, an array W storing the weights of N items, and a knapsack capacity C. 
 * Calculate and return the subset of N items that has the highest sum value, and its total weight does not exceed C.
 */
public class p2 {
    static int max = 0;
    static String subsetMax = "";
    public static void main(String[] args) {
        int[] value = {1,2,3,4};
        int[] weight = {4,5,6,7};
        int capacity = 10;
        boolean[] selected = { false, false, false, false };
        getSubset(value, selected, weight, 0, capacity);
        System.out.println("Max subset is: " + subsetMax); 
    }

    static void getSubset(int[] input, boolean[] selected, int[] weight, int idx, int capacity) {
        if (idx == input.length) {
            process(input, weight, selected, capacity);
            return;
        }
        selected[idx] = false;
        getSubset(input, selected, weight, idx + 1, capacity); 
        selected[idx] = true;
        getSubset(input, selected, weight, idx + 1, capacity);
    }

    static void process(int[] set, int[] weight, boolean[] selected, int capacity) {
        int sum = 0;
        String output = "";
        System.out.print("Subset: ");
        for (int i = 0; i < set.length; i++) {
            if (selected[i]) {
                System.out.print(set[i] + " ");
                output += set[i] + " ";
                sum += set[i];
            }
        }
        System.out.println();
        if (max <= sum && sum <= capacity) {
            max = sum;
            subsetMax = output;
        }
    }
}
