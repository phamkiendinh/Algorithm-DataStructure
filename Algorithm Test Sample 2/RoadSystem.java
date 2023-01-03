import java.util.*;

public class RoadSystem {
    ArrayList<Lab> labs = new ArrayList<Lab>();
    public static void main(String[] args) {
        Lab l1 = new Lab("Advanced AI", 0.0, 0.0);
        Lab l2 = new Lab("Cyber Security", 10, 0);
        Lab l3 = new Lab("IoT", 0, 10);
        RoadSystem rs = new RoadSystem();
        rs.addLab(l1);
        rs.addLab(l2);
        rs.addLab(l3);
        System.out.printf("%.2f\n", rs.simpleLength()); // return 24.142
        System.out.println(rs.optimalLength()); // return 20
    }

    public void addLab(Lab l) {
        labs.add(l);
    }

    public double simpleLength() {
        double distance = 0;
        for (int i = 0; i < labs.size() - 1; i++) {
            distance  += Math.sqrt(Math.pow(labs.get(i).x - labs.get(i + 1).x, 2.0) + Math.pow(labs.get(i).y - labs.get(i + 1).y, 2.0));
        }
        return distance;
    }

    public double optimalLength() {
        double distance = 0;
        boolean visited[] = new boolean[labs.size()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < visited.length - 1; i++) {
            int minVertex = 0;
            double minDistance = Double.MAX_VALUE;
            for (int j = 0; j < visited.length - 1; j++) {
                if (i == j) {
                    continue;
                }
                if (!visited[j]) {
                    double length = Math.sqrt(Math.pow(labs.get(i).x - labs.get(j).x, 2.0) + Math.pow(labs.get(i).y - labs.get(j).y, 2.0));
                    if (length < minDistance) {
                        minDistance = length;
                        minVertex = j;
                    }
                }
            }
            visited[minVertex] = true;
            distance += minDistance;
        }
        return distance;
    }
}

class Lab {
    String name;
    double x;
    double y;

    public Lab(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

}