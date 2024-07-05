package streams;

import java.util.*;
import java.util.stream.Collectors;

public class FirstNonRepeatedString {

    public static void main(String[] args) {
        String[] strings = {"Aditya", "Priyanshu", "Aditya", "Rajul", "Rajul", "Shubham",
                "Alice", "Bob", "Charlie", "David",
                "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack",
                "Alice", "Bob", "Charlie", "David", "Emma",
                "Frank", "Grace", "Henry", "Ivy", "Jack",
                "Kate", "Liam", "Mia", "Noah", "Olivia",
                "Patrick", "Quinn", "Rose", "Sam", "Tina",
                "Uma", "Victor", "Wendy", "Xander", "Yara"
                , "Jolly", "Jim", "Joseph", "jamil", "jignesh", "Jyu"};
        printFirstNonRepeatedString(strings);
    }

    private static void printFirstNonRepeatedString(String[] strings) {

        Arrays.stream(strings)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(s -> s.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(System.out::println);


    }
}
