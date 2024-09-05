import java.util.Scanner;

public class Problem16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lHeads = sc.nextInt();
        int hDragon = sc.nextInt();
        int lDragon = 0;
        int amountHeads = sc.nextInt();
        int amountLegs = sc.nextInt();
        int amountHHeads = 0;
        int amountD = 0;
        boolean b = true;

        if (lHeads + 2 > amountLegs) {
            System.out.println(-1);
        } else {

            //Подбираю количество н-ножек
            while (b) {
                if (amountHeads % hDragon == 0 & amountHHeads != 0) {
                    amountD = amountHeads / hDragon;
                    lDragon = (amountLegs - (amountHHeads * lHeads)) / amountD;
                    b = false;
                } else {
                    amountHHeads++;
                    amountHeads--;
                }
            }

            while ((amountLegs % ((amountHHeads * lHeads) + (amountD * lDragon)) != 0)) {

                if (lDragon == 0) {
                    break;
                }

                amountD -= 1;
                amountHHeads += hDragon;
                lDragon = (amountLegs - (amountHHeads * lHeads)) / amountD;
            }


            System.out.println(lDragon);

        }
    }
}