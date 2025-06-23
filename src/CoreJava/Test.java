package CoreJava;

import CollectionOverview.Employee;

import java.io.*;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int id = 1;
        String name = "naveen";
        HashMap<Integer, String> map1 = new HashMap<>(); //local
        map1.put(11, "audi");
        ImmutableClass immutableClass = new ImmutableClass(id, name, map1);

        System.out.println("----Display ImmutableClass members before changing----");
        System.out.println(immutableClass.getName());  //
        System.out.println(immutableClass.getId());        // 1
        System.out.println(immutableClass.getMap());
        System.out.println(immutableClass.getMap().hashCode());//

        //Comparing ImmutableClass members with local before changing
        System.out.println(name == immutableClass.getName());  //true
        System.out.println(id == immutableClass.getId());      //true
        System.out.println(map1 == immutableClass.getMap());

        id = 2;
        name = "ammu";
        map1.put(12, "adhavan");

        System.out.println("\n----Display ImmutableClass members after changing----");
        System.out.println(immutableClass.getName());  // "ankit"
        System.out.println(immutableClass.getId());        // 1
        System.out.println(immutableClass.getMap());   //{11=audi}
        System.out.println(immutableClass.getMap().hashCode());

        //Comparing ImmutableClass members with local after changing
        System.out.println(name == immutableClass.getName());  //false
        System.out.println(id == immutableClass.getId());      //false
        System.out.println(map1 == immutableClass.getMap());


        Employee e1 = new Employee(1, "ab");
        Employee e2 = new Employee(2, "cd");

        OutputStream os = new FileOutputStream("C:\\Learn\\PlanA\\src\\CollectionOverview\\ser.txt");
        ObjectOutput oo = new ObjectOutputStream(os);

        oo.writeObject(e1);
        oo.writeObject(e2);
        oo.close();
        System.out.println("Wrote object e1");

        InputStream is = new FileInputStream("C:\\Learn\\PlanA\\src\\CollectionOverview\\ser.txt");
        ObjectInput ois = new ObjectInputStream(is);
        Employee emp;
        try {
        while ((emp = (Employee) ois.readObject()) != null) {
            System.out.println(emp);
        }
        ois.close();
        } catch (EOFException e) {
            System.out.println("File ended");
        }


        CoreJava.Employee emp1 = new CoreJava.Employee("adhavan",12);
        System.out.println("Employee Name " + emp1.name());

    }
}
