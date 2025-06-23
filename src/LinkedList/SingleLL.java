package LinkedList;

public class SingleLL {

    private Node head;
    private Node tail;

    private int size;

    SingleLL() {
        this.size = 0;
    }

    public void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;

        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void deleteFirst(){
        if(head != null) {
            Node temp = head;
            head = temp.next;
            size--;
        }
        if(head == null) {
            tail = null;
        }
    }

    public void deleteLast(){
        if(size <= 1) {
            deleteFirst();
            return;
        }
        Node secondLast = getNode(size-2);
        tail = secondLast;
        tail.next = null;
    }
    
    public Node getNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void insertLast(int data) {
        if(tail == null) {
            insertFirst(data);
            return;
        }
        Node node = new Node(data);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int data, int index) {
        if(size == 0) {
            insertFirst(data);
            return;
        }
        if(size == index) {
            insertLast(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(data,temp.next);
        temp.next = node;
        size++;
    }

    public void delete(int index) {
        if(index == 0) {
            deleteFirst();
            return;
        }
        if(index == size-1) {
            deleteLast();
            return;
        }

        Node prevNode = getNode(index - 1);

        prevNode.next = prevNode.next.next;
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node temp = prev;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public  void merge(SingleLL l1, SingleLL l2) {
        Node first = l1.head;
        Node second = l2.head;

        SingleLL res = new SingleLL();
        while(first != null && second != null) {
            if(first.data < second.data) {
                res.insertLast(first.data);
                first = first.next;
            } else {
                res.insertLast(second.data);
                second = second.next;
            }
        }

        while(first != null) {
            res.insertLast(first.data);
        }

        while(second != null) {
            res.insertLast(second.data);
        }
        Node temp = res.head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }

    private class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node node) {
            this.data = data;
            this.next = node;
        }
    }
}
