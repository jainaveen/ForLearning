package LinkedList.Medium;

public class RemoveDuplicatesFromSortedListII {
   // https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
   public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  static ListNode head;

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII re = new RemoveDuplicatesFromSortedListII();
        re.head = new ListNode(1);
        re.head.next = new ListNode(1);
        re.head.next.next = new ListNode(1);
        re.head.next.next.next = new ListNode(2);
        re.head.next.next.next.next = new ListNode(3);
        deleteDuplicates(re.head);

        rotateList(re.head,2);
    }
    public static void deleteDuplicates(ListNode head) {
        ListNode dummy = head;
        ListNode res1 = new ListNode(0);
        ListNode res = res1;
        boolean flag = false;
        while(dummy.next != null) {
            if(dummy.val == dummy.next.val) {
                flag = true;
                dummy = dummy.next;
            } else if (dummy.val != dummy.next.val && flag) {
                flag = false;
                dummy = dummy.next;
            } else {
                ListNode node = new ListNode(dummy.val);
                res.next = node;
                res = res.next;
                flag = false;
                dummy = dummy.next;
            }
        }
        if(!flag) {
            ListNode node = new ListNode(dummy.val);
            res.next = node;
        }
    }

    public static void rotateList(ListNode head, int k) {

        ListNode last = head;
        int length = 1;

        while (last.next != null) {
            last = last.next;
            length++;
        }
        last.next = head;

        int rotations = k % length;
        int skip = length - rotations;
        ListNode newLast = head;

        for (int i = 0; i < skip-1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;
    }

}
