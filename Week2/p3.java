package Week2;

public class p3 {
    public static void main(String[] args) {
        int[] p1 = {100, 110};
        int[] p2 = {140, 300};
        int[] p3 = {150, 220};
        int[] p4 = {200, 230};
        int[] p5 = {215, 315};
        int[] p6 = {400, 600};
        int gate = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                String a = "p" + Integer.toString(i);
                String b = "p" + Integer.toString(j);
                if (p1[0] <= p2[0] && p1[1] >= p2[1] || p2[0] <= p1[0] && p2[1] >= p1[1]) {
                    continue;
                }
                else {
                    gate += 1;
                }
            }
        }
        System.out.println("The number of gates: " + gate);
    }
}
