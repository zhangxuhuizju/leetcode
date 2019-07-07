public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first, second, dummyHead, pre;
        dummyHead = new ListNode(0);
        dummyHead.next = head;
        first = second = head;
        pre = dummyHead;
        while (n-- > 0) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
            pre = pre.next;
        }
        pre.next = second.next;
        return dummyHead.next;
    }
}
