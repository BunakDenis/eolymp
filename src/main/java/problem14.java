import java.util.Scanner;

public class problem14 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int amountPassangers = scanner.nextInt();
        int numberOfTicket = scanner.nextInt();

        System.out.println(amountPesangers(amountPassangers, numberOfTicket));

    }

    public static boolean isNumberSimple(int number) {

        if (number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {

            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int amountPesangers (int pasangers, int biletNumber) {

        int result = -1;
        int count = 0;


                for (int i = pasangers - 1; i > 0; i--) {
                    biletNumber++;
                    if (isNumberSimple(biletNumber)) {
                        result = count;
                        break;
                    }
                    count++;
                }

        return result;
    }

}
