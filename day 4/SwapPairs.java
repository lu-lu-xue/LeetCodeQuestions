
class SwapPairs {

    class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = helper(head);
        return newHead;
    }

    private ListNode helper(ListNode n1){
        // base case
        if (n1 == null || n1.next == null){
            return n1;
        }

        ListNode n2 = n1.next;
        n1.next = helper(n2.next);
        n2.next = n1;

        return n2;
    }
}
