public class Problem92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        // 找到翻转链表部分的前一个节点, 1->2->3->4->5->NULL, m = 2, n = 4 指的是 节点值为1
        for (int i = 0; i < m - 1; i++)
            pre = pre.next;
        // 用双指针,进行链表翻转
        ListNode reverse = null;
        ListNode cur = pre.next;
        for (int i = 0; i < n - m + 1; i++) {
            ListNode tmp = cur.next;
            cur.next = reverse;
            reverse = cur;
            cur = tmp;
        }
        // 将翻转部分 和 原链表拼接
        pre.next.next = cur;
        pre.next = reverse;
        return dummy.next;
    }
}
