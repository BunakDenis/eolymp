package AtCoderBeginnerContest369;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        List<Integer> x = new ArrayList<>();
        List<Integer> result = new ArrayList<>();


        x.add((2 * a) - b);
        x.add((a + b) / 2);
        x.add((2 * b) - a);

        x.forEach(v -> {
                    if ((v - a == b - v) ||
                            (a - v == b - a) ||
                            (b - a == v - b)) {
                        if (!result.contains(v)) {
                            result.add(v);
                        }
                    }
                }
        );
        System.out.println(result.size());
    }
}


