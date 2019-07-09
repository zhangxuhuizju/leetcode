public class Problem116 {
    class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }
    public Node connect(Node root) {
        if (root == null) return root;
        Node layer = root, pre = root, index = root.left;
        root.next = null;
        while (index != null) {
            while (pre != null) {
                if (index == pre.left) {
                    index.next = pre.right;
                }else {
                    pre = pre.next;
                    index.next = pre == null ? null : pre.left;
                }
                index = index.next;
            }
            layer = layer.left;
            pre = layer;
            index = layer.left;
        }
        return root;
    }
}
