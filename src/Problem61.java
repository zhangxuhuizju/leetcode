public class Problem61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode index = head;
        int length = 1;
        while (index.next != null) {
            length++;
            index = index.next;
        }
        index.next = head;
        k = k % length;
        k = length - k - 1;
        index = head;
        while (k-- > 0) {
            index = index.next;
        }
        head = index.next;
        index.next = null;
        return head;
    }
}
