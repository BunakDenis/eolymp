import java.util.Scanner;

public class Problem20 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        System.out.println(divineNumberV2(n));

    }

    public static long divineNumberV2(long number) {
        long count = 0;

        while (number > 0) {
            for (long i = number; i > 0; i /= 10) {
                number -= i % 10;
            }
            count++;
        }
        return count;
    }
}
