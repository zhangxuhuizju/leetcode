import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

public class Problem138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap();
        Node node = head;
        while (node != null) {
            Node newHead = new Node(node.val, null, null);
            map.put(node, newHead);
            node = node.next;
        }
        node = head;
        while (node != null) {
            Node q = map.get(node);
            q.next = map.get(node.next);
            q.random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
