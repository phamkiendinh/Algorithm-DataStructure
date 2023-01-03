import java.util.Arrays;

public class subset {
    public static void main(String[] args) {
        int[] input = { 1, 2, 3 };
        boolean[] selected = { false, false, false };
        getSubset(input, selected, 0);
    }

    static void getSubset(int[] input, boolean[] selected, int idx) {
        if (idx == input.length) {
            process(input, selected);
            return;
        }
        selected[idx] = false;
        System.out.println("Before " + (idx + 1) + Arrays.toString(selected) + "\n");
        getSubset(input, selected, idx + 1);
        System.out.println("Middle " + (idx + 1) + Arrays.toString(selected) + "\n");
        selected[idx] = true;
        getSubset(input, selected, idx + 1);
        System.out.println("After " + (idx + 1) + Arrays.toString(selected) + "\n");

    }

    static void process(int[] set, boolean[] selected) {
        System.out.print("Subset: ");
        for (int i = 0; i < set.length; i++) {
            if (selected[i]) {
                System.out.print(set[i] + " ");
            }
        }
        System.out.println();
    }

    // public static void generateSubsets(String array[], int length) {
    //     int bit[] = new int[length];
    //     String subset[] = new String[length];
    //     for (int i = 0; i < Math.pow(2,length); i++) {
    //         bit = convertDecToBinary(i, length);
    //         boolean isNull = true;
    //         for (int j = 0; j < length; j++) {
    //             if (bit[j] == 1) {
    //                 subset[j] = array[j];
    //                 isNull = false;
    //             }
    //             else {
    //                 subset[j] = null;
    //             }
    //         }
    //         if (isNull) {
    //             System.out.println("Subset " + (i + 1) + " : {}\n");
    //         }
    //         else {
    //             System.out.print("Subset " + (i + 1) + " : {");
    //             int index = 1;
    //             for (String str : subset) {
    //                 if (str != null && index != 1) {
    //                     System.out.print("," + str);
    //                 }
    //                 if (str != null && index == 1) {
    //                     System.out.print(str);
    //                     index++;
    //                 } 
    //             }
    //             System.out.print("}");
    //             System.out.println("\n");
    //         }
    //     }
    // }

    // public static int[] convertDecToBinary(int num, int length) {
    //     int bit[] = new int[length];
    //     for (int i = length - 1; i >= 0; i--) {
    //         int remainder = num % 2;
    //         bit[i] = remainder;
    //         num = num / 2;
    //     }   
    //     return bit;
    // }
}
