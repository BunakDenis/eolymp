package problem11718;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Problem11718 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        scanner.nextInt();
        int numberOfeRequest = scanner.nextInt();
        scanner.nextLine();
        String word = scanner.nextLine();
        char[] letters = word.toCharArray();
        List<Integer> firstIndexes = new ArrayList<>();
        List<Integer> lastIndexes = new ArrayList<>();

        for (int i = 0; i < numberOfeRequest; i++) {
            firstIndexes.add(scanner.nextInt());
            lastIndexes.add(scanner.nextInt());
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < numberOfeRequest; i++) {
            int countOfConcurrence = 0;
            List<Integer> countOfConcurrrences = new ArrayList<>();
            List<Character> checkedLetters = new ArrayList<>();
            int startIndex = firstIndexes.get(i) - 1;
            int lastIndex = lastIndexes.get(i) - 1;

            for (int j = startIndex; j <= lastIndex; j++) {
                char letter = letters[j];
                int concurrence = 1;

                if (!checkedLetters.contains(letter)) {
                    for (int k = j + 1; k <= lastIndex; k++) {

                        if (letter == letters[k]) {
                            if (concurrence > 0) {
                                countOfConcurrence++;
                            }
                            concurrence++;
                        } else {
                            concurrence = 0;
                        }
                    }
                    checkedLetters.add(letter);
                }
                countOfConcurrrences.add(countOfConcurrence);
            }

            Optional<Integer> max = countOfConcurrrences.stream()
                    .max(Integer::compareTo);

            if (max.isPresent()) {
                results.add(max.get());
            } else {
                results.add(countOfConcurrence);
            }
        }
        results.forEach(System.out::println);
    }
}