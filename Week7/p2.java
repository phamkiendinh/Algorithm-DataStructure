


/*
 * Problem 2A: Convert a sorted array into a balanced BST.
 * A reminder: a balanced binary tree is a binary tree in which the depths of the two subtrees of every node differ by no more than 1.
 * Problem 2B: Convert a sorted linked list into a balanced BST (you are not allowed to convert the list into an array first). 
 */
public class p2 {
    public static void main(String[] args) {
        //2A
        int[] array = {1,2,3,4,5,6,7,8,9};
        Node root = arrayToBST(array, 0, array.length - 1);
        preOrder(root);
        System.out.println();

        //2B
        Point p1 = new Point(1);
        Point p2 = new Point(2);
        Point p3 = new Point(3);
        Point p4 = new Point(4);
        Point p5 = new Point(5);
        Point p6 = new Point(6);
        Point p7 = new Point(7);
        Point p8 = new Point(8);
        Point p9 = new Point(9);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        p7.next = p8;
        p8.next = p9;
        p9.next = null;

        Point p = linkedlistToBST(p1, p9);
        preOrderList(p);
    }

    public static Node arrayToBST(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;

        Node parent = new Node(array[middle]);
        parent.left = arrayToBST(array, start, middle -  1);
        parent.right = arrayToBST(array, middle + 1, end);
        return parent;
    }
    public static void preOrder(Node node) {
        if (node == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void preOrderList(Point p) {
        if (p == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(p.value + " ");
        preOrderList(p.left);
        preOrderList(p.right);
    }

    public static Point linkedlistToBST(Point start, Point end) {
        Point temp = start;
        int length = 1;
        if (end.value == 0) {
            return start;
        }
        if (temp != null && end != null) {
            while(temp.value != end.value) {
                length++;
                temp = temp.next;
            }
        }
        Point parent = new Point();
        Point middle = start;
        int counter = 0;
        while (counter < length / 2 && middle.value != end.value) {
            counter++;
            parent = middle;
            middle = middle.next;
        }
        Point root = middle;
        System.out.println("Left: " + "\n");
        System.out.println("Middle: " + middle.value);
        root.left = linkedlistToBST(start, parent);
        System.out.println("Right: " + "\n");
        System.out.println("Middle: " + middle.value);
        System.out.println("Middle.next: " + middle.next.value);
        System.out.println("End: " + end.value);
        root.right = linkedlistToBST(middle.next, end);
        return root;
    }
}


class Point {
    int value;
    Point next;
    Point left;
    Point right;

    public Point() {}
    public Point(int value) {
        this.value = value;
        this.next = null;
        this.left = null;
        this.right = null;
    }
}

class Node {
    Node left;
    Node right;
    int value;

    public Node() {
        left = null;
        right = null;
        value = 0;
    }

    public Node(int value) {
        this.right = null;
        this.left = null;
        this.value = value;
    }
}