package HitachiVantaraProgrammingContest2024;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {
        Deque<Integer> cards = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        String[] counts = scanner.nextLine().split(" ");
        String stringCards = scanner.nextLine();
        int countOfCards = 0;
        int countOfTakesCards = 0;
        for (int i = 0; i < counts.length; i++) {
            countOfCards = Integer.valueOf(counts[0]);
            countOfTakesCards = Integer.valueOf(counts[1]);
        }

        for (String card : stringCards.split(" ")) {
            cards.add(Integer.valueOf(card));
        }

        for (int i = 0; i < countOfTakesCards; i++) {
            int card = cards.pollLast();
            cards.addFirst(card);
        }

        int count = 0;
        for (Integer card : cards) {
            if (count == 0) {
                System.out.print(card);
            } else {
                System.out.print(" " + card);
            }
            count++;
        }
    }
}
