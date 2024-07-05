package miscellaneous;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;
}
