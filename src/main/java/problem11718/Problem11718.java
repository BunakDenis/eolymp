package problem11718;

import java.util.*;
import java.util.stream.Collectors;

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

        for (int i = 0; i < numberOfRequest; i++) {
            firstIndexes.add(scanner.nextInt() - 1);
            lastIndexes.add(scanner.nextInt() - 1);
        }

        //int[][] resultOfChecking = checkTheWord(word);
        int[][] resultOfChecking = checkTheWordV2(word);

        for (int i = 0; i < numberOfRequest; i++) {
            int result = resultOfChecking[lastIndexes.get(i)][1] - resultOfChecking[firstIndexes.get(i)][1];
            System.out.println(result);
        }
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

    public static int[][] checkTheWordV2(String word) {
        int[][] result = new int[word.length()][2];
        String[] letters = word.split("");
        String[] checkForTheWordOfOneLetter = word.split(String.valueOf(word.charAt(0)));
        Map<String, String> originalLetters = new LinkedHashMap<>();
        Arrays.stream(letters)
                .forEach(l -> originalLetters.put(l, l));

        if (checkForTheWordOfOneLetter.length == 0) {
            for (int i = 0; i < result.length; i++) {
                result[i][0] = i;
                result[i][1] = i;
            }
            return result;
        } else {
            for (String letter : originalLetters.values()) {
                int count = 0;
                int charIndex = word.indexOf(letter);
                int nextCharIndex = charIndex;
                //System.out.println("charIndex = " + charIndex + ", letter = " + letter);

                while (nextCharIndex != -1) {

                    nextCharIndex = word.substring(charIndex + 1).indexOf(letter);
                    if (nextCharIndex == 0) {
                        result[charIndex][0] = charIndex;
                        int i = result[charIndex][1] + 1;
                        result[charIndex][1] = i;
                    }

                    if (nextCharIndex == -1) {
                        break;
                    }

                    charIndex = word.substring(0, charIndex + 1).length() + nextCharIndex;
                    //System.out.println("builder.substring(0, charIndex).length() = " + word.substring(0, charIndex).length());

                    if (count > word.length()) break;
                    //System.out.println("nextCharIndex = " + nextCharIndex + ", charIndex = " + charIndex);
                }

            }
        }
        int j = 0;
        for (int i = 0; i < result.length; i++) {
            if (i != 0) {
                if (result[i][0] == 0) {
                    result[i][0] = i;
                    result[i][1] = j;
                } else {
                    result[i][1] = j;
                    j++;
                }
            }
        }

/*        for (int i = 0; i < result.length; i++) {
            System.out.println("[" + result[i][0] + ", " + result[i][1] + "]");
        }*/
        return result;
    }
}