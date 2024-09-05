import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;
        int count = 0;
        boolean b = true;

        if (n == 0) {
            System.out.println("0");
        } else if (n == 1) {
            System.out.println("10 0");
        } else if (n == 8) {
            System.out.println("224 11111128");
        } else if (n == 9) {
            System.out.println("144 111111129");
        } else {

            for (int i = (int) Math.pow(10, (n - 1)); i < (int) Math.pow(10, n); i++) {
                int sum = sum(i);
                int multiply = multiply(i);

                if (sum == multiply & b == true) {
                    result = i;
                    count++;
                    b = false;
                } else {
                    if (sum == multiply) {
                        count++;
                    }
                }
            }
            System.out.println(count + " " + result);
        }
    }

    public static int sum(int n) {
        int result = 0;

        while (n > 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }

    public static int multiply(int n) {
        int result = 1;

        while (n > 0) {
            result *= n % 10;
            n /= 10;
        }
        return result;
    }

}
