import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Tree
 */
public class Tree {

    class Node {
        int val;
        Node left;
        Node right;
    };

    private Node root;

    public void BinaryTree() {

        root = CreateTree();
    }

    Scanner sc = new Scanner(System.in);

    public Node CreateTree() {

        int item = sc.nextInt();
        Node nn = new Node();
        nn.val = item;

        Boolean hlc = sc.nextBoolean();
        if (hlc) {
            nn.left = CreateTree();
        }
        Boolean hrc = sc.nextBoolean();
        if (hrc) {
            nn.right = CreateTree();
        }

        return nn;
    }

    public void Display() {
        Display(this.root);
    }

    private void Display(Node node) {
        if (node == null) {
            return;
        }

        String s = "";
        s = s + node.val;
        s = "<-" + s + "->";

        if (node.left != null) {
            s = node.left.val + s;
        } else {
            s = "." + s;
        }
        if (node.right != null) {
            s = s + node.right.val;
        } else {
            s = s + ".";
        }
        System.out.println(s);
        Display(node.left);
        Display(node.right);

    }

    public boolean find(int item) {
        return find(this.root, item);
    }

    private boolean find(Node node, int item) {

        if (node == null) {
            return false;
        }
        if (node.val == item) {
            return true;
        }

        boolean lf = find(node.left, item);
        boolean rf = find(node.right, item);

        return lf || rf;
    }

    public int max() {
        return max(this.root);
    }

    private int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int Left = max(node.left);
        int Right = max(node.right);

        return Math.max(node.val, Math.max(Left, Right));
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        return Math.max(lh, rh) + 1;

    }

    public void preorder() {
        preorder(this.root);
    }

    private void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);

    }

    public void postorder() {
        postorder(this.root);
    }

    private void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");

    }

    public void inorder() {
        inorder(this.root);
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);

    }

    public void levelorder() {
        levelorder(this.root);
    }

    private void levelorder(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node rv = q.poll();
            System.out.print(rv.val + " ");
            if (rv.left != null) {
                q.add(rv.left);
            }
            if (rv.right != null) {
                q.add(rv.right);
            }
        }
        System.out.println();
    }

    public void Pre_order() {
        Pre_order(this.root);
    }

    private void Pre_order(Node node) {
        if (node == null) {
            return;

        }
        Stack<Node> st = new Stack<>();
        st.push(node);
        while (!st.isEmpty()) {
            Node rv = st.pop();
            System.out.print(rv.val + " ");
            if (rv.right != null) {
                st.push(rv.right);
            }
            if (rv.left != null) {
                st.push(rv.left);
            }
        }
        System.out.println();

    }
}