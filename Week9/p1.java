/*
 * You are given N boxes containing candies. The box at index i contains A[i] candies.
 * You want all boxes to contain the same target number of candies.
 * That means you have to remove some candies from a box if it contains more than the target number,
 * as well as add some candies to a box if it contains less than the target number.
 * What is the minimum number of total candies that have been removed and added?
 * Example1: A = [5, 8, 3], return 5 (remove 3 from the 2nd box and add 2 to the 3rd box)
 * Example2: A = [9, 9, 9, 9, 10], return 1 (remove 1 from the last box)
 */
public class p1 {
    public static void main(String[] args) {
        int A[] = {5,8,3};
        int B[] = {9,9,9,9,10};
        int C[] = {7,2,3};
        System.out.println("A: " + getCandy(A));
        System.out.println("B: " + getCandy(B));
        System.out.println("C: " + getCandy(C));
    }


    public static int getCandy(int array[]) {
        int average = 0;
        for (int i : array) {
            average += i;
        }
        average = average / array.length;
        int result = 0;

        for (int i : array) {
            if (i < average) {
                result += average - i;
            }
            if (i > average) {
                result += i - average;
            }
        }

        return result;
    }
}
