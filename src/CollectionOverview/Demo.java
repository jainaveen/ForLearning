package CollectionOverview;

import CoreJava.ImmutableClass;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        Employee emp = new Employee(1,"nav");
        Employee emp2 = new Employee(1, "nav");

        // Set
        Set<Employee> set = new HashSet<>();
        set.add(emp);
        set.add(emp2);
        System.out.println(set);

        Map<Employee, String> map = new HashMap<>();
        map.put(emp," Add data into map ");

        System.out.println("before result " + map.get(emp2));

        map.put(emp2," modify the mapped data ");

        System.out.println("after result " + map.get(emp));

        //


    }
}
