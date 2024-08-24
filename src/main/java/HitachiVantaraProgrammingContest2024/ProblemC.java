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
        countOfAttack = firstVariant(enemiesHealth, countOfAttack);
        System.out.println(countOfAttack);
        countOfAttack = 0;
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

            if (countOfAttack != 0) {
                if (countOfAttack % 3 == 0) {
                    enemy = enemy - 3;
                    countOfAttack = countOfAttack + 1;
                }
            }

            if (enemy % 3 == 0) {
                enemy = enemy - 1;
                countOfAttack = countOfAttack + 1;
            }

            int countOfTripleAttack = enemy / 3;
            enemy = enemy - (countOfTripleAttack * 3);
            countOfAttack = countOfAttack + countOfTripleAttack + enemy;
        }
        System.out.println("finish time = " + (new Date().getTime() - startTime.getTime()));
        return countOfAttack;
    }
}
