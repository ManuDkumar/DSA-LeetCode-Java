class ListNode {
        ListNode next;
        int val;

        ListNode(int x) {
        his.val = x;
        this.next = null;
    } 
}

public class RemoveNthNodeFromEndOfList {
  public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1, null);
        ListNode front = dummy;
        ListNode back = dummy;
        if (n == 0) {
            return head;
        }
        front.next = head;
        while (n > 0 ) {
            front = front.next;
            n--;
        }
        while (front.next != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}
