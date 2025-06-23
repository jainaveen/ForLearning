package LinkedList;

public class DoublyLL {
    Node head;
    Node tail;
    int size;
    public DoublyLL() {
        this.size =0;
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        if(head != null) {
            head.prev = node;
        }
        node.next = head;
        head = node;
        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if(tail == null) {
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
            tail = temp;
        }
        System.out.println("END");
    }


    private class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }

    }
}
