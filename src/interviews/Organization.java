package interviews;

import dto.Employee;

import java.util.ArrayList;
import java.util.List;

public class Organization {

    public void demo() {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Shubham", 100, 29));
        employeeList.add(new Employee("Rajul", 200, 28));
        employeeList.add(new Employee("Rakhi", 300, 28));

    }

    public static void main(String[] args) {
        Organization organization = new Organization();
        organization.demo();
    }
}
