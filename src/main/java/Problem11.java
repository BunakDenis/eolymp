import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

//Problem11
public class Problem11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        new Problem11().division(scanner.nextLine());
    }

    public void division(String text) {

        var massiv = text.split(" ");
        int m = Integer.valueOf(massiv[0]);
        int n = Integer.valueOf(massiv[1]);
        int k = Integer.valueOf(massiv[2]);
        int lastDigit = 0;
        String cap;

        if (n != 0) {
        cap = String.valueOf((m / n));
        int qaliq = m % n;
        m = qaliq * 10;

        if (k != 0) {
            cap += ".";
        }


            for (int i = 1; i <= k; i++) {
                if (i != k) {
                    lastDigit = (m / n);
                    cap += (m / n);
                    qaliq = m % n;
                    m = qaliq * 10;
                } else {
                    if ((m / n) > 5) {
                        cap += ((m / n) + 1);
                    } else {
                        cap += (m / n);
                    }
                }
            }
        } else {
            cap = "0";
        }
        System.out.println("cap = " + cap);
    }
}