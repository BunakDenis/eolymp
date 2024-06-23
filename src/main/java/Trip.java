import java.util.Arrays;
import java.util.Scanner;

public class Trip {

    public static int[][] getInformation () {

        Scanner scanner = new Scanner(System.in);
        int amountDays = Integer.parseInt(scanner.nextLine());

        if (amountDays > 15) {
            amountDays = 15;
        }

        int [][] informationOfTrips = new int[amountDays][2];
        int days = 0;
        int pay = 0;

        for (int i = 0; i < amountDays; i++) {

            days = Integer.parseInt(scanner.next());
            if (days > 30) {
                days = 30;
            }
            informationOfTrips[i][0] = days;

            pay = Integer.parseInt(scanner.next());
            if (pay > 100) {
                pay = 100;
            }
            informationOfTrips[i][1] = pay;


        }
        for (int[] string: informationOfTrips) {
            System.out.println(Arrays.toString(string));
        }
        scanner.close();
        return informationOfTrips;
    }

    public static int calculateMaxSum (int [][] information) {

        int indexOfLines = information.length - 1;
        int maxSum = 0;
        int sum = 0;
        int countForOneCikle = 0;

        for (int i = 0; i < information.length; i++) {
            for (int j = 0; j < information.length; j++) {
                sum = (information[countForOneCikle][0] - j) * information[countForOneCikle][1];
                countForOneCikle++;
                if (sum > maxSum) {
                    maxSum = sum;
                }
                if (j != indexOfLines & countForOneCikle == indexOfLines) {
                    countForOneCikle = 0;
                }
            }
            countForOneCikle++;
        }

        return maxSum;

    }

    public static void main(String[] args) {
        int maxSum = 0;
        int [][] tripInformation = new int[][] {};
        Trip trip = new Trip();
        tripInformation = trip.getInformation();
        maxSum = trip.calculateMaxSum(tripInformation);
        System.out.println(maxSum);
    }
}