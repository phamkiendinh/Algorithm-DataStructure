import java.util.Arrays;

public class Maze {
    int rows; // Maze Rows
    int cols; // Maze Columns
    String[] map; // Map
    int robotRow; // Robot X coordinate at start
    int robotCol; // Robot Y coordinate at start
    int steps; // All explored nodes

    public Maze() {
        rows = 30;
        cols = 100;
        robotRow = 27;
        robotCol = 2;
        steps = 0;
        map = new String[rows];
        map[0] = "....................................................................................................";
        map[1] = ".                                              ..                                                  .";
        map[2] = ".                                              ..                          ..                      .";
        map[3] = ".                                              ..                          ..                      .";
        map[4] = ".      ..............                          ..                  ...     ..                      .";
        map[5] = ".            .............                     ..                  ...     ..   ....................";
        map[6] = ".                                              ..                  ...     ..   ....................";
        map[7] = ".       ....  .   .  .  .....                                                   ...     ..         .";
        map[8] = ".       .  .  .. ..  .    .            ........                     .........   ...     ..         .";
        map[9] = ".       ....  . . .  .    .            ........                    .........    ...     ..         .";
        map[10] = ".       ..    .   .  .    .            ........                                 ...     ..         .";
        map[11] = ".       . .   .   .  .    .        .   ........                        ..                       ....";
        map[12] = ".       .  .  .   .  .    .        .   ........                        ..                       ....";
        map[13] = ".                                  .                                   ..  ..           .......    .";
        map[14] = ".    ..       ..    ..       ..    .        ..      ..    ...          ..  ..           .......    .";
        map[15] = ".    ....     ..    ....     ..    .        ..      ..    .....        ..  ..                      .";
        map[16] = ".    .. ..    ..    .. ..    ..        .    ..      ..    ..  ...  ..      ..                      .";
        map[17] = ".    ..  ..   ..    ..  ..   ..   .......   ..........    ..   ..  ..      ..                      .";
        map[18] = ".    ..   ..  ..    ..   ..  ..   .......   ..........    ..   ..  ..      ..                      .";
        map[19] = ".    ..    .. ..    ..    .. ..        .    ..      ..    ..  ...          ..                      .";
        map[20] = ".    ..     ....    ..     ....             ..      ..    .....            ..    ..........        .";
        map[21] = ".    ..       ..    ..       ..             ..      ..    ...              ..    ..........        .";
        map[22] = ".                                                                          ..                      .";
        map[23] = ".      .            .           .            .                             ..                      .";
        map[24] = ".      .     .      .           .            .                             ..                      .";
        map[25] = ".      .     .      .                        .        .                    ..                      .";
        map[26] = ".      .     .      .                        .        .                    ..                      .";
        map[27] = ".      .     .      .           .            .        .                    ..                      .";
        map[28] = ".  X         .                  .                     .                    ..                      .";
        map[29] = "....................................................................................................";
    }

    public String go(String direction) {
        // Invalid direction
        if (!direction.equals("UP") &&
                !direction.equals("DOWN") &&
                !direction.equals("LEFT") &&
                !direction.equals("RIGHT")) {
            steps++;
            return "false";
        }
        // Get current position of the robot in the maze
        int currentRow = robotRow;
        int currentCol = robotCol;

        // Assign next position of the robot according to given direction for validity
        // testing
        if (direction.equals("UP")) {
            currentRow--;
        } else if (direction.equals("DOWN")) {
            currentRow++;
        } else if (direction.equals("LEFT")) {
            currentCol--;
        } else {
            currentCol++;
        }

        // If the next position is the gate
        if (map[currentRow].charAt(currentCol) == 'X') {
            // Exit gate
            steps++;
            System.out.println("Steps to reach the Exit gate: " + steps);
            // Update robot to gate location
            robotRow = currentRow;
            robotCol = currentCol;
            return "win";
        } else if (map[currentRow].charAt(currentCol) == '.') {
            // Wall
            steps++;
            return "false";
        } else {
            // Space => update robot location
            steps++;
            robotRow = currentRow;
            robotCol = currentCol;
            return "true";
        }
    }
    //Main
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.navigate();
    }
}

class Robot {
    int RobotX; // Robot X Coordinate
    int RobotY; // Robot Y Coordinate
    int rows;   // get maze's horizontal length
    int cols;   // get maze's vertical length
    String map[]; // Maze's map
    boolean visited[][]; //Visited nodes
    Node queue[]; //Queue to store neighbor nodes
    int queueIndex; //Queue size

    public void navigate() {
        // Initialize data
        Maze maze = new Maze();
        RobotX = maze.robotRow;
        RobotY = maze.robotCol;
        rows = maze.rows;
        cols = maze.cols;
        map = maze.map;
        queue = new Node[rows * cols];// Queue
        queueIndex = 0;// Queue Index
        visited = new boolean[rows][cols];
        Node endNode = null;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }


        //Initialize first node for BFS
        String result = "";
        Node start = new Node(RobotX, RobotY, 0, "RIGHT");
        visited[start.x][start.y] = true;
        //Show current position of the robot in the maze
        showRobot(start.x, start.y);
        enQueue(start);

        while (!result.equals("win")) {
            // If the queue is empty and X is not there, can't reach the gate
            if (isEmpty()) {
                System.out.println("Can't reach the gate!\n");
                break;
            }
            // Front of the queue
            Node frontNode = peekFront();
            //If the node is null, dequeue it
            if (frontNode == null) {
                deQueue();
                continue;
            }
            // Show the relative map of the visiting node
            // Assign the position of the robot to the current visiting queue
            maze.robotRow = frontNode.x;
            maze.robotCol = frontNode.y;
            // Check the robot with the direction
            result = maze.go(frontNode.direction);
            if (result == "win") {
                //Get the last node, aka the gate position node
                endNode = frontNode;
                System.out.println("The shortest path length is: " + (frontNode.distance + 1));
                break;
            }
            /*
             * If the result is a wall, stay at current index and queue neighbors
             * If the result is a space, update index with the direction index, and queue
             * neighbors
             */
            frontNode.x = maze.robotRow;
            frontNode.y = maze.robotCol;
            // Dequeue the front node
            deQueue();
            // Queueing adjacent neighbors of visiting node
            // Queue Down
            if (map[frontNode.x + 1].charAt(frontNode.y) != '.' && visited[frontNode.x + 1][frontNode.y] == false
                    && validatePosition(frontNode.x + 1, frontNode.y)) {
                visited[frontNode.x + 1][frontNode.y] = true;
                Node newDown = new Node(frontNode.x, frontNode.y, frontNode.distance + 1, "DOWN", frontNode);
                enQueue(newDown);
            }
            // Queue Left
            if (map[frontNode.x].charAt(frontNode.y - 1) != '.' && visited[frontNode.x][frontNode.y - 1] == false
                    && validatePosition(frontNode.x, frontNode.y - 1)) {
                visited[frontNode.x][frontNode.y - 1] = true;
                Node newLeft = new Node(frontNode.x, frontNode.y, frontNode.distance + 1, "LEFT", frontNode);
                enQueue(newLeft);
            }
            // Queue Right
            if (map[frontNode.x].charAt(frontNode.y + 1) != '.' && visited[frontNode.x][frontNode.y + 1] == false
                    && validatePosition(frontNode.x, frontNode.y + 1)) {
                visited[frontNode.x][frontNode.y + 1] = true;
                Node newRight = new Node(frontNode.x, frontNode.y, frontNode.distance + 1, "RIGHT", frontNode);
                enQueue(newRight);
            }
            // Queue Up
            if (map[frontNode.x - 1].charAt(frontNode.y) != '.' && visited[frontNode.x - 1][frontNode.y] == false
                    && validatePosition(frontNode.x - 1, frontNode.y)) {
                visited[frontNode.x - 1][frontNode.y] = true;
                Node newUp = new Node(frontNode.x, frontNode.y, frontNode.distance + 1, "UP", frontNode);
                enQueue(newUp);
            }
        }
        if (!isEmpty()) {
            getPath(endNode, endNode.distance + 1);
        }
    }
    /*
     * This function will traverse from the end node to previous nodes and print out the path
     */
    public void getPath(Node node, int height) {
        //If end node doesn't exist
        if (node == null) {
            return;
        }
        String path[] = new String[height];
        while (node != null) {
            path[height - 1] = node.direction;
            height -= 1;
            node = node.previous;
        }
        int step = 1;
        System.out.println("Robot's direction: ");
        for (String str : path) {
            System.out.println("Step: " + step + ", Direction: " + str);
            step++;
        }
        System.out.println();
    }

    /*
     * Checking to see if the position of the robot is out of bound
     */
    public boolean validatePosition(int x, int y) {
        if (x >= 0 && x < this.rows && y >= 0 && y < this.cols) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        boolean empty = true;
        for (int i = 0; i < this.queueIndex; i++) {
            if (this.queue[i] != null) {
                return false;
            }
        }
        return empty;
    }

    public void enQueue(Node n) {
        this.queue[this.queueIndex] = n;
        this.queueIndex++;
    }

    public void deQueue() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < this.queueIndex - 1; i++) {
            this.queue[i] = this.queue[i + 1];
        }
        this.queueIndex--;
    }

    public Node peekFront() {
        if (isEmpty()) {
            return null;
        }
        return this.queue[0];
    }

    /*
     * Print out the position of the robot on the map with relative to x and y
     */
    public void showRobot(int x, int y) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < map[i].length(); j++) {
                if (j == map[i].length() - 1 && i == x && j == y) {
                    System.out.println('r');
                } else if (j == map[i].length() - 1) {
                    System.out.println(map[i].charAt(j));
                } else if (i == x && j == y) {
                    System.out.print('r');
                    continue;
                } else {
                    System.out.print(map[i].charAt(j));
                }
            }
        }
    }
}

class Node {
    int x; 
    int y;
    int distance; // The distance from the start to current position
    String direction = "";
    Node previous = null; // Keeping track of the current path

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public Node(int x, int y, int distance, String direction) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.direction = direction;
    }

    public Node(int x, int y, int distance, String direction, Node previous) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.direction = direction;
        this.previous = previous;
    }
}