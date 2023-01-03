/*
 * A collection of N people goes to a conference. Some people are friends of others.
 * The conference has two sessions: session one is about Data Structures and session two is about Algorithms.
 * Is it possible to divide the people into two groups,
 * one attending the Data Structures session and one attending the Algorithms session,
 * such that there are no two people who are friends and join the same session? In this problem,
 * let's use an adjacency matrix to represent friendship.
 * Example 1:
 * 0 1 1
 * 1 0 0
 * 1 0 0
 * In this matrix, person 1 is a friend of person 2 and person 3. 
 * There is no friendship between person 2 and person 3.
 * So, person 1 can attend one session; person 2 and person 3 can attend the other session.
 * Example 2:
 * 0 1 1
 * 1 0 1
 * 1 1 0
 * In this matrix, each person is a friend of all other people.
 * We cannot divide the three people into two groups that satisfy the requirement.
 */
public class p4 {
    public static void main(String[] args) {
        int p1 [][] = {
            {0,1,1},
            {1,0,0},
            {1,0,0}
        };

        int p2 [][] = {
            {0,1,1},
            {1,0,1},
            {1,1,0}
        };
        boolean visited[] = {false, false, false};
        getSubSet(p1, visited, 0);
    }    

    public static void getSubSet(int p[][], boolean visited[], int index) {
        if (index == p.length) {
            process(p, visited);
            return;
        }
        visited[index] = false;
        getSubSet(p, visited, index + 1); 
        visited[index] = true;
        getSubSet(p, visited, index + 1);
    }
    static void process(int p[][], boolean[] visited) {
        int counter = 0;

        System.out.print("Subset: ");
        for (int i = 0; i < p[0].length; i++) {
            if (visited[i]) {
                System.out.print((i + 1) + " ");
                counter++;
            }
        }

        if (counter <= 1) {
            System.out.println("Can't distribute to group");
            return;
        }

        boolean check = true;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) { 
                for (int j = 0; j < visited.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (visited[j]) {
                        if (p[i][j] == 1 || p[j][i] == 1) {
                            System.out.print("False" + " ");
                            check = false;
                            break;
                        }
                    }
                }
            }
            if (!check) {
                break;
            }
        }
        if (check) {
            System.out.print("True");
        }
        System.out.println();
    }
}
