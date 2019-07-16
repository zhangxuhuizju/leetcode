import java.util.*;

public class Problem133 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.get(node.val) != null)
            return map.get(node.val);
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(newNode.val, newNode);
        for (Node neighbor: node.neighbors)
            newNode.neighbors.add(cloneGraph(neighbor));
        return newNode;
    }
}
