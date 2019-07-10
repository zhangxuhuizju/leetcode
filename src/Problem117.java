public class Problem117 {
    class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }
    public Node connect(Node root) {
        if (root == null) return root;
        Node pre = root, head = null, tail = null;
        root.next = null;
        while (pre != null) {
            while (pre != null) {
                if (pre.left != null) {
                    if (head == null) {
                        head = pre.left;
                        tail = head;
                    } else {
                        tail.next = pre.left;
                        tail = tail.next;
                    }
                }
                if (pre.right != null) {
                    if (head == null) {
                        head = pre.right;
                        tail = head;
                    } else {
                        tail.next = pre.right;
                        tail = tail.next;
                    }
                }
                pre = pre.next;
            }
            pre = head;
            head = null;
            tail = null;
        }
        return root;
    }
}
