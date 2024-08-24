package problem11718;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem11718 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String[] firstLineVariables = firstLine.split(" ");
        int numberOfLetters = Integer.valueOf(firstLineVariables[0]);
        int numberOfeRequest = Integer.valueOf(firstLineVariables[1]);
        String word = scanner.nextLine();
        char[] letters = word.toCharArray();
        List<Integer> firstIndexes = new ArrayList<>();
        List<Integer> lastIndexes = new ArrayList<>();

        for (int i = 0; i < numberOfeRequest; i++) {
            firstIndexes.add(scanner.nextInt());
            lastIndexes.add(scanner.nextInt());
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numberOfeRequest; i++) {
            int startIndex = firstIndexes.get(i);
            int lastIndex = lastIndexes.get(i);
            char letter;
            int countOfConcurrrence = 0;

            for (int j = (startIndex - 1); j < (lastIndex - 1); j++) {
                letter = letters[j];
                int count = checkLetter(letters, letter, (startIndex - 1), (lastIndex - 1), j);
                if (count > countOfConcurrrence) {
                    countOfConcurrrence = count;
                }
            }
            result.add(countOfConcurrrence);
        }
        result.forEach(System.out::println);
    }

    public static int checkLetter(char[] letters, char letter, int startIndex, int lastIndex, int currentIndex) {
        int result = 0;
        for (int i = startIndex; i < lastIndex; i++) {
            if (i != currentIndex) {
                if (letter == letters[i]) {
                    result++;
                }
            }
        }
        return result;
    }
}