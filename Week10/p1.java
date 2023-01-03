import java.util.Arrays;

/*
 * The list of cities and their direct distances are given in a 2D array. For example
 * distances = [
 * [0, 3, 2, 0]
 * [3, 0, 0, 5],
 * [2, 0, 0, 9]
 * [0, 5, 9, 0]
 * ]
 * Explanation: the value at cell [i, j] represents the distance between city i and city j.
 * The distance between a city and itself is zero (i.e., [i, i] = 0 for every i).
 * If there is no direct path between city i and j, then [i, j] is also zero.
 * Implement a program to calculate the shortest path's length from the first city (index 0) 
 * to the last city (index n - 1, n is the number of cities).
 * In the above example, there are 2 paths from city 0 to city 3
 * 0 -> 1 -> 3 (length 3 + length 5 = 8)
 * 0 -> 2 -> 3 (length 2 + length 9 = 11)
 * So, the shortest path is: 0 -> 1 -> 3
 */

public class p1 {
    public static void main(String[] args) {
        int map[][] = {
                { 0, 3, 2, 0 },
                { 3, 0, 0, 5 },
                { 2, 0, 0, 9 },
                { 0, 5, 9, 0 }
        };
        shortestPath(map, 0, 3);
    }

    public static void shortestPath(int map[][], int start, int end) {
        int distance[] = new int[map.length];
        boolean visited[] = new boolean[map.length];
        int path[] = new int[map.length];
        // Initialize distance
        for (int i = 0; i < map.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        distance[0] = 0;
        path[0] = -1;

        for (int i = 0; i < map.length; i++) {
            // Store the vertex that has the minimum weight
            int minVertex = -1;
            int minWeight = Integer.MAX_VALUE;
            // If the vertex is not visited and its distance is lower
            for (int j = 0; j < map.length; j++) {
                if (!visited[j] && distance[j] < minWeight) {
                    minVertex = j;
                    minWeight = distance[j];
                }
            }
            //If it is the destination, we stop immediately
            if (minVertex == end) {
                break;
            }
            // The vertex with lowest weight is visited
            visited[minVertex] = true;

            // Update the neighbors of current visiting vertex
            for (int j = 0; j < map.length; j++) {
                int edgeWeight = map[minVertex][j];
                if (edgeWeight > 0 && ((minWeight + edgeWeight) < (distance[j]))) {
                    path[j] = minVertex;
                    distance[j] = minWeight + edgeWeight;
                }
            }
            System.out.println("\nDistance: "+ " " +Arrays.toString(distance));
            System.out.println("\nPath: " + " " +Arrays.toString(path));
        }
        printPath(end, path);
    }

    public static void printPath(int end, int path[]) {
        if (end == -1) {
            return;
        }
        printPath(path[end], path);
        System.out.print(end + " -> ");
    }
 
}
