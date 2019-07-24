public class Problem143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode dummyHead1 = new ListNode(0);
        dummyHead1.next = head;
        ListNode dummyHead2 = new ListNode(0);
        ListNode one = dummyHead1, two = dummyHead1;
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }
        dummyHead2.next = one.next;
        one.next = null;
        reverse(dummyHead2);
        head = dummyHead1.next;
        dummyHead2 = dummyHead2.next;
        ListNode index = dummyHead1;
        while (dummyHead2 != null) {
            index.next = head;
            index = index.next;
            head = head.next;
            index.next = dummyHead2;
            index = index.next;
            dummyHead2 = dummyHead2.next;
        }
        index.next = head;
        head = dummyHead1.next;
    }

    private void reverse(ListNode dummyHead) {
        ListNode head = dummyHead.next;
        dummyHead.next = null;
        ListNode temp = head;
        while (head != null) {
            temp = head.next;
            head.next = dummyHead.next;
            dummyHead.next = head;
            head = temp;
        }
    }
}
