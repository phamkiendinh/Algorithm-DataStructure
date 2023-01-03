/*
 * There are a set of courses that you have to take. Some courses are prerequisites for other courses. The courses and the prerequisite relationships are represented in a 2D array. Below is an example 
 * courses = [
 * [0, 0, 0, 0],
 * [1, 0, 1, 0],
 *  [0, 0, 0, 1],
 * [1, 0, 0, 0]
 * ]
 * Explanation: each course is represented as a row. A cell [i, j] = 0 if there is no prerequisite between course i and course j. A cell [i, j] = 1 if course j is a prerequisite for course i (that means you have to take course j before course i).
 * With the above example: course 0 (row 0) requires no other courses; course 1 requires courses 0 and 2; course 2 requires course 3; course 3 requires course 0. So, you have to take course 0 first, then course 3, then course 2, and finally course 1.
 * Implement a program that accepts a String array of course names, and a 2D array denoting the prerequisite relationship between courses, return a valid learning order.
 * Note: there may be more than one correct order. In this case, any order is OK.
 * Note 2: there is no mutual dependence between 2 or more courses. Otherwise, it's not possible for you to complete your study.
 */

public class p4 {
    public static void main(String[] args) {
        String[] courses = new String[] {
                "Intro to Programming",
                "Programming 1",
                "Algorithms",
                "Database Applications"
        };
        int[][] requires = new int[][] {
                { 0, 0, 0, 0 },
                { 1, 0, 0, 0 },
                { 0, 1, 0, 0 },
                { 1, 0, 0, 0 }
        };

        String[] learningOrder = topoSort(courses, requires);
        print(learningOrder);
    }

    static class Course {
        String name;
        int index;
        int inDegree;
        boolean visited;

        public Course(String n, int i) {
            name = n;
            index = i;
            inDegree = 0;
            visited = false;
        }

        public void increaseDegree() {
            inDegree++;
        }

        public void decreaseDegree() {
            inDegree--;
        }

        public boolean isSource() {
            return (inDegree == 0);
        }
    }

    static String[] topoSort(String[] courseNames, int[][] requires) {
        // initialization
        int n = courseNames.length;
        String[] res = new String[n];
        Course[] courses = new Course[n];
        LinkedListQueue<Course> queue = new LinkedListQueue<>();

        // course objects creation
        for (int i = 0; i < n; i++) {
            courses[i] = new Course(courseNames[i], i);
            // indegree calculation
            for (int j = 0; j < n; j++) {
                if (requires[i][j] != 0) {
                    courses[i].increaseDegree();
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (courses[i].isSource()) {
                queue.enQueue(courses[i]);
                courses[i].visited = true;
            }
        }

        int p = 0;
        while (!queue.isEmpty()) {
            Course u = queue.peekFront();
            queue.deQqueue();
            res[p++] = u.name;
            int source = u.index;
            for (int target = 0; target < n; target++) {
                if (requires[target][source] != 0) {
                    if (!courses[target].visited) {
                        courses[target].decreaseDegree();
                        if (courses[target].isSource()) {
                            queue.enQueue(courses[target]);
                            courses[target].visited = true;
                        }
                    }
                }
            }
        }
        if (p < n) {
            System.out.println("Cannot take all courses");
        }
        return res;
    }

    static void print(String[] arr) {
        System.out.println(String.join(" > ", arr));
    }
}
