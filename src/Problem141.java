public class Problem141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode one = head, two = head.next;
        while (one != null && two != null && one != two) {
            one = one.next;
            two = two.next;
            if (two != null)
                two = two.next;
        }
        return one == two;
    }
}
