
class RemoveNthFromEnd {

    class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0 || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        // move n+1 steps
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // move the slow and fast together
        ListNode slow = dummy;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // after fast reaches the null
        // slow is the node before the last nth node
        slow.next = slow.next.next;
        return dummy.next;
    }
}
