/*
 * Use an adjacency matrix to represent an undirected graph. Display the labels of vertices using DFS and BFS.
 * You can use the graph below to test your implementation (index the nodes in alphabetical order).
 */
public class p4 {
    public static void main(String[] args) {
        int[][] DFS = {
            {0,1,2,3,4,5},
            {1,0,1,2,3,4},
            {2,1,0,1,2,3},
            {3,2,1,0,1,2},
            {4,3,2,1,0,1},
            {5,4,3,2,1,0}
        };
        int[][] BFS = {
            {1,1,0,0,0,0}, 
            {1,0,1,0,1,0}, 
            {}, 
            {}, 
            {}, 
            {}
        };
    }
}
