public class Problem86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummpHead1 = new ListNode(0);
        ListNode dummpHead2 = new ListNode(0);
        ListNode index1 = dummpHead1, index2 = dummpHead2, temp = head;
        while (temp != null) {
            if (temp.val < x) {
                index1.next = temp;
                index1 = index1.next;
            } else {
                index2.next = temp;
                index2 = index2.next;
            }
            temp = temp.next;
        }
        index1.next = dummpHead2.next;
        index2.next = null;
        return dummpHead1.next;
    }
}
