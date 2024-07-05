package streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedInteger {

    public static void main(String[] args) {
        int [] integers = {2,1,2,3,3,4};
        printFirstNonRepeatedInteger(integers);

        // print first non-repeated integer number in above array.
    }

    private static void printFirstNonRepeatedInteger(int[] integers){
        Arrays.stream(integers)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue()==1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
