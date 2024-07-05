package miscellaneous;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class MapIterationDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        map.put("Aditya",1);
        map.put("Shubham",2);

        map.entrySet()
                .forEach((k)-> System.out.println(k.getKey()+" : "+k.getValue()));


    }
}
