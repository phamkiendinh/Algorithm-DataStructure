/*
 * You have an array of Student objects.
 * Each Student contains an ID (String) and GPA (double).
 * Sort the Student array by GPA using heap sort.
 */
public class p2 {
    public static void main(String[] args) {
        Student s1 = new Student("1", 10);
        Student s2 = new Student("2", 30);
        Student s3 = new Student("3", 50);
        Student s4 = new Student("4", 20.2);
        Student s5 = new Student("5", 30.5);
        Student s6 = new Student("6", 36);
        Student s7 = new Student("7", 52);
        Student s8 = new Student("8", 14);
        Student s9 = new Student("9", 24);
        Student student[] = {s1,s2,s3,s4,s5,s6,s7,s8,s9};
        sort(student);
        for (Student s : student) {
            System.out.println("ID: " + s.id + ", GPA: " + s.GPA + "\n");
        }
    }
    public static void sort(Student array[])
    {
        int length = array.length;
        // Build heap (rearrange array)
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, length, i);
 
        // One by one extract an element from heap
        for (int i = array.length - 1; i > 0; i--) {
            // Move current root to end
            Student temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // System.out.println("ID: " + temp.id + ", GPA: " + temp.GPA + "\n");
 
            // call max heapify on the reduced heap
            heapify(array,i,0);
        }
    }

    public static void heapify(Student array[], int length, int index) {
        int i = index;

        int l = i * 2 + 1;
        int r = i * 2 + 2;

        if (l < length && array[l].GPA > array[i].GPA) {
            i = l;
        }

        if (r < length && array[r].GPA > array[i].GPA) {
            i = r;
        }

        if (i != index) {
            Student temp = array[i];
            array[i] = array[index];
            array[index] = temp;
            heapify(array, length, i);
        }
    }
}


class Student {
    String id;
    double GPA;

    public Student() {}
    public Student(String id, double GPA) {
        this.id = id;
        this.GPA = GPA;
    }
}
