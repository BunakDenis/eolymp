import java.util.Scanner;

public class Problem8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;

        double width = Math.ceil(Math.pow(n, (1.0 / 2.0)));
        double length = Math.ceil(n / width);

        result = (n * 2) + (int) (length + width);

        System.out.println(result);
    }
}
