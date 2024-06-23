import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

//Problem11
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(new Main().division(scanner.next(), scanner.next(), scanner.next()));

    }

    public String division(String firstInputValue, String secondInputValue, String thirdInputValue) {
        String result = "";
        try {
            Double m = Double.valueOf(firstInputValue);
            Double n = Double.valueOf(secondInputValue);
            Integer k = Integer.valueOf(thirdInputValue);

            if ((m > 0) &
                    (n <= 100) &
                    (k >= 0) &
                    (k <= 1000)) {

                if (k != 0) {
                    String formatAmountDigitsAfterComma = "#0.";
                    for (int i = 0; i < k; i++) {
                        formatAmountDigitsAfterComma += "0";
                    }

                    String resultOfDivision =
                            new DecimalFormat(formatAmountDigitsAfterComma)
                                    .format(new BigDecimal(m / n));
                    result = resultOfDivision;

                /*String[] digits = resultOfDivision.split(",");
                char[] digitsAfterComma = digits[1].toCharArray();
                StringBuilder stringBuilder = new StringBuilder("0.");

                if (digitsAfterComma[0] == '0') {
                    int countForZeroDigitsAfterComma = 0;

                    for (char c : digitsAfterComma) {
                        if (Integer.valueOf(c) == '0') {
                            countForZeroDigitsAfterComma++;
                        } else {
                            break;
                        }
                    }

                    for (int i = countForZeroDigitsAfterComma; i < digitsAfterComma.length; i++) {
                        stringBuilder.append(digitsAfterComma[i]);
                    }

                    for (int i = 0; i < countForZeroDigitsAfterComma; i++) {
                        stringBuilder.append('0');
                    }

                    result = stringBuilder.toString();

                } else {

                }*/

                } else {
                    result = String.valueOf((int)(m / n));
                }

            } else {
                result = "0";
            }

        } catch (NumberFormatException e) {
            result = "0";
        }
        return result;
    }
}