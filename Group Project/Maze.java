
public class Maze {
    int rows; // Maze Rows
    int cols; // Maze Columns
    String[] map; // Map
    int robotRow; // Robot X coordinate at start
    int robotCol; // Robot Y coordinate at start
    int steps; // All explored nodes

    public Maze() {
        //Maze 1
        // rows = 4;
        // cols = 5;
        // map = new String[rows];
        // map[0] = ".....";
        // map[1] = ".   X";
        // map[2] = ".   .";
        // map[3] = ".....";
        // robotRow = 2;
        // robotCol = 1;
        // steps = 0;
        // Maze 2
        rows = 30;
        cols = 100;
        robotRow = 27;
        robotCol = 2;
        steps = 0;
        map = new String[rows];
        map[0] = "....................................................................................................";
        map[1] = ".                                              ..                                                  .";
        map[2] = ".                                              ..                          ..                      .";
        map[3] = ".                                              ..         X                ..                      .";
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
        map[28] = ".            .                  .                     .                    ..                      .";
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
    Node root;
    Node queue[];
    public void navigate() {
        // Initialize data
        Maze maze = new Maze();
        root = new Node(0,0);
        int currentX = root.x;
        int currentY = root.y;
        String result = "";
        boolean stuck = false;
        while (result != "win") {

            if (checkDirection(root, currentX - 1, currentY)) {
                //left
                result = maze.go("LEFT");
                Node left = new Node(currentX - 1, currentY);
                root.insert(left);
                if (result == "true") {
                    currentX = currentX - 1;
                }
                else if (result == "false") {
                    continue;
                }
                else {
                    System.out.println("x: " + currentX + ", y: " + currentY);
                    break;
                }
                System.out.println("Move Left\n");
                System.out.println("x: " + currentX + ", y: " + currentY);
            }

            if (checkDirection(root, currentX, currentY + 1)) {
                //up
                Node up = new Node(currentX, currentY + 1);
                root.insert(up);
                result = maze.go("UP");
                if (result == "true") {
                    currentY = currentY + 1;
                } 
                else if (result == "false") {
                    continue;
                }
                else {
                    break;
                }
                System.out.println("Move Up\n");
                System.out.println("x: " + currentX + ", y: " + currentY);
            }

            if (checkDirection(root, currentX + 1, currentY)) {
                Node right = new Node(currentX + 1, currentY);
                root.insert(right);

                result = maze.go("RIGHT");
                
                if (result == "true") {
                    currentX += 1;
                }
                else if (result== "false") {
                    continue;
                }
                else {
                    break;
                }
                System.out.println("Move Right\n");
                System.out.println("x: " + currentX + ", y: " + currentY);
            }        

            if (checkDirection(root, currentX, currentY - 1)) {
                Node down = new Node(currentX, currentY - 1);
                root.insert(down);
                
                result = maze.go("DOWN");
                if (result == "true") {
                    currentY -= 1;
                }
                else if(result == "false") {
                    continue;
                }
                else{
                    break;
                }
                System.out.println("Move Down\n");
                System.out.println("x: " + currentX + ", y: " + currentY);
            }
            System.out.println("\nRobot is stuck");
            break;
        }
    }

    public boolean checkDirection(Node root, int x, int y) {
        Node current = root;
        System.out.println("x in: " + x + ", y in: " + y + "\n");
        while (current.next != null) {
            System.out.println("Node x: " + current.x + ", Node y: " + current.y + "\n");
            if (x == current.x && y == current.y) {
                return false;
            }
            current = current.next;
        }
        return true;
    }
}

class Node {
    Node next;
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void insert (Node n) {
        Node current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = n;
    }
}



