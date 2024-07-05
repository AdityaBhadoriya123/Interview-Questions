package strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringDemo {

    public void convertStringToMap() {
        String s = "Shubham:1010|Rajul:1011";

        Map<String, Integer> map = new HashMap<>();

        String[] pairs = s.split("\\|");

        for (String pair : pairs
        ) {
            String[] parts = pair.split(":");

            if (parts.length == 2) {
                String name = parts[0];
                int number = Integer.parseInt(parts[1]);
                map.put(name, number);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()
        ) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }

    public void reverseString() {
        String name = "Shubham";
        StringBuilder stringBuilder = new StringBuilder(name);
        System.out.println("Original String:" + name + " | Reversed String:" + stringBuilder.reverse());
    }

    public void stringOccurrence() {
        String string = "ABBCCCDDDDE";
        StringBuilder stringBuilder = new StringBuilder();
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            stringList.add(String.valueOf(string.charAt(i)));
        }

        Map<String, Long> stringMap = stringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry<String, Long> map : stringMap.entrySet()
        ) {
            stringBuilder.append(map.getKey()).append(map.getValue());
        }

        System.out.println(stringList);
        System.out.println(stringMap);
        System.out.println(stringBuilder);
    }

    public void demo() {

        int[] intArray = {2, 3, 4, 3, 6, 3, 11, 18};
        List<Integer> integerList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap();

        for (int i : intArray
        ) {
            integerList.add(i);
        }

        System.out.println("Initial List:" + integerList);

        for (Integer i : integerList) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                map.put(i, count + 1);
            } else {
                map.put(i, 1);
            }
        }

        System.out.println("Map: " + map);

        for (Map.Entry m : map.entrySet()) {
            if (m.getValue().equals(1)) {
                resultList.add((Integer) m.getKey());
            }
        }

        Collections.sort(resultList);
        System.out.println("List:" + resultList);

        for (Map.Entry m : map.entrySet()) {
            if ((Integer) m.getValue() > 1) {
                Integer i = (Integer) m.getValue();
                while (i > 0) {
                    resultList.add((Integer) m.getKey());
                    i--;
                }
            }
        }

        System.out.println("List:" + resultList);

    }

    public static void main(String[] args) {
        StringDemo stringDemo = new StringDemo();
        stringDemo.convertStringToMap();
        stringDemo.reverseString();
        stringDemo.stringOccurrence();
    }
}
