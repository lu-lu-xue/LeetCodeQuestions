
class MyLinkedList {

    private int size;
    private ListNode head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode cur = head.next;
        int i = 0;
        while (i < index) {
            cur = cur.next;
            i++;
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head.next;
        head.next = newHead;
        size++;
    }

    public void addAtTail(int val) {
        ListNode newHead = new ListNode(val);
        if (size == 0) {
            head.next = newHead;
            size++;
            return;
        }
        ListNode cur = head.next;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newHead;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        int i = 0;
        ListNode prev = null;
        ListNode cur = head.next;
        while (i < index) {
            prev = cur;
            cur = cur.next;
            i++;
        }

        ListNode newNode = new ListNode(val);

        newNode.next = prev.next;
        prev.next = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = head.next;
        if (index == 0) {
            head.next = cur.next;
            cur.next = null;
            size--;
            return;
        }

        int i = 0;
        ListNode prev = null;

        while (i < index) {
            prev = cur;
            cur = cur.next;
            i++;
        }

        prev.next = cur.next;
        cur.next = null;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
