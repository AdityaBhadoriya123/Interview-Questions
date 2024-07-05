package miscellaneous;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Epam {
    public static void main(String[] args) {
        String str = "adidas";
        printFirstNonRepeatedCharacter(str);
    }

    public static void printFirstNonRepeatedCharacter(String str) {
        str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().filter(v -> v.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .findFirst();
    }
}
