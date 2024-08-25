package problem11718;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem11718 {
//TODO The problem is not done
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.nextInt();
        int numberOfRequest = scanner.nextInt();
        scanner.nextLine();
        String word = scanner.nextLine();
        List<Integer> firstIndexes = new ArrayList<>();
        List<Integer> lastIndexes = new ArrayList<>();
        List<Long> results = new ArrayList<>();

        for (int i = 0; i < numberOfRequest; i++) {
            firstIndexes.add(scanner.nextInt());
            lastIndexes.add(scanner.nextInt());
        }

/*
        for (int i = 0; i < numberOfRequest; i++) {
            long startTime = System.currentTimeMillis();
            List<Long> resultsOfFirstVariant = new ArrayList<>();
            List<Character> checkedLetters = new ArrayList<>();
            long resultOfFirstVariant = 0;
            int startIndex = firstIndexes.get(i) - 1;
            int lastIndex = lastIndexes.get(i);

            for (int j = startIndex; j < lastIndex; j++) {
                char letter = letters[j];

                if (!checkedLetters.contains(letter)) {
                    resultOfFirstVariant += firstVariant(word, letter, j, lastIndex);
                    checkedLetters.add(letter);
                }
            }

            //Результаты первого варианта
            System.out.println("Время первого варианта = " + (System.currentTimeMillis() - startTime));
            System.out.println("Первый вариант, " + "Запрос = " + (i + 1) + ", результат = " + resultOfFirstVariant);
            resultsOfFirstVariant.add(resultOfFirstVariant);
        }*/

        //Second Variant
        for (int i = 0; i < numberOfRequest; i++) {
            Map<String, String> letters = new LinkedHashMap<>();
            long resultOfSecondVariant = 0;
            int startIndex = firstIndexes.get(i) - 1;
            int lastIndex = lastIndexes.get(i);

            String wordForCheck = word.substring(startIndex, lastIndex);
            String[] lettersForCheck = wordForCheck.split("");

            for (String letterForCheck : lettersForCheck) {
                letters.put(letterForCheck, letterForCheck);
            }

            for (String value : letters.values()) {
                resultOfSecondVariant += secondVariant(wordForCheck, value);
            }

/*            //Результаты второго варианта
            System.out.println("Время второго варианта = " + (System.currentTimeMillis() - startTime));
            System.out.println("Второй вариант, " + "Запрос = " + (i + 1) + ", результат = " + resultOfSecondVariant);*/
            results.add(resultOfSecondVariant);
        }
        results.forEach(System.out::println);
    }

    public static long firstVariant(String word, char letter, int startIndex, int lastIndex) {
        char[] letters = word.toCharArray();
        int concurrence = 1;
        int result = 0;

        for (int k = startIndex + 1; k < lastIndex; k++) {

            if (letter == letters[k]) {
                if (concurrence > 0) {
                    result++;
                }
                concurrence++;
            } else {
                concurrence = 0;
            }
        }
        return result;
    }

    public static long secondVariant(String word, String letter) {
        long result = 0;
        String[] letters = word.split(String.valueOf(letter));
        String str = letter + letter;

        if (letters.length == 0 & word.length() > 1) {
            result = (word.length() - 1);
        } else {

            Pattern pattern = Pattern.compile(str);
            Matcher m = pattern.matcher(word);

            while (m.find()) {
                result++;
            }
        }
        return result;
    }
}