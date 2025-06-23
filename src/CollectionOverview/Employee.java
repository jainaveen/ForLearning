package CollectionOverview;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee Id : " + this.id + " Name: " + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


}
