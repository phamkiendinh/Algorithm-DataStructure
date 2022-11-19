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



public class EscapeRoom {
    String[] rooms;
    int size;
    int MAX_SIZE = 100;

    public EscapeRoom () {
        this.rooms = new String[MAX_SIZE];
        this.size = 0;
    }

    //Complexity: O(1)
    public void enterRoom(String room) {
        this.rooms[size] = room;
        System.out.println("Enter room " + this.rooms[size] + "\n");
        this.size++;
    }
    //Complexity: O(1)
    public String exitRoom() {
      this.size--;
      String exit = this.rooms[this.size];
      return exit;
    }

    //Complexity: O(n)
    public int minOperations(String[] target, String[] enteredRooms) {

        if (target.length == 0 || enteredRooms.length == 0) {
            return -1;
        }
        int call = 0;

        if (enteredRooms.length > target.length) {
            int dif = enteredRooms.length - target.length;
            call += dif;
            for (int i = target.length; i < enteredRooms.length; i++) {
                enteredRooms[i] = null;
            }
            for (int i = 0; i < target.length; i++) {
                if (target[i] != enteredRooms[i]) {
                  call += 2;
                }
            }
        }
        else {
            int dif = target.length - enteredRooms.length;
            call += dif;
            for (int i = 0; i < enteredRooms.length; i++) {
              if (target[i] != enteredRooms[i]) {
                  call += 2;
              }
            }
        }

        return call;
    }
    public static void main(String[] args) {
        EscapeRoom er = new EscapeRoom();

        er.enterRoom("A");
        er.enterRoom("B");
        er.enterRoom("C");
        er.enterRoom("D");

        System.out.println("Exit room " + er.exitRoom() + "\n");
        System.out.println("Exit room " + er.exitRoom() + "\n");
        System.out.println("Exit room " + er.exitRoom() + "\n");
        System.out.println("Exit room " + er.exitRoom() + "\n");


        String target1[] = {"A", "B", "C"};
        String enteredRooms1[] = {"A", "B"};
        String target2[] = {"A", "B", "C"};
        String enteredRooms2[] = {"A", "B", "C"};
        String target3[] = {"A", "B", "C"};
        String enteredRooms3[] = {"A", "B", "C", "D"};
        System.out.println("There are: " + er.minOperations(target1, enteredRooms1) + " calls.\n");
        System.out.println("There are: " + er.minOperations(target2, enteredRooms2) + " calls.\n");
        System.out.println("There are: " + er.minOperations(target3, enteredRooms3) + " calls.\n");
    }
}