package problem11718;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int numberOfLetters = Integer.valueOf(s1[0]);
        System.out.println("numberOfLetters = " + numberOfLetters);
        int numberOfRequest = Integer.valueOf(s1[1]);
        System.out.println("numberOfRequest = " + numberOfRequest);
        System.out.println("scanner.nextLine() = " + scanner.nextLine());

    }

}
