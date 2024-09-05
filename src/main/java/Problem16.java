import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int k = sc.nextInt();
        int n = 0;
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = 1;
        int d = 1;
        boolean bol = false;
        List<Integer> listAmountD = new ArrayList<>();
        List<Integer> listAmountH = new ArrayList<>();

        if (a * s == b) {
            n = s * k;
            System.out.println(n);
        } else {
            while (n < s * k) {
                if ((b - s * a) % (n - s * k) == 0) {
                    d = (b - s * a) / (n - s * k);
                    if (b - s >= d * n && a > d * k) {
                        bol = true;
                        break;
                    }
                }
                n++;
            }

            if (bol == true) {
                System.out.println(n);
            } else {
                System.out.println(-1);
            }
        }

        /*
        	while (n < s * k) {
		if ((b - s * a) % (n - s * k) == 0) {
		    d = (b - s * a) / (n - s * k);
		    if (b - s >= d * n && a > d * k) {
		       	cout << n;
		        return 0;
		    }// проверяем удовлетворяет ли текущее количество драконов и текущее количество ног все условия
		}// выполняем все проверки только для целых d
		n++;
    }// выполняем перебор только до s*k
	cout << -1;// выводим -1, если решений не нашлось(входные данные противоречивы)
	return 0;
         */

        /*if (lHeads < 0 || hDragon < 0 || amountHeads == 0 || amountLegs == 0) {
            lDragon = -1;
        } else if (hDragon == 0) {
            lDragon = 0;
        } else if (lHeads == 0) {
            amountD = amountHeads / hDragon;
            lDragon = amountLegs / amountD;
        } else {

            //Подбираю количество н-ножек
            for (int i = amountHeads; i > 0; i--) {

                if (i % hDragon == 0) {
                    amountD = i / hDragon;
                    amountHHeads = amountHeads - (amountD * hDragon);
                    listAmountH.add(amountHHeads);
                    listAmountD.add(amountD);
                }
            }

            for (int i = 0; i < listAmountD.size(); i++) {
                lDragon = calculateAmountDragonsLegs(amountLegs, listAmountH.get(i), lHeads, listAmountD.get(i));

                if (amountLegs -
                        ((listAmountH.get(i) * lHeads) +
                                (listAmountD.get(i) * lDragon))
                        != 0) {
                    listAmountH.remove(i);
                    listAmountD.remove(i);
                }

            }

            lDragon = calculateAmountDragonsLegs(amountLegs, listAmountH.get(0), lHeads, listAmountD.get(0));
        }
        System.out.println(lDragon);*/
    }

    public static int calculateAmountDragonsLegs(int amountLegs, int amountHHeads, int lHead, int amountD) {
        return (amountLegs - (lHead * amountHHeads)) / amountD;
    }

}