import java.util.Scanner;

public class Problem10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String s = scanner.nextLine();
        int countOfTrees = scanner.nextInt();
        int countOfDays = 0;
        double water = 0.0;

        for (int i = countOfTrees; i > 0; i--) {
            water += ((double) 1 / i);
            if (water >= 0.5) {
                break;
            }
            countOfDays++;
        }
        System.out.println(countOfTrees - countOfDays);
    }
}