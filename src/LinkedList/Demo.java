package LinkedList;

public class Demo {
    public static void main(String[] args) {
        LinkedListClass.Node node = new LinkedListClass.Node(1);
        node.next = new LinkedListClass.Node(2);
        node.next.next = new LinkedListClass.Node(3);
        node.next.next.next = new LinkedListClass.Node(4);
        LinkedListClass ll = new LinkedListClass();
        System.out.println(ll.searchKey(4, node,3));

        ll.reverseList(node);

        LinkedListClass.Node a = new LinkedListClass.Node(5);
        a.next = new LinkedListClass.Node(10);
        a.next.next = new LinkedListClass.Node(15);
        a.next.next.next = new LinkedListClass.Node(40);

        LinkedListClass.Node b = new LinkedListClass.Node(2);
        b.next = new LinkedListClass.Node(3);
        b.next.next = new LinkedListClass.Node(20);

        System.out.println(ll.sortedMerge(a,b));

        LinkedListClass.Node remove = new LinkedListClass.Node(5);
        remove.next = new LinkedListClass.Node(10);
        remove.next.next = new LinkedListClass.Node(15);
        remove.next.next.next = new LinkedListClass.Node(40);

        LinkedListClass.Node res = ll.removeNthNodeFromEnd(remove, 2);
        ll.display(res);

        // Easy - Has cycle
        LinkedListClass.Node head = new LinkedListClass.Node(1);
        LinkedListClass.Node second = new LinkedListClass.Node(2);
        LinkedListClass.Node third = new LinkedListClass.Node(3);
        LinkedListClass.Node fourth = new LinkedListClass.Node(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        LinkedListClass cycle = new LinkedListClass();
        System.out.println(cycle.hasCycle(head));


        LinkedListClass.Node n1 = new LinkedListClass.Node(5);
        LinkedListClass.Node n2 = new LinkedListClass.Node(6);
        LinkedListClass.Node n3 = new LinkedListClass.Node(7);
        LinkedListClass.Node n4 = new LinkedListClass.Node(8);
        LinkedListClass.Node n5 = new LinkedListClass.Node(9);
        LinkedListClass.Node n6 = new LinkedListClass.Node(10);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        LinkedListClass reverse = new LinkedListClass();
        LinkedListClass.Node res1 = reverse.reverseBetween(n1, 2 ,4);
        LinkedListClass.Node temp = res1;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("END");

    }
}
