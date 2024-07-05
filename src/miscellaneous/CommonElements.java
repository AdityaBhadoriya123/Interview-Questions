package miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonElements {

    public static void main(String[] args) {
        // Example arrays
        Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {4, 5, 6, 7, 8};

        // Convert arrays to lists
        List<Integer> list1 = Arrays.asList(array1);
        List<Integer> list2 = Arrays.asList(array2);

        // Find common elements using Stream API
        Set<Integer> commonElements = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toSet());

        // Print common elements
        System.out.println("Common Elements: " + commonElements);
    }

}
