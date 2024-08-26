package problem11718;

import java.util.*;

public class Problem11718 {
    /*TODO
        1. Нужно сделать вторую версию метода checkWord с Map
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.nextInt();
        int numberOfRequest = scanner.nextInt();
        scanner.nextLine();
        String word = scanner.nextLine();
        List<Integer> firstIndexes = new ArrayList<>();
        List<Integer> lastIndexes = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < numberOfRequest; i++) {
            firstIndexes.add(scanner.nextInt() - 1);
            lastIndexes.add(scanner.nextInt() - 1);
        }

        int[][] resultOfChecking = checkTheWord(word);

        for (int i = 0; i < numberOfRequest; i++) {
            results.add(
                    resultOfChecking[lastIndexes.get(i)][1] - resultOfChecking[firstIndexes.get(i)][1]
            );
        }
        results.forEach(System.out::println);
    }

    public static int[][] checkTheWord(String word) {
        int[][] result = new int[word.length()][2];
        String[] letters = word.split("");
        String[] checkForWordWithOneLetter = word.split(String.valueOf(word.charAt(0)));
        int count = 0;

        for (int i = 0; i < letters.length; i++) {

            if (checkForWordWithOneLetter.length == 0) {
                result[i][0] = i;
                result[i][1] = i;
            } else {
                if (i + 1 < letters.length) {
                    result[i][0] = i;
                    result[i][1] = count;
                    if (letters[i].equals(letters[i + 1])) {
                        count++;
                    }
                } else {
                    result[i][0] = i;
                    result[i][1] = count;
                }
            }
        }
        return result;
    }
}