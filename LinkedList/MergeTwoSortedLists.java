class ListNode {
        private ListNode next;
        int val;

        ListNode(int x) {
        his.val = x;
        this.next = null;
    } 
}

public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(-1, null);

        ListNode head = dummy;
       
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        if(list1 == null){
            head.next = list2;
        }else{
            head.next = list1;
        }
        return dummy.next;
    }
}
