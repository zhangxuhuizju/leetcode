public class Problem142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode one = dummyHead.next, two = dummyHead.next.next;
        while (two != null && one != two) {
            one = one.next;
            two = two.next;
            if (two != null)
                two = two.next;
        }
        if (two == null)
            return null;
        one = dummyHead;
        while (one != two) {
            one = one.next;
            two = two.next;
        }
        return one;
    }
}
