import java.util.Arrays;

/*
 * You are given a list of distinct items
 * [item 1, item 2, ..., item n]
 * You want to take as many items in increasing order as possible. 
 * For example, if you already take item i, then if you want to take item j positioned after i, 
 * they must satisfy this condition
 * value of item i < value of item j
 * Example: if the list of items is
 * [5, 2, 3, 9, 6, 7, 8]
 * Then, you can take [2, 3, 6, 7, 8] to have 5 items.
 * If you take the first item (value 5), you can only take [5, 6, 7, 8] (4 items in total)
 * Implement a solution for the above problem.
 */
public class p3 {
    public static void main(String[] args) {
        int item[] = {5,2,3,9,6,7,8};
        int table[][] = new int[item.length][item.length];
        // for (int i = 0; i < table.length; i++) {
        //     for (int j = 0; j < table.length; j++) {
        //         if (i == 0 || j == 0) {
        //             table[i][j] = 0;
        //         }
        //         else {
        //             table[i][j] = -1;
        //         }
        //     }
        // }
        // getItems(item, table, item.length - 1, item.length - 1);
        // for (int i = 0; i < table.length; i++) {
        //     System.out.println(Arrays.toString(table[i]));
        // }

    }
    //Bottom Up
    public static void getItems(int array[]) {
        
    }
    //Top Down
    // public static int getItems(int array[], int table[][], int index, int current) {
    //     if(table[current][index] < 0) {
    //         int x = table[current][index];
    //         if (array[index] <= array[current]) {
    //             x = Math.max(getItems(array, table, index - 1, current), table[current][index] + getItems(array, table, index - 1, current - 1));
    //         }
    //         else {
    //             x = getItems(array, table, index - 1, current);
    //         }
    //         table[current][index] = x;
    //     }
    //     return table[current][index];
    // }
}
