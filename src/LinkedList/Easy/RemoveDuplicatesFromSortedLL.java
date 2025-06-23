package LinkedList.Easy;

public class RemoveDuplicatesFromSortedLL {

    static ListNode head;

    public static void deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while(temp.next != null) {
           if(temp.val == temp.next.val) {
               temp.next = temp.next.next;
           } else {
               temp = temp.next;
           }
        }
        ListNode res = head;
        while(res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("End");
    }

    public static void main(String[] args) {
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("End");

        deleteDuplicates(head);
    }
    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


}
