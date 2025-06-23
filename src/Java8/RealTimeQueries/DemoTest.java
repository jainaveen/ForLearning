package Java8.RealTimeQueries;

import java.util.*;
import java.util.stream.Collectors;

public class    DemoTest {
    static List<Employee> employeeList = new ArrayList<Employee>();
    static {
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0, "TT", new Address(123, "BA", "KA")));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0,"TT", new Address(123, "BA", "KA")));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0,"TT", new Address(123, "BA", "KA")));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0,"TT",new Address(123, "BA", "KA")));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0,"TT", new Address(123, "BA", "KA")));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0,"TT", new Address(123, "BA", "KA")));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0,"TT", new Address(123, "BA", "KA")));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0,"TT", new Address(123, "BA", "KA")));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0,"TT", new Address(123, "BA", "KA")));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5,"TT", new Address(123, "BA", "KA")));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0,"TT", new Address(123, "BA", "KL")));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0,"TH", new Address(123, "BA", "KL")));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0,"TH", new Address(123, "BA", "KL")));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5,"TH", new Address(123, "BA", "KL")));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0,"TH", new Address(123, "BA", "KL")));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0,"TH", new Address(123, "BA", "KL")));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0,"TH", new Address(123, "BA", "KL")));
    }

    public static void main(String[] args) {

        System.out.println("Total salary of all the employees");

        System.out.println(employeeList.stream()
                        .collect(Collectors.summingDouble(Employee::getSalary)));

        employeeList.stream().filter(m->m.getAddress().getState().equals("KL"))
                        .collect(Collectors.toList());

        System.out.println("***Group the Employees by Department***");
        employeeList.stream()
                .collect(Collectors.groupingBy(m->m.getDepartment()))
                .entrySet().stream().forEach(System.out::println);

        System.out.println("***List down the unique Department in sorted manner***");
        employeeList.stream()
                .map(m->m.getDepartment())
                .distinct().sorted().collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("****Sort a List of Employees by Salary in Descending Order****");

        //Sort a List of Employees by Salary in Descending Order
        employeeList.stream()
                .sorted(Comparator.comparing(m->-m.getSalary()))
                        .collect(Collectors.toList())
                                .forEach(System.out::println);

        System.out.println("******Grouping employees based on gender count*******");

        //male and female employees
        employeeList.stream()
                .collect(Collectors.groupingBy(m->m.getGender(),Collectors.counting()))
                        .entrySet().stream().forEach(System.out::println);


        //average age of male and female
        System.out.println(employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.averagingDouble(Employee::getAge))));

        //highest paid employee
        System.out.println(employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .get());

        System.out.println(employeeList.stream()
                .sorted(Comparator.comparingDouble(m->m.getSalary()))
                        .findFirst()
                .get());

        //highest paid employee in each department
        System.out.println("highest paid employee in each department " + employeeList.stream()
                .collect(Collectors.groupingBy(m->m.getDepartment(), Collectors.maxBy(Comparator.comparing(m->m.getSalary())))));

        //Employees joined after 2015
        employeeList.stream()
                .filter(m->m.yearOfJoining>2015)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //Count of employees in each department
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((s, aLong) -> System.out.println(s + " " + aLong) );

        //average salary of each department
        employeeList.stream()
                .collect(Collectors.groupingBy
                        (Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((s, aDouble) -> System.out.println(s + " " + aDouble));

        //youngest male employee in product development team
        System.out.println(employeeList.stream()
                .filter(f->f.getDepartment().equals("Product Development"))
                .min(Comparator.comparing(Employee::getAge))
                .get());

        //most working experience
        System.out.println("most working experience " + employeeList.stream()
                .min(Comparator.comparing(Employee::getYearOfJoining))
                .get());

        //names of employees in each department
       // Map<String,List<String>> map =
                employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())))
                        .entrySet().stream().forEach(System.out::println);


        //map.forEach((key, value) -> System.out.println(key + "" + value));

        //Average salary and total salary
        DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(doubleSummaryStatistics.getAverage() + " " +doubleSummaryStatistics.getSum());

        //Separate employees who are older than 25 years and younger or equal to 25 years
        Map<Boolean, List<Employee>> listMap = employeeList.stream()
                .collect(Collectors.partitioningBy(age->age.getAge() <= 25));
           for(Map.Entry<Boolean,List<Employee>>  entry : listMap.entrySet()) {
               if(entry.getKey()) {
                   System.out.println("--------younger boys-------");
               } else {
                   System.out.println("--------Older boys---------");
               }
               List<Employee> list = entry.getValue();
               for(Employee val : list) {
                   System.out.println(val.getName());
               }
           }
        System.out.println("---");

    }



}
