import java.util.NoSuchElementException;
import java.util.Scanner;

public class Problem3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Problem3 problem3 = new Problem3();

        try {
            System.out.println(problem3.amountEdgesOfCube(Integer.valueOf(scanner.next())));
        } catch (NoSuchElementException exception) {
            System.out.println("0");
        }
    }

    public int amountEdgesOfCube(int amountCubs) {
        int result = 0;
        /*
        для постройки 1-го куба нужно 12 спичек
        для постройки 2-х кубов нужно 20 спичек
        для постройки 3-х кубов нужно 28 спичек
        для постройки 4-х кубов нужно 36 спичек
        для постройки 5-х кубов нужно 52 спичек
        для постройки 6-х кубов нужно 60 спичек

         */

            if (amountCubs == 1) {
                result = 12;
            } else if (amountCubs > 1 & amountCubs < (2 * Math.pow(9, 10))) {
                result = 12;

                int amountCubeDivineFive = (amountCubs % 5);
                System.out.println((amountCubs % 5));
                double halfOfAmountCube = (Double.valueOf(amountCubs) / 5.0);
                int remainderOfTheFraction = (((int) (halfOfAmountCube)) * 10) % 10;

                for (int i = 0; i < (amountCubs - 1); i++) {
                    result += 8;
                }

                if (amountCubeDivineFive > 1) {
                    result += (16 * amountCubeDivineFive);

                    for (int i = 0; i <= remainderOfTheFraction; i++) {
                        result += 8;
                    }
                }
            }
        return result;
    }
}