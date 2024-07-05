import java.util.Scanner;


//Problem11
public class Problem11Version2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        new Problem11Version2().division(scanner.nextLine());
    }

    public void division(String text) {

        var massiv = text.split(" ");
        int m = Integer.valueOf(massiv[0]);
        int n = Integer.valueOf(massiv[1]);
        int k = Integer.valueOf(massiv[2]);
        String cap;

        cap = String.valueOf((m / n)) + ".";
        int qaliq = m % n;
        m = qaliq * 10;

/*            if (k != 0) {
                cap += ".";
            }*/

        for (int i = 1; i <= k; i++) {
            cap += (m / n);
            qaliq = m % n;
            System.out.println("qaliq = " + qaliq);
            m = qaliq * 10;
            System.out.println("m = " + m);
        }
        System.out.println(cap);
    }
}