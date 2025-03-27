//   Definition for singly-linked list.

class RemoveElements {

    class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // handle the head node
        while (head != null && head.val == val) {
            dummy.next = head.next;
            head = head.next;
        }

        // handle target nodes in the middle
        ListNode prev = new ListNode(0);
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }

        return dummy.next;
    }

}
