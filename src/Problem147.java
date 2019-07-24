public class Problem147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(0);

        while (head != null) {
            ListNode temp = head.next;
            ListNode pre = dummyHead;
            while (pre.next != null && pre.next.val < head.val)
                pre = pre.next;
            head.next = pre.next;
            pre.next = head;
            head = temp;
        }
        return dummyHead.next;
    }
}
