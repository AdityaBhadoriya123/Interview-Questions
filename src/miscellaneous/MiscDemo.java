package miscellaneous;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

class MiscDemo {

    public static void main(String args[]) {

        List<String> names = new ArrayList<>();

        names.addAll(Arrays
                .asList("Alice", "Bob", "Charlie", "David",
                        "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack",
                        "Alice", "Bob", "Charlie", "David", "Emma",
                        "Frank", "Grace", "Henry", "Ivy", "Jack",
                        "Kate", "Liam", "Mia", "Noah", "Olivia",
                        "Patrick", "Quinn", "Rose", "Sam", "Tina",
                        "Uma", "Victor", "Wendy", "Xander", "Yara"
                        , "Jolly", "Jim", "Joseph", "jamil", "jignesh", "Ju"
                ));
        // give names starts with "J"
        List<String> names_with_J = names.stream()
                .filter(name -> name.toLowerCase().startsWith("j"))
                .collect(Collectors.toList());

//        System.out.println(names_with_J);

        List<Employee> ourEmployee = getEmployees();

        // Find out the count of male and female employees present in the organization
        // Map : --> {
        // Male: 4 ,
        // Female : 4 }

        Map<String, Long> genderWise_Count = ourEmployee.stream().
                collect(
                        groupingBy(
                                Employee::getGender,
                                Collectors.counting()
                        )
                );
//        System.out.println("\n Gender wise count\n"+genderWise_Count);


        //  Write a program to print the names of all departments in the organization

        List<String> all_dept_names = ourEmployee.stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toList());
//        System.out.println("\n All Dept. names: \n"+all_dept_names);


        // Find the average age of Male and Female Employees.
        // {
        // Male:25
        //   Female: 24
        //   }
        Map<String, Double> employee_Avg_age = ourEmployee.stream()
                .collect(
                        groupingBy(Employee::getGender,
                                averagingDouble(Employee::getAge))
                );
//        System.out.println("\n average age of Male and Female Employees \n"+employee_Avg_age);

        // Get the Names of employees who joined after 2015

        List<Employee> D_O_J = ourEmployee.stream()
                .filter(employee -> employee.getYearOfJoining() > 2015)
                .collect(Collectors.toList());
//        System.out.println("\n Names of employees who joined after 2015 \n"+D_O_J);


        // Count the number of employees in each department
        // {
        // HR:5,
        // IT:10,
        // Accounts:15
        // }

        Map<String, Long> emp_Each_dept = ourEmployee.stream()
                .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        )
                );
//        System.out.println("\n the number of employees in each department \n"+emp_Each_dept);


        //  Find out the average salary of each department.
        Map<String, Double> avg_sal_each_dept = ourEmployee.stream()
                .collect(
                        groupingBy(
                                Employee::getDepartment,
                                averagingDouble(Employee::getSalary)
                        ));
//        System.out.println("\n the average salary of each department \n"+avg_sal_each_dept);


        // Find out the oldest employee, his/her age and department

        Optional<Employee> maxAgeEmployee =
                ourEmployee.stream()
                        .max(Comparator.comparingInt(Employee::getAge));

//        System.out.println("\n the max age employee: \n"+maxAgeEmployee);


        // Find out the average and total salary of the organization.

        DoubleSummaryStatistics Avg_Total_sal = ourEmployee.stream()
                .collect(summarizingDouble(Employee::getSalary));

//        System.out.println("\n Total and Avg Salary of organization: \n"+Avg_Total_sal);


        // List down the employees of each department.

        Map<String, Map<Integer, List<Employee>>> emp_each_depart = ourEmployee.stream()
                .collect(groupingBy(Employee::getDepartment,
                                groupingBy(Employee::getId)
                        )
                );
//        System.out.println("\n the employees of each department: \n"+emp_each_depart);


        // Find out the highest experienced employee in the organization

        Optional<Employee> senior_Employees =
                ourEmployee.stream().
                        sorted(Comparator.
                                comparingInt(Employee::getYearOfJoining))
                        .findFirst();
        System.out.println("\n the senior most employee is: \n" + senior_Employees);


        // Find out the second-highest experienced employee in the organization
        Optional<Employee> second_senior_Employee =
                ourEmployee.stream().
                        sorted(Comparator.
                                comparingInt(Employee::getYearOfJoining))
                        .skip(1)
                        .findFirst();
        System.out.println("\n the second senior most employee is: \n" + second_senior_Employee);


        //the senior most employees of each department

        Map<String, List<Employee>> collect = ourEmployee.stream()
                .sorted(Comparator
                        .comparingInt(Employee::getYearOfJoining))

                .collect(groupingBy(Employee::getDepartment,
                        toList())
                );

        System.out.println("\n the senior most employees of each department: \n" + collect);


        // Find out the second-highest experienced employee in each department
        Map<String, List<Employee>> second_highest_experienced_employees = ourEmployee.stream().
                sorted(Comparator.
                        comparingInt(Employee::getYearOfJoining))
                .skip(1)
                .collect(groupingBy(Employee::getDepartment,
                                toList()
                        )
                );
        System.out.println("\n the second-highest experienced employee in each department: \n" + second_highest_experienced_employees);


    }


    public static List<Employee> getEmployees() {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
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


