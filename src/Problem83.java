public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode index = head;
        head = head.next;
        while (head != null) {
            if (head.val == index.val) {
                head = head.next;
                continue;
            }
            index.next = head;
            head = head.next;
            index = index.next;
        }
        index.next = null;
        return dummyHead.next;
    }
}
