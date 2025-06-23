package CoreJava;

public class ShallowDeepExampleTest {

    public static void main(String[] args) {
        //Shallow copy
        Address  a1 = new Address("abc road");
        Person p1 = new Person("adithiyan", 10, a1);

        Person p2 = p1.shallowCopy();

        System.out.println(p1.address == p2.address);

       p2.address.name = "456 Elm St";  // Modify address through p2
        System.out.println(p1.address.name);

        //deepcopy
        Address  a2 = new Address("abc road");
        Person p3 = new Person("adhavan", 10, a2);

        Person p4 = p3.deepCopy();

        System.out.println(p3.address == p4.address);

        p4.address.name = "456 Elm St";  // Modify address through p2
        System.out.println(p3.address.name);
    }
}
