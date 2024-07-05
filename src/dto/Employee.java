package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee implements Comparable<Employee> {

    private String name;
    private int salary;
    private int age;

    @Override
    public int compareTo(Employee o) {
        return this.age - o.age;
    }
}
