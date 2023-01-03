package Week3;

import java.util.ArrayList;

/*
 * Implement the Circular Linked List data structure and use it to solve the Josephus problem Links to an external site..
 */
public class p2 {
    public static void main(String[] args) {
        Node head = new Node();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        head.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(head);
        int n = head.getLength();
        int m = 2;
        josephus(n,m,head);
    }
    public static void josephus(int n, int m, Node head) {
        ArrayList<Integer> array = new ArrayList<>();
        Node temp = head;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m + 1; j++) {
                temp = head;
                head = head.getNext();
            }
            array.add(head.index);
            temp.setNext(head.getNext());
            head = head.getNext();
        }

        for (int i = 0; i < array.size(); i++) {
            System.out.println("Item " + i + ": " + array.get(i));
        }
    }
}



class Node {
    static private int length = 0;
    int index;
    Node next;
    Node() {
        length++;
        index = length;
    }

    public int getLength() {
        return length;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}