import java.util.Arrays;
/*
 * Solve the 8-Queens problem. Can you use pruning to reduce the number of computations?
 */
public class p3 {

    /***************************************************************************
     * Return true if queen placement q[n] does not conflict with
     * other queens q[0] through q[n-1]
     ***************************************************************************/
    public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])
                return false; // same column
            if ((q[i] - q[n]) == (n - i))
                return false; // same major diagonal
            if ((q[n] - q[i]) == (n - i))
                return false; // same minor diagonal
        }
        return true;
    }

    /***************************************************************************
     * Prints n-by-n placement of queens from permutation q in ASCII.
     ***************************************************************************/
    public static void printQueens(int[] q) {
        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /***************************************************************************
     * Try all permutations using backtracking
     ***************************************************************************/
    public static void permute(int n) {
        int[] a = new int[n];
        permutation(a, 0);
    }

    public static void permutation(int[] q, int k) {
        if (k == q.length)
            printQueens(q);
        else {
            for (int i = 0; i < q.length; i++) {
                q[k] = i;
                if (isConsistent(q, k)) {
                    permutation(q, k + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 8;
        permute(n);
    }

}
