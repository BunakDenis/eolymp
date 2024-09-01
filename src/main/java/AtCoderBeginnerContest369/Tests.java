package AtCoderBeginnerContest369;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tests {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.next());

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(sc.next()));
        }

        long answer = 0;
        int right = 0;
        for (int left = 0; left < n; left++) {
            while (right < n) {
                if (right > left + 1 && a.get(right) - a.get(right - 1) != a.get(right - 1) - a.get(right - 2)) {
                    break;
                }

                right++;
            }

            answer += right - left;
        }

        System.out.println(answer);
    }
}
