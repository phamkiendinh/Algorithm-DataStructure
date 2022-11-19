/*
  RMIT University Vietnam
  Course: COSC2658 - Data Structures & Algorithm
  Semester: 2022-3
  Lab Assessment: 1
  Author: Dinh Pham
  ID: S3878568
  Compiler used: 
  Created  date: 19/11/2022
  Acknowledgement: None
*/


public class StudentBST {
    Student student[];
    int MAX_STUDENTS = 100;
    int size;
    public StudentBST () {
      student = new Student[MAX_STUDENTS];
      size = 0;
    }

    //Complexity: O(logn)
    public void addStudent(Student std) {
      if (size == 0) {
          this.student[0] = std;
          size++;
      }
      else {
          Student current = this.student[0];
          Student parent = null;
          while (current != null) {
              if (std.GPA < current.GPA) {
                  parent = current;
                  current = current.left;
              }
              else if (std.GPA > current.GPA) {
                  parent = current;
                  current = current.right;
              }
          }
          if (std.GPA < parent.GPA) {
              parent.left = std;
          }
          if (std.GPA >= parent.GPA) {
              parent.right = std;
          }
          this.student[size] = std;
          size++;
      }
    }
    

    //Complexity: O(logn)
    public Student nextStudentEasy(Student std) {
        Student current = this.student[0];
        Student smallest = null;
        while (current.GPA != std.GPA) {
            if (current.GPA < std.GPA) {
                current = current.right;
            }
            else {
                current = current.left;
            }
        }
        current = current.right;
        while (current != null) {
            smallest = current;
            current = current.left;
        }

        return smallest;
    }

    //Complexity: O(n)
    public Student nextStudentGeneral(Student std) {
        Student current = this.student[0];
        Student smallest = null;
        Student parent = null;
        while (current.GPA != std.GPA && current != null) {
            if (current.GPA < std.GPA) {
                parent = current;
                current = current.right;
            }
            else {
                parent = current;
                current = current.left;
            }
        }

        if (current.right == null && current.left == null) {
            Student node = this.student[0];
            smallest = this.inRecursive(node, current.GPA, node);
        }
        else {
            current = current.right;
            while (current != null) {
                smallest = current;
                current = current.left;
            }
        }

        return smallest;
    }

    //Complexity: O(n)
    private Student inRecursive(Student node, double GPA, Student smallest) {
        if (node != null) {
            inRecursive(node.left, GPA, smallest);
            if (GPA < node.GPA && node.GPA <= smallest.GPA) {
                smallest = node;
            }
            inRecursive(node.right, GPA, smallest);
        }
        return smallest;
    }
    public static void main(String[] args) {
        Student s1 = new Student(1, "A", 70.0);  // the first parameter is student id
        Student s2 = new Student(2, "B", 65.0);
        Student s3 = new Student(3, "C", 80.0);
        Student s4 = new Student(4, "D", 78.0);
        Student s5 = new Student(5, "E", 68.0);

        StudentBST s = new StudentBST();
        s.addStudent(s1);
        s.addStudent(s2);
        s.addStudent(s3);
        s.addStudent(s4);
        s.addStudent(s5);

        System.out.println("Student " + s.nextStudentEasy(s1).id + ", with GPA " + s.nextStudentEasy(s1).GPA + "\n");


        System.out.println("Student " + s.nextStudentGeneral(s5).id + ", with GPA " + s.nextStudentGeneral(s5).GPA + "\n");
        System.out.println("Student " + s.nextStudentGeneral(s3).id + ", with GPA " + s.nextStudentGeneral(s3).GPA + "\n");

    }
}


class Student {
    int id;
    String name;
    double GPA;

    Student right;
    Student left;

    public Student() {}
    public Student(int id, String name, double GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
        right = null;
        left = null;
    }  
}
