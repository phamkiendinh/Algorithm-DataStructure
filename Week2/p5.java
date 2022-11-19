
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
