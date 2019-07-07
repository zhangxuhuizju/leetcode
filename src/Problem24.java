public class Problem24 {
    public ListNode swapPairs(ListNode head) {
        //边界条件一定要引起注意！！！
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode l1 = head, l2 = head.next, temp = dummyHead;
        while (l1 != null && l2 != null) {
            l1.next = l2.next;
            l2.next = l1;
            temp.next = l2;
            temp = l1;
            l1 = temp.next;
            l2 = l1 == null ? null : l1.next;
        }
        return dummyHead.next;
    }
}
