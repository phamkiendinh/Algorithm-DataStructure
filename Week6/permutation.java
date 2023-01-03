import java.util.Arrays;

public class permutation {
    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4 };
        int[] current = { 0, 0, 0, 0 };
        boolean[] taken = { false, false, false, false };
        permute(input, taken, current, 0);
    }

    static void permute(int[] input, boolean[] taken, int[] current, int idx) {
        if (idx == input.length) {
            process(current);
            return;
        }

        for (int i = 0; i < input.length; i++) {
            //i = 0
            if (taken[i]) {
                continue;
            }
            current[idx] = input[i];
            taken[i] = true;
            System.out.println("i before: " + i + "\n");
            System.out.println("Taken before: " + Arrays.toString(taken) + "\n");
            permute(input, taken, current, idx + 1);
            taken[i] = false;
            System.out.println("i after: " + i + "\n");
            System.out.println("Taken after: " + Arrays.toString(taken) + "\n");
        }
    }

    static void process(int[] permutation) {
        for (int v : permutation) {
            System.out.print(v);
        }
        System.out.println();
    }
}
