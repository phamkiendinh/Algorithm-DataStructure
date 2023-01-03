
public class TaskCollection {
    static Task tasks[] = new Task[2027];

    // static char alphabet[] =
    // {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','S','Y','Z'};
    public static void main(String[] args) {
        Task t1 = new Task("GET DI", true);
        Task t2 = new Task("GET HD", false);
        TaskCollection taskCol = new TaskCollection();
        System.out.println("Location: " + taskCol.calcLocation(t1)); // return 40
        System.out.println("Location: " + taskCol.calcLocation(t2)); // return 39
        System.out.println("Location: " + taskCol.calcLocation(new Task("GET D I", false))); // return 40
        System.out.println("Add Task At: " + taskCol.addTask(t1)); // return 40
        System.out.println("Add Task At: " + taskCol.addTask(new Task("GET D I", false))); // return 41, due to
                                                                                           // collision at 40-th
        // location
        System.out.println(taskCol.getTask("GET DI").name); // return Task t1
        System.out.println(taskCol.getTask("G E T D I")); // return null
        System.out.println(taskCol.getTask("GET HD")); // return null
    }

    public int calcLocation(Task t) {
        int sum = 0;
        for (int i = 0; i < t.name.length(); i++) {
            if (t.name.charAt(i) != ' ') {
                switch (t.name.charAt(i)) {
                    case 'A':
                        sum += 0;
                        continue;
                    case 'B':
                        sum += 1;
                        continue;
                    case 'C':
                        sum += 2;
                        continue;
                    case 'D':
                        sum += 3;
                        continue;
                    case 'E':
                        sum += 4;
                        continue;
                    case 'F':
                        sum += 5;
                        continue;
                    case 'G':
                        sum += 6;
                        continue;
                    case 'H':
                        sum += 7;
                        continue;
                    case 'I':
                        sum += 8;
                        continue;
                    case 'J':
                        sum += 9;
                        continue;
                    case 'K':
                        sum += 10;
                        continue;
                    case 'L':
                        sum += 11;
                        continue;
                    case 'M':
                        sum += 12;
                        continue;
                    case 'N':
                        sum += 13;
                        continue;
                    case 'O':
                        sum += 14;
                        continue;
                    case 'P':
                        sum += 15;
                        continue;
                    case 'Q':
                        sum += 16;
                        continue;
                    case 'R':
                        sum += 17;
                        continue;
                    case 'S':
                        sum += 18;
                        continue;
                    case 'T':
                        sum += 19;
                        continue;
                    case 'U':
                        sum += 20;
                        continue;
                    case 'V':
                        sum += 21;
                        continue;
                    case 'W':
                        sum += 22;
                        continue;
                    case 'X':
                        sum += 23;
                        continue;
                    case 'Y':
                        sum += 24;
                        continue;
                    case 'Z':
                        sum += 25;
                        continue;
                }
            }
        }
        if (sum >= 2027) {
            sum = sum % 2027;
        }
        return sum;
    }

    public int addTask(Task t) {
        int position = calcLocation(t);
        while (tasks[position] != null) {
            position++;
        }
        tasks[position] = t;
        return position;
    }

    public Task getTask(String name) {
        // First way
        Task t = new Task(name, false);
        int position = calcLocation(t);
        while (tasks[position] != null && tasks[position].name != t.name) {
            if (tasks[position] == null) {
                return null;
            }
            position++;
        }
        return tasks[position];

        // Second way
        // for (Task t : tasks) {
        // if (t == null) {
        // continue;
        // }
        // if (t.name == name) {
        // return t;
        // }
        // }
        // return null;
    }
}

class Task {
    String name;
    boolean status;

    public Task(String name, boolean status) {
        this.name = name.toUpperCase();
        this.status = status;
    }
}