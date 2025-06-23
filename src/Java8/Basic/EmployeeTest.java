package Java8.Basic;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTest {

    public static void main(String[] args) {

        // male and female employee in the organization
        Map<String, Long> noOfMaleAndFemaleEmployees =  getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmployees);

        //all departments in the organization
        getEmployeeList().stream().map(m->m.getDepartment())
                .distinct()
                .forEach(System.out::println);


        //avg age of male and female
        Map<String, Double> avgAgeOfMaleAndFemaleEmployees = getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(avgAgeOfMaleAndFemaleEmployees);

        //highest paid employee in the organization
        Optional<Employee> emp = getEmployeeList().stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(emp.get().name + " :: " + emp.get().salary);

        //names of all employees joined after 2015
        List<String> empList =getEmployeeList().stream()
                .filter(m->m.getYearOfJoining() > 2015)
                .map(m->m.getName())
                 .collect(Collectors.toList());
        System.out.println(empList);

        //count the number of employees in each department
        Map<String, Long> res =  getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(res);

        //avg salary of each department
        Map<String, Double> sal =getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(sal);

        //youngest male employee in the product development department
        Optional<Employee> nam = getEmployeeList().stream()
                .filter(m->m.getDepartment().equals("Product Development")  && m.getGender().equals("Male"))
                .min(Comparator.comparingInt(Employee::getAge));
        System.out.println(nam);

        //most working experience in the organization
        Optional<Employee> exp =getEmployeeList().stream()
                .min(Comparator.comparingInt(Employee::getYearOfJoining));
        System.out.println(exp);

        //male and female employees are there in the sales and marketing team?
        Map<String, Long> bygroup = getEmployeeList().stream()
                .filter(m->m.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(bygroup);

        System.out.println(getEmployeeList().stream()
                .collect(Collectors.groupingBy(m->m.getName(), Collectors.counting())));
    }

    public static List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 37000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        return employeeList;
    }
}
