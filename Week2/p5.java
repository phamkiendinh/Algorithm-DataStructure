
/*
 * You develop an application that can track users' movement (think of Google Maps).
 * The application complexity is O(N^3) and it takes 100 msec to run data for 1,000 users (N is the number of users). 
 * How many days it will take your application to run for 1,000,000 users?
 */
public class p5 {
    public static void main(String[] args) {
        double size = Math.pow(1000,3);
        double second = size * 0.1;
        double minute = second / 60;
        double hour = minute / 60;
        double day = hour / 24;
        double year = day / 365;
        System.out.println(day);
    }
}
