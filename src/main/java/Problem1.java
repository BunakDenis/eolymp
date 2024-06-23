import java.util.NoSuchElementException;
import java.util.Scanner;

public class Problem1 {

    /*
    Введите двузначное число и выведите через пробел каждую цифру отдельно.

    Входные данные
    Одно натуральное число из промежутка от 10 до 99 включительно.

    Выходные данные
    Выведите через пробел две цифры числа.

    23 2 3
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Problem1 problem1 = new Problem1();
        try {
            System.out.println(problem1.printDigitsSeparately(Integer.valueOf(scanner.nextLine())));
        } catch (NoSuchElementException e){
            System.out.println("0");
        }

    }
    public String printDigitsSeparately(int number) {
        String result = "";

            char[] digits = Integer.toString(number).toCharArray();

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < digits.length; i++) {
                stringBuilder.append(digits[i]);
                if (i != digits.length - 1) {
                    stringBuilder.append(' ');
                }
            }

            result = stringBuilder.toString();

        return result;
    }
}
