import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummyHead = new ListNode(0);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);
        ListNode index = dummyHead;
        for (ListNode node : lists)
            if(node != null) queue.add(node);
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            index.next = temp;
            index = index.next;
            if (temp.next != null)
                queue.add(temp.next);
        }
        index.next = null;
        return dummyHead.next;
    }
}
