package LinkedList;

public class DoublyLLTest {
    public static void main(String[] args) {
        DoublyLL singleLL = new DoublyLL();

        singleLL.insertHead(3);
        singleLL.insertHead(6);
        singleLL.insertHead(5);
        singleLL.insertHead(19);
        singleLL.insertHead(14);

        singleLL.display();
    }
}
