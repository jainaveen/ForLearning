package LinkedList.Medium;

public class RemoveNthnode {

    //  https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-interview-150

    static ListNode head;

    public static void main(String[] args) {
        head = new RemoveNthnode.ListNode(1);
        head.next = new RemoveNthnode.ListNode(2);
        head.next.next = new RemoveNthnode.ListNode(3);
        head.next.next.next = new RemoveNthnode.ListNode(4);
        head.next.next.next.next = new RemoveNthnode.ListNode(5);

        removeNthFromEnd(head, 2);
    }

    public static void removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        int size = 0;
        while(temp.next !=null) {
            size++;
            temp = temp.next;
        }
        ListNode temp2 = dummy;
        for (int i = 0; i < size-n; i++) {
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
