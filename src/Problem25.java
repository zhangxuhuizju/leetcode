public class Problem25 {
    /*
    !!!!!递归的写法，要会用啊啊啊啊啊啊！
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result, tail = head;
        for (int i = 0; i != k; ++i) {
            if (tail == null) return head;
            tail = tail.next;
        }
        result = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return result;
    }

    ListNode reverse (ListNode head, ListNode tail) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = tail == null ? null : tail.next;
        ListNode temp = head;
        while (temp != tail) {
            ListNode temp2 = temp.next;
            temp.next = dummyHead.next;
            dummyHead.next = temp;
            temp = temp2;
        }
        return dummyHead.next;
    }
}
