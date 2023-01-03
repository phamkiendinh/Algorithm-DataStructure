package Week2;

/*
 * Given the arrival and departure time of planes reaching a particular airport. 
 * You need to find the minimum number of gates required to accommodate the planes at any point in time.
 * For example:
 * P1 = {1:00, 1:10}
 * P2 = {1: 40, 3:00}
 * P3 = {1:50, 2:20}
 * P4 = {2:00, 2:30}P4 = {2:00, 2:30}
 * P5 = {2:15, 3:15}
 * P6 = {4:00, 6:00}
 * => number of gates required = 4
 * What is the complexity of your algorithm? In this problem, N is the number of planes.
 */
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
