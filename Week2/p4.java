package Week2;
public class p4 {
    public static void main(String[] args) {
        int[] array = {-10,-5,-1,2,15,20};
        int negative = 0, positive = 0, sum = 69;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i] < 0) {
                    if(array[j] < 0) {
                        continue;
                    }
                    else {
                        if (sum == 69) {
                            positive = array[j];
                            negative = array[i];
                            sum = array[j] + array[i];
                        }
                        else {
                            int check = array[i] + array[j];
                            int d1 = Math.abs(check);
                            int d2 = Math.abs(sum);
                            if (d1 < d2) {
                                sum = check;
                                positive = array[j];
                                negative = array[i];
                            }
                        }
                    }
                }
                else {
                    if(array[j] > 0) {
                        continue;
                    }
                    else {
                        if (sum == 69) {
                            positive = array[i];
                            negative = array[j];
                            sum = array[j] + array[i];
                        }
                        else {
                            int check = array[i] + array[j];
                            int d1 = Math.abs(check);
                            int d2 = Math.abs(sum);
                            if (d1 < d2) {
                                sum = check;
                                positive = array[i];
                                negative = array[j];
                            }
                        }
                    }
                }
            }
        }     
        System.out.println("Sum closest to zero is: " + sum + ", negative = " + negative + ", positive = " + positive);   
    }
}
