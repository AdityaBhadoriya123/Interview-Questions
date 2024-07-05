package miscellaneous;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByDepartmentInJava {

    public static void main(String[] args) {
//        groupByDepartment();
        groupByDepartmentName();
    }

    public static void groupByDepartment() {
        List<Employee> employees = MiscDemo.getEmployees();

        employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())))
                .forEach((dept, names) -> {
                    System.out.println("Deptartment: " + dept);
                    names.forEach(name -> System.out.println("Name: " + name));
                });
    }

    public static void groupByDepartmentName() {
        List<Employee> employees = MiscDemo.getEmployees();

        employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())))
                .forEach((key, value) -> System.out.println(key + ":" + value));sr

    }
}
