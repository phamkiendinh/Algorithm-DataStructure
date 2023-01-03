package Week3;

/*
 * Implement an algorithm to remove a loop from a Singly Linked List.
 * 
 */

public class p1 {
    public static void main(String[] args) {
        Node head = new Node();
        Node tail = new Node();
        Node n1 = head;
        Node n2 = head;
        Node meet = new Node();
        boolean isLoop = true;
        while (true) {
            if (n1 == n2) {
                meet = n1;
                break;
            }
            else {
                if (n1 == tail) {
                    isLoop = false;
                    break;
                }
                n1 = n1.getNext();//tortoise
                n2 = n2.getNext().getNext(); //hare
            }
        }
        
        if (isLoop) {
            Node n3 = head;
            Node loop = new Node();
            while (true) {
                if (n1 == n3) {
                    break;
                }
                else {
                    loop = n1;
                    n1 = n1.getNext();
                    n3 = n3.getNext();
                }
            }
            System.out.println("Loop is detected!");
            loop.setNext(tail);
        }
        else {
            System.out.println("There is no loop in this linked list.");
        }
    }
}


class Node {
    private int length;
    private Node next;

    Node () {
        this.length = 0;
    }


    public int getLength() {
        return this.length;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
}

/*
 * 
 * We are making an assumption that there is a loop inside a Singly Linked List, and we know the position where the loops begin.
 */


/*
 * We just need to detect the position where the loops begin, and then detach the node before the begin of the loop and attach it to the tail.
 */

