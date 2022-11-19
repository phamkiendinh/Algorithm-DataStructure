public class p1 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        root.left = left;
        root.right = right;
        Node left1 = new Node(4);
        left.left = left1;   
        Node right2 = new Node(5);
        left1.right = right2;
        System.out.println("The binary tree's height is: " + root.traverse(root, 1));
    }
}


class Node {
    static Node root;
    Node left;
    Node right;
    int data;
    int height = 0;
    public Node() {}
    public Node(int data) {
        this.data = data;
    }

    public int traverse(Node root, int height) {
        if (root != null) {
            if (this.height < height) {
                this.height = height;
            }
            traverse(root.left, height + 1);
            traverse(root.right, height + 1);
        }
        return this.height;
    }
}