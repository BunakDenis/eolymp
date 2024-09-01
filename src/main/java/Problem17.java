import java.util.Scanner;

public class Problem17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();

        System.out.println((long) (3 * Math.pow(2, (n - 1))));
    }
}