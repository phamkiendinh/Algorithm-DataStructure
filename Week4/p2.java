/*
 * Implement the insert operation for a BST of integers.
 * You can insert the following values to test your implementation: 4, 2, 8, 3, 1, 7, 9, 6, 5
 * Also, implement the search operation on the BST. Count the number of comparisons to reach an answer.
 */
public class p2 {
    public static void main(String[] args) {
        //Insert 4 2 8 3 1 7 9 6 5
        Node root = new Node(4);
        root.insert(root, 2);
        root.insert(root, 8);
        root.insert(root, 3);
        root.insert(root, 1);
        root.insert(root, 7);
        root.insert(root, 9);
        root.insert(root, 6);
        root.insert(root, 5);

        root.inOrderRecursive(root);

        System.out.println(root.search(root, 5) == 1 ? "Found the number\n" : "Couldn't find the number\n");
    }
}


class Node {
    static Node root;
    Node parent;
    Node left;
    Node right;
    int data;

    public Node() {}
    public Node(int data) {
        this.data = data;
    }

    public void insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        }
        else {
            Node parent = null;
            Node current = root;
            while (current != null) {
                if (data < current.data) {
                    parent = current;
                    current = current.left;
                }
                else if (data > current.data) {
                    parent = current;
                    current = current.right;
                }
                else {
                    return;
                }
            }
            if (data < parent.data) {
                parent.left = new Node(data);
                parent.left.parent = parent;
                System.out.println("Current left node is: " + parent.left.data + ", with parent is: " + parent.data + "\n");
            }
            else {
                parent.right = new Node(data);
                parent.right.parent = parent;
                System.out.println("Current right node is: " + parent.right.data + ", with parent is: " + parent.data + "\n");
            }
            return;
        }

    }

    public int search (Node root, int value) {
        Node current = root;
        int counter = 0;
        while (current != null) {
            System.out.println("Current is: " + current.data + "\n");
            if (value < current.data) {
                current = current.left;
                counter++;
                continue;
            }
            else if (value > current.data) {
                current = current.right;
                counter++;
                continue;
            }
            else {
                System.out.println("Went through " + counter + " steps to reach an answer\n");
                return 1;
            }
        }
        return 0;
    }


    public void visit(Node n) {
        System.out.println(n.data);
      }

    public void inOrderRecursive(Node root) {
        if (root == null) {
          return;
        }
        // traverse left
        inOrderRecursive(root.left);
        // visit
        // traverse right
        inOrderRecursive(root.right);
        visit(root);
    }
}