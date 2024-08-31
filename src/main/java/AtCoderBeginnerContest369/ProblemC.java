package AtCoderBeginnerContest369;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemC {

    public static void main(String[] args) {
        /*
        Find the number of pairs of integers (l,r) satisfying 1≤ l ≤ r ≤N

         */

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.println(n);
        scanner.nextLine();
        List<Integer> digits = Arrays.stream(scanner.nextLine().split(" "))
                .map(d -> Integer.parseInt(d))
                .collect(Collectors.toList());

        digits.forEach(System.out::println);
        int result = 0;

        for (int i = 0; i < digits.size(); i++) {
            for (int j = 0; j < digits.size(); j++) {
                System.out.println("i = " + i + ", j = " + j);
                if (i <= j) {

                    if (i == j) {
                        if (digits.get(i) > i) {
                            System.out.println("(" + (i + 1) + ", " + (j + 1) + ")");
                            result++;
                            continue;
                        }
                    }



                    int count = 0;

                    List<Integer> forCheck = new ArrayList<>(digits.subList(i, j + 1));
                    forCheck.forEach(d -> System.out.print(d + ", "));
                    System.out.println("");

                    if (forCheck.get(forCheck.size() - 1) < (forCheck.size() - 1)) {
                        System.out.println("In first block");
                        continue;
                    }

                    for (int k = 0; k < forCheck.size(); k++) {
                        int index = (k + 1);

                        if (index < forCheck.size()) {
                            int firstDigit = forCheck.get(index) - forCheck.get(k);
                            System.out.println("firstDigit = " + firstDigit);
                            System.out.println("In second block");
                            if (index < forCheck.get(k) &
                            forCheck.get(k) % firstDigit == 0 &
                            forCheck.get(index) % firstDigit == 0) {
                                System.out.println("In third block");
                                count++;
                            } else {
                                break;
                            }
                        } else {
                            if (index < forCheck.get(k)) {
                                count++;
                            }
                        }
                        if (count == forCheck.size()) {
                            System.out.println("(" + (i + 1) + ", " + (j + 1) + ")");
                            result++;
                        }
                    }
                }
            }
        }
        System.out.println("");
        System.out.println(result);
    }
}