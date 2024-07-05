package streams;

import dto.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo {

    public void filterAndPrintList() {
        List<Employee> employeeList = getList();

        employeeList.stream()
                .filter(s -> s.getSalary() > 200)
                .forEach(System.out::println);

        employeeList.stream()
                .filter(e -> e.getName()
                        .startsWith("S"))
                .forEach(System.out::println);
    }

    public void mapList() {
        List<Employee> employeeList = getList();

        List<Integer> mapSalary = employeeList.stream()
                .map(s -> s.getSalary() + 100)
                .collect(Collectors.toList());
        System.out.println("Salary + 100: " + mapSalary);
    }

    public void duplicateElementsInList() {
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, "A", "B", "C", "D", "D", "D");

        List<String> uniqueList = new ArrayList<>();
        List<String> duplicateList = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (String element : stringList) {
            if (map.containsKey(element)) {
                int count = map.get(element);
                map.put(element, count +
                        1);
                duplicateList.add(element + count);
            } else {
                uniqueList.add(element);
                map.put(element, 1);
            }
        }

        System.out.println("Original List:" + stringList);
        System.out.println("Map:" + map);
        System.out.println("Unique List: " + uniqueList);
        System.out.println("Duplicate List: " + duplicateList);
    }

    public void sortList() {
        List<Employee> employeeList = getList();

        List<Employee> sortedListAscending = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
        List<Employee> sortedListDescending = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .reversed())
                .collect(Collectors.toList());

        List<Employee> sortedListDescendingAge = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge)
                        .reversed())
                .collect(Collectors.toList());

        System.out.println("Sorted List Ascending by Salary:" + sortedListAscending);
        System.out.println("Sorted List Descending by Salary:" + sortedListDescending);

        System.out.println("Sorted List Descending by Age:" + sortedListDescendingAge);
    }

    public void streamGroupingBy() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "D", "D"));

        Map<String, Long> mapWithCount = list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        Map<String, Long> collect = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Map:" + mapWithCount);
        System.out.println("Map with Functions.Identity:" + collect);
    }

    public void objectComparison() {
        Employee e1 = new Employee("Shubham", 100, 29);
        Employee e2 = new Employee("Shubham", 100, 29);

        if (e1 == e2) {
            System.out.println("e1==e2 Works for Comparison.");
        } else if (e1.equals(e2)) {
            System.out.println("e1.equals(e2) Works for Comparison.");
        } else {
            System.out.println("Comparison won't work like this.");
        }

        int i = e1.compareTo(e2);
        if (i == 0) {
            System.out.println("Object content is same.");
        }
    }

    public void treeSetDemo() {
        Set<Employee> employeeSet = new TreeSet<>();
        employeeSet.add(new Employee("Shubham", 100, 29));
        employeeSet.add(new Employee("Rajul", 200, 28));
        employeeSet.add(new Employee("Rakhi", 300, 27));

        System.out.println("TreeSet Size:" + employeeSet.size());

        for (Employee e : employeeSet) {
            System.out.println("Set:" + e);
        }
    }

    public void secondLargestListElement() {
        int[] intArray = {2, 3, 4, 3, 6, 3, 11, 18};
        List<Integer> integerList = new ArrayList<>();

        for (int i : intArray) {
            integerList.add(i);
        }

        System.out.println("Initial List:" + integerList);

        List<Integer> sortedList = integerList.stream()
                .sorted()
                .collect(Collectors.toList());
        List<Integer> sortedListDesc = integerList.stream()
                .sorted(Comparator.comparingInt(i -> (int) i)
                        .reversed())
                .collect(Collectors.toList());

        Optional<Integer> first = integerList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .findFirst();

        System.out.println("Sorted List:" + sortedList);
        System.out.println("Sorted List in Desc:" + sortedListDesc);
        System.out.println("2nd Largest Element:" + first);
    }

    public void printList() {
        List<Employee> employeeList = getList();
        employeeList.stream()
                .forEach(System.out::println);
    }

    public void sortListWithTwoParameters() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Shubham", 100, 29));
        employeeList.add(new Employee("Rajul", 200, 28));
        employeeList.add(new Employee("Rakhi", 300, 28));

        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);
    }

    public void listToMap() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Shubham", 100, 29));
        employeeList.add(new Employee("Rajul", 200, 28));
        employeeList.add(new Employee("Rakhi", 300, 28));

        Map<Integer, List<String>> listMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getName, Collectors.toList())));

        listMap.forEach((age, names) -> {
            System.out.println("Age:" + age);
            names.forEach(name -> System.out.println("Name:" + name));
        });

        System.out.println(listMap);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    private List<Employee> getList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Shubham", 100, 29));
        employeeList.add(new Employee("Rajul", 200, 28));
        employeeList.add(new Employee("Rakhi", 300, 27));

        return employeeList;
    }

    public static void main(String[] args) {
        StreamDemo streamDemo = new StreamDemo();
        streamDemo.filterAndPrintList();
        streamDemo.mapList();
        streamDemo.duplicateElementsInList();
        streamDemo.sortList();
        streamDemo.streamGroupingBy();
        streamDemo.objectComparison();
        streamDemo.treeSetDemo();
        streamDemo.secondLargestListElement();
        streamDemo.printList();
        streamDemo.sortListWithTwoParameters();
        streamDemo.listToMap();
    }
}
