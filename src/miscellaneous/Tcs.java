package miscellaneous;

import java.util.HashSet;
import java.util.Set;
public class Tcs {

    public static void main(String[] args) {
        Emp empOne = new Emp();
        empOne.name = "Shubham";

        Emp empTwo = new Emp();
        empTwo.name = "Rajul";

        Set<Emp> set = new HashSet<>();
        set.add(empOne);
        set.add(empTwo);
        System.out.println(set.size());


    }
}
class Emp {
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
