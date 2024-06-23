import java.util.Scanner;

public class Problem2 {

    public int amountOfNumbers (int n) {
        int length = 0;
        if (n < 0) {
            return -1;
        }
        if (n >= 0 & n <= 9) {
            return 1;
        }
        if (n > 0 & n < 2000000000) {
            length = (int) (Math.log10(n) + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem2 problem2 = new Problem2();
        int inputNumber = scanner.nextInt();
        System.out.println(problem2.amountOfNumbers(inputNumber));
        scanner.close();
    }
}