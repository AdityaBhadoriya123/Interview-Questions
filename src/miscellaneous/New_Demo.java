package miscellaneous;
import java.util.HashSet;
import java.util.Set;

public class New_Demo {

    public static void main(String[] args) {

        Empl employeeOne = new Empl();
        employeeOne.name = "Shubham";
        Empl employeeTwo = new Empl();
        employeeTwo.name = "Rajul";
        Set<Empl> set = new HashSet<>();
        set.add(employeeOne);
        set.add(employeeTwo);
        System.out.println(set.size());



    }
}

class Empl {
    String name;
    @Override
    public int hashCode() {
        return 31;
    }
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
