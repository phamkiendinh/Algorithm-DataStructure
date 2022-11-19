package Week2;

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
