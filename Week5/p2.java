

public class p2 {
    public static void main(String[] args) {
        RMITStudentCollection rsc = new RMITStudentCollection();
        RMITStudent s1 = new RMITStudent("1", "Dinh", "IT", 10.0);
        RMITStudent s2 = new RMITStudent("2", "Dinh2", "IT2", 10.5);
        RMITStudent s3 = new RMITStudent("3", "Dinh3", "IT3", 5.0);
        RMITStudent s4 = new RMITStudent("4", "Dinh4", "IT4", 2.0);
        RMITStudent s5 = new RMITStudent("5", "Dinh4", "IT4", 15.0);
        rsc.put(s1);
        rsc.put(s2);
        rsc.put(s3);
        rsc.put(s4);
        rsc.put(s5);
        System.out.println("Student id: " + rsc.get("1").id + "\n");
    }
}


class RMITStudent {
    String id;
    String name;
    String major;
    double GPA;
    RMITStudent next;
    public RMITStudent() {
        next = null;
    }

    public RMITStudent(String id, String name, String major, double GPA) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.GPA = GPA;
        this.next = null;
    } 
}


class RMITStudentCollection {
    int SIZE = 13;
    RMITStudent student[] = new RMITStudent[SIZE];
    public RMITStudentCollection () {
        for (int i = 0; i < SIZE; i++) {
            student[i] = null;
        }
    }
    
    public boolean put(RMITStudent s) {
        if (s.id == null) {
            return false;
        }

        for (int i = 0; i < SIZE; i++) {
            if (student[i] == null) {
                continue;
            }
            if (student[i].id == s.id) {
                return false;
            }
        }
        int index = hashStudent(s.id, SIZE);
        if (student[index] == null) {
            student[index] = s;
            System.out.println("Student: " + student[index].name + " is inserted at: " + index + "\n");
            return true; 
        }
        //Separate Chaining
        else if (student[index] != null && student[index].next == null) {
            student[index].next = s;
            System.out.println("Student: " + student[index].name + " is inserted at: " + index + ", after student: " + student[index].id + "\n");
            return true;
        }
        //Separate Chaining
        else if (student[index] != null && student[index].next != null) {
            RMITStudent temp = student[index].next;
            while (temp.next != null) {
                temp = temp.next;
                if (temp.next == null) {
                    temp.next = s;
                    System.out.println("Student: " + s.id + " is inserted at: " + index + ", after student: " + temp.id + "\n");
                    return true;
                }
            }
            return false;
        }
        //Linear Probing, it won't reach here, but the method will be executed if the above separate chaining method is removed or commented out
        else {
            index++;
            while(index != SIZE) {
                if (student[index] == null) {
                    student[index] = s;
                    System.out.println("Student: " + student[index].name + " is inserted at: " + index + "\n");
                    return true;
                }
                index++;
            }
            return false;
        }
    }

    public RMITStudent get(String studentID) {
        for (int i = 0; i < this.SIZE; i++) {
            if (student[i] == null) {
                continue;
            }
            if (student[i].id == studentID) {
                return student[i];
            }
        }
        return null;
    }

    public boolean remove(String studentID) {
        for (int i = 0; i < SIZE; i++) {
            //If the current slot is null, continue;
            if (student[i] == null) {
                continue;
            }
            //If the current slot is not null, do something
            //If the student is not null and is the target
            if (student[i].id == studentID) {
                //If the current slot has separate chains, shift them
                if (student[i].next != null) {
                    student[i] = student[i].next;
                    return true;
                }
                //If it doesn't have separate chains, set to null
                else {
                    student[i] = null;
                    return true;
                }
            }
            //If the student at current index is not the target,and it has separate chains
            if (student[i].next != null) {
                RMITStudent temp = student[i].next;
                RMITStudent parent = student[i];
                while (temp.next != null) {
                    if (temp.id  == studentID) {
                        temp = temp.next;
                        parent.next = temp;
                        return true; 
                    }
                    parent = temp;
                    temp = temp.next;
                }
            }
        }    

        return false;
    }

    public int hashStudent(String str, int size) {
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            int num = getInt(str.charAt(i));
            sum += num;    
        }
        int hash = sum % size;
        return hash;
    }

    public int getInt(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;         
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;         
            case 'I':
                return 8;
            case 'J':
                return 9;
            case 'K':
                return 10;
            case 'L':
                return 11;         
            case 'M':
                return 12;
            case 'N':
                return 13;
            case 'O':
                return 14;
            case 'P':
                return 15;          
            case 'Q':
                return 16;
            case 'R':
                return 17;
            case 'S':
                return 18;         
            case 'T':
                return 19;
            case 'U':
                return 20;
            case 'V':
                return 21;
            case 'W':
                return 22;
            case 'X':
                return 23;
            case 'Y':
                return 24;
            case 'Z':
                return 25;         
            case '0':
                return 26;
            case '1':
                return 27;
            case '2':
                return 28;
            case '3':
                return 29;        
            case '4':
                return 30;
            case '5':
                return 31;
            case '6':
                return 32;
            case '7':
                return 33;        
            case '8':
                return 34;
            case '9':
                return 35;  
            default:
                return -1;
        }
    }
}