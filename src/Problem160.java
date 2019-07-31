public class Problem160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLenth(headA);
        int len2 = getLenth(headB);
        if (len1 == 0 | len2 == 0)
            return null;
        while (len1 > len2) {
            len1--;
            headA = headA.next;
        }
        while (len1 < len2) {
            len2--;
            headB = headB.next;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLenth(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
