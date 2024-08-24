package HitachiVantaraProgrammingContest2024;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProblemC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> enemiesHealth = new ArrayList<>();

        scanner.nextLine();
        for (String enemyHealth : scanner.nextLine().split(" ")) {
            enemiesHealth.add(Integer.valueOf(enemyHealth));
        }

        long countOfAttack = 0;
        countOfAttack = secondVariant(enemiesHealth, countOfAttack);
        System.out.println(countOfAttack);
    }

    private static long secondVariant(List<Integer> enemiesHealth, long countOfAttack) {
        for (Integer enemy : enemiesHealth) {
            int enemyCountOfAttack = 0;
            if ((enemy % 5) == 0) {
                countOfAttack += ((enemy / 5) * 3);
                enemy = 0;
            }

            if (enemy > 5) {
                enemyCountOfAttack += ((enemy / 5) * 3);
                enemy -= ((enemyCountOfAttack / 3) * 5);
                countOfAttack += enemyCountOfAttack;

                while (enemy > 0) {
                    countOfAttack++;
                    if (countOfAttack % 3 == 0) {
                        enemy -= 3;
                    } else {
                        enemy -= 1;
                    }
                }
            }

            while (enemy > 0) {

                countOfAttack++;
                if (countOfAttack % 3 == 0) {
                    enemy -= 3;
                } else {
                    enemy -= 1;
                }

            }
        }
        return countOfAttack;
    }
}