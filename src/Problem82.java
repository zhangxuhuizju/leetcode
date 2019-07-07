public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        ListNode index = dummyHead;
        ListNode pre = head;
        head = head.next;
        while (head != null) {
            if (head.val == pre.val) {
                while (head != null && head.val == pre.val)
                    head = head.next;
                if (head == null) break;
            } else {
                index.next = pre;
                index = index.next;
            }
            pre = head;
            head = pre.next;
        }
        if (pre.next == null) {
            index.next = pre;
        } else index.next = null;
        return dummyHead.next;
    }
}
