package patterns;

import java.util.ArrayList;
import java.util.List;

public class PatternDemo {

    public void incrementNumbers() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public void findNextGreaterNumber(int input) {

        System.out.println("Input:" + input);
        List<Integer> digits = new ArrayList<>();
        int num = input;

        while (num > 0) {
            digits.add(num % 10);
            num = num / 10;
        }

        System.out.println("Digits:" + digits);

        int lowestGreaterDigit = 0;
        for (int i = 1; i <= 9; i++) {
            if (!digits.contains(i)) {
                lowestGreaterDigit = i;
                break;
            }
        }

        int result = 0;
        for (int digit : digits) {
            result = result * 10 + Math.max(digit, lowestGreaterDigit);
        }

        System.out.println("Result:" + result);
    }

    public static void main(String[] args) {
        PatternDemo patternDemo = new PatternDemo();
//        patternDemo.incrementNumbers();
        patternDemo.findNextGreaterNumber(654321);
    }
}
