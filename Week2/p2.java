package Week2;

/*
 * Describe an algorithm that prints out all the unique elements in an array. What is the complexity of your algorithm? (Note: The Set ADT is not available).
 * Example:
 * Array = [6, 8, 10, 11, 6, 10] => print out [6, 8, 10, 11] (you can print the values in any order)
 * 
 */
public class p2 {
    public static void main(String[] args) {
        int[] array = {6,8,10,11,6,10};
        int[] temp = {};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (temp.length == 0) {
                    temp[0] = array[i];
                }
                else {
                    if (temp[j] == array[i]) {
                        continue;
                    }
                    else {
                        temp[j+1] = array[i];
                    }
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }
}
