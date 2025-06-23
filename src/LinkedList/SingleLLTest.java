package LinkedList;

public class SingleLLTest {

    public static void main(String[] args) {
        SingleLL singleLL = new SingleLL();

        singleLL.insertFirst(3);
        singleLL.insertFirst(6);
        singleLL.insertFirst(5);
        singleLL.insertFirst(19);
        singleLL.insertFirst(14);

        singleLL.insertLast(99);
        singleLL.insertLast(100);

        singleLL.insert(21, 2);
        singleLL.display();

        singleLL.deleteFirst();
        System.out.println("Delete first ");
        singleLL.display();

        singleLL.deleteLast();
        System.out.println("Delete Last ");
        singleLL.display();

        singleLL.delete(2);
        System.out.println("Delete based on index ");
        singleLL.display();


        singleLL.reverse();



        SingleLL first = new SingleLL();
        SingleLL second = new SingleLL();

        first.insertLast(1);
        first.insertLast(1);
        first.insertLast(5);
        first.insertLast(12);

        second.insertLast(4);
        second.insertLast(7);
        second.insertLast(8);
        second.insertLast(12);

        singleLL.merge(first, second);

    }
}
