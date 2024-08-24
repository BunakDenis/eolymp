package HitachiVantaraProgrammingContest2024;

import java.util.*;

public class problemB {

    public static void main(String[] args) {
        LinkedList<Integer> digits = new LinkedList<>();
        int result = 0;
        Scanner scanner = new Scanner(System.in);

        int countOfDigits = Integer.valueOf(scanner.nextLine());
        String stringDigits = scanner.nextLine();

        for (String digit : stringDigits.split(" ")) {
            digits.add(Integer.valueOf(digit));
        }

        digits.sort(Integer::compareTo);
        Collections.reverse(digits);

        int firstDigit = digits.get(0);
        int secondDigit = digits.get(1);

        while (firstDigit > 0 & secondDigit > 0) {
            firstDigit = digits.pollFirst();
            secondDigit = digits.pollFirst();

            firstDigit--;
            secondDigit--;

            digits.addFirst(secondDigit);
            digits.addFirst(firstDigit);
            result++;
            digits.sort(Integer::compareTo);
            Collections.reverse(digits);
            firstDigit = digits.get(0);
            secondDigit = digits.get(1);
        }
        System.out.println(result);
    }
}