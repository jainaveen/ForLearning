package LinkedList;

public class LinkedListClass {

    public boolean searchKey(int n, Node head, int key) {
        // Code here
        Node node = head;
        while(node != null) {
            if(node.data == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public Node reverseList(Node head) {
        Node res = null;
        res = helper(head, res);
        while(res != null) {
            System.out.println(res.data);
            res = res.next;
        }
        return res;
    }

    public Node helper(Node head, Node res) {
        if(head.next == null) {
            Node n = new Node(head.data);
            n.next = res;
            res = n;
            return res;
        }
        if(res  == null) {
            res = new Node(head.data);
        } else {
            Node n = new Node(head.data);
            n.next = res;
            res = n;
        }
        res = helper(head.next, res);
        return res;
    }

    public  Node sortedMerge(Node head1, Node head2) {
        Node dummyNode = new Node(0); // Dummy node for the merged list
        Node curr = dummyNode;

        // Traverse both lists
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next; // Move the pointer forward
        }

        // Attach the remaining nodes
        curr.next = (head1 != null) ? head1 : head2;

        return dummyNode.next; // Return the merged list
    }

    public Node removeNthNodeFromEnd(Node head, int n) {
        Node curr = head;
        int count = 0;
        while(curr !=null) {
            count++;
            curr = curr.next;
        }
        curr = head;
        for(int i = 0; i < count - n-1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    public void display(Node head) {
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }


    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    //https://leetcode.com/problems/reverse-linked-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
    public Node reverseBetween(Node head, int left, int right) {
        Node dummy  = new Node(0);

        dummy.next = head;
        Node prev = dummy;

        // Move `prev` to the node before the `left` position
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Reverse the sublist from `left` to `right`
        Node curr = prev.next;
        Node next = null;

        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            Node temp = next.next;
            curr.next = temp;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }

    static class Node {
        int data;
        Node next;
        Node(int d)  {
            data = d;
            next = null;
        }

        Node() {

        }
    }
}
