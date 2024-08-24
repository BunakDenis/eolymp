package HitachiVantaraProgrammingContest2024;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProblemC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> enemiesHealth = new ArrayList<>();

        Integer countOfEnemies = Integer.valueOf(scanner.nextLine());
        for (String enemyHealth : scanner.nextLine().split(" ")) {
            enemiesHealth.add(Integer.valueOf(enemyHealth));
        }

        long countOfAttack = 0;
        countOfAttack = secondVariant(enemiesHealth, countOfAttack);
        System.out.println(countOfAttack);
    }

    private static long firstVariant(List<Integer> enemiesHealth, long countOfAttack) {
        Date startTime = new Date();


        for (Integer enemyHealth : enemiesHealth) {

            while (enemyHealth > 0) {
                countOfAttack++;
                if ((countOfAttack % 3) == 0) {
                    enemyHealth = enemyHealth - 3;
                } else {
                    enemyHealth--;
                }
            }
        }
        System.out.println("finish time = " + (new Date().getTime() - startTime.getTime()));
        return countOfAttack;
    }

    private static long secondVariant(List<Integer> enemiesHealth, long countOfAttack) {
        Date startTime = new Date();
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
        System.out.println("finish time = " + (new Date().getTime() - startTime.getTime()));
        return countOfAttack;
    }
}
