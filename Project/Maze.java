public class Maze {
    int rows;
    int cols;
    String[] map;
    int robotRow;
    int robotCol;
    int steps;

    public Maze() {
        // Note: in my real test, I will create much larger
        // and more complicated map
        rows = 4;
        cols = 5;
        map = new String[rows];
        map[0] = "..X..";
        map[1] = ".   .";
        map[2] = ".   .";
        map[3] = ".....";
        robotRow = 2;
        robotCol = 1;
        steps = 0;
    }

    public String go(String direction) {
        if (!direction.equals("UP") &&
            !direction.equals("DOWN") &&
            !direction.equals("LEFT") &&
            !direction.equals("RIGHT")) {
            // invalid direction
            steps++;
            return "false";
        }
        int currentRow = robotRow;
        int currentCol = robotCol;
        if (direction.equals("UP")) {
            currentRow--;
        } 
        else if (direction.equals("DOWN")) {
            currentRow++;
        } 
        else if (direction.equals("LEFT")) {
            currentCol--;
        } 
        else {
            currentCol++;
        }
        System.out.println("Turn " + direction + "\n");
        System.out.println("Current char: " + map[currentRow].charAt(currentCol) + "\n");
        // check the next position
        if (map[currentRow].charAt(currentCol) == 'X') {
        // Exit gate
            steps++;
            System.out.println("Steps to reach the Exit gate " + steps);
            return "win";
        } 
        else if (map[currentRow].charAt(currentCol) == '.') {
            // Wall
            steps++;
            return "false";
        } 
        else {
            // Space => update robot location
            steps++;
            robotRow = currentRow;
            robotCol = currentCol;
            return "true";
        }
    }


    public static void main(String[] args) {
        (new Robot()).navigate();
    }
}

class Robot {
    int RobotX;
    int RobotY;
    int rows;
    int cols;
    String map[];
    boolean visited[][];
    Node node[];
    int nodeIndex;
    public void navigate() {
        //Initialize data
        Maze maze = new Maze();
        RobotX = maze.robotRow;
        RobotY = maze.robotCol;
        rows = maze.rows;
        cols = maze.cols;
        map = maze.map;
        node = new Node[rows * cols];
        nodeIndex = 0;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }
        
        String result = "";
        Node start = new Node(RobotX, RobotY, 0, "RIGHT");
        visited[start.x][start.y] = true;
        enQueue(start);
        
        while (!result.equals("win")) {
            //If the queue is empty and X is not there, can't reach the gate
            if (isEmpty()) {
                System.out.println("Can't reach the gate!\n");
            }
            //Front of the queue
            Node frontNode = peekFront();

            //Show the relative map of the visiting node
            showRobot(frontNode.x, frontNode.y);
            //Assign the position of the robot to the current visiting queue
            maze.robotRow = frontNode.x;
            maze.robotCol = frontNode.y;
            //Check the robot with the direction
            result = maze.go(frontNode.direction);
            if (result == "win") {
                break;
            }
            /*
             * If the result is a wall, stay at current index and queue neighbors
             * If the result is a space, update index with the direction index, and queue neighbors
             */
            frontNode.x = maze.robotRow;
            frontNode.y = maze.robotCol;
            //Dequeue the front node
            deQueue();
            //Queueing adjacent neighbors of visiting node
            //Queue Down
            if (map[frontNode.x + 1].charAt(frontNode.y) != '.' && visited[frontNode.x + 1][frontNode.y] == false && validatePosition(frontNode.x + 1, frontNode.y)) {
                visited[frontNode.x + 1][frontNode.y] = true;
                Node newDown = new Node(frontNode.x, frontNode.y, frontNode.distance + 1, "DOWN");
                enQueue(newDown);
            }
            //Queue Left
            if (map[frontNode.x].charAt(frontNode.y - 1) != '.' && visited[frontNode.x][frontNode.y - 1] == false && validatePosition(frontNode.x, frontNode.y - 1))  {
                visited[frontNode.x][frontNode.y - 1] = true;
                Node newLeft = new Node(frontNode.x, frontNode.y, frontNode.distance + 1, "LEFT");
                enQueue(newLeft);
            }
            //Queue Right
            if (map[frontNode.x].charAt(frontNode.y + 1) != '.' && visited[frontNode.x][frontNode.y + 1] == false && validatePosition(frontNode.x, frontNode.y + 1)) {
                visited[frontNode.x][frontNode.y + 1] = true;
                Node newRight = new Node(frontNode.x, frontNode.y, frontNode.distance + 1, "RIGHT");
                enQueue(newRight);

            }
            //Queue Up
            if (map[frontNode.x - 1].charAt(frontNode.y) != '.' && visited[frontNode.x - 1][frontNode.y] == false && validatePosition(frontNode.x - 1, frontNode.y)) {
                visited[frontNode.x - 1][frontNode.y] = true;
                Node newUp = new Node(frontNode.x, frontNode.y, frontNode.distance + 1, "UP");
                enQueue(newUp);
            }
        }
    }
    
    /*
     * Checking to see if the position of the robot is out of bound
     */
    public boolean validatePosition(int x, int y) {
        if (x >= 0 &&  x < this.rows && y >= 0 && y < this.cols) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        boolean empty = true;
        for (int i = 0; i < this.nodeIndex; i++) {
            if (this.node[i] != null) {
                return false;
            }
        }
        return empty;
    }

    public void enQueue(Node n) {
        this.node[this.nodeIndex] = n;
        this.nodeIndex++;
    }

    public void deQueue() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < this.nodeIndex - 1; i++) {
            this.node[i] = this.node[i + 1];
        }
        this.nodeIndex--;
    }

    public Node peekFront() {
        if (isEmpty()) {
            return null;
        }
        return this.node[0];
    }

    /*
     * Print out the position of the robot on the map with relative to x and y
     */
    public void showRobot(int x, int y) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < map[i].length(); j++) {
                if (j == map[i].length() - 1 && i == x && j == y) {
                    System.out.println('r' );
                }
                else if (j == map[i].length() - 1) {
                    System.out.println(map[i].charAt(j));
                }
                else if (i == x && j == y) {
                    System.out.print('r');
                    continue;
                }
                else {
                    System.out.print(map[i].charAt(j));
                }
            }
        }
    }
}


class Node {
    int x;
    int y;
    int distance;
    String direction = "";
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
}