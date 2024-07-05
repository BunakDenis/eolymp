import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Problem3 problem3 = new Problem3();

        try {
            System.out.println(problem3.amountEdgesOfCube(Integer.valueOf(scanner.next())));
        } catch (NoSuchElementException exception) {
            System.out.println("0");
        }
    }

    public int amountEdgesOfCube(int amountCubs) {
        int result = 0;

// a, b, c - размеры целого прямоугольного параллелипеда
// a - длина
        double v = Math.cbrt(amountCubs) + 0.5;
        int a = (int) v;
// b - ширина
        double v1 = Math.pow(((double) amountCubs / a), 0.5) + 0.5;
        int b = (int) v1;
// c - высота
        int c = (amountCubs / (a * b));
// Один слой
        int s1 = a * (b + 1) + b * (a + 1);
// Между слоями
        int s2 = (a + 1) * (b + 1);
// Всего спичек на целый прямоугольный параллелипипед
        result = s1 * (c + 1) + s2 * c;
// remainder - оставшиеся кубики

        int remainder = amountCubs - (a * b * c);
// Если кубы ещё остались
        if (remainder != 0) {
            int last = 0;
            int e = 0;
            int d = 0;

            if (amountCubs > 4) {
                //d, e - размеры нового прямоугольного параллелипипеда
                d = (int) Math.pow(remainder, 0.5);
                e = (int) Math.pow(remainder, 0.5);
                //Подбираем оптимальные d, e
                last = Math.max(d, e);
                while ((d * e) < remainder) {
                    last = Math.max(d, e);
                    if (d < e) {
                        d += 1;
                    } else {
                        e += 1;
                    }
                }
                e = last;
                d = last;
                //К результату добавляем полученные спички
                result += d * (e + 1) + e * (d + 1) + (d + 1) * (e + 1);
                remainder -= d * e;
                if (remainder != 0) {
                    //Если кубики всё равно остались, то добавляем и их
                    result += (3 * (remainder - 1)) + 5;
                }
            } else {
                result += 8;
            }
        }


/*        int amountSectionsOfCubs = (amountCubs / 3);
        int amountBlockSectionsOfCubs = (amountCubs / 12);
        int balanceOfCubs = amountCubs - (amountSectionsOfCubs * 3);

        //Сначала учитываем количество блоков в конструкции
        if (amountBlockSectionsOfCubs > 0) {
            result += 75 + ((amountBlockSectionsOfCubs - 1) * 58);
            amountCubs -= (amountBlockSectionsOfCubs * 12);
            int balanceOfSections = (amountSectionsOfCubs - (amountBlockSectionsOfCubs * 4));

            result += (balanceOfSections * 18);
            result += addBalanceSectionsOfCubs(balanceOfCubs, balanceOfSections);
        } else {
            if (amountSectionsOfCubs > 0) {

                if (amountSectionsOfCubs != 1) {
                    result += 28 + ((amountSectionsOfCubs - 1) * 18);
                } else {
                    result += 28;
                }
                result += addBalanceSectionsOfCubs(balanceOfCubs, amountSectionsOfCubs);

            } else {
                result = 12;
                if (amountCubs != 1) {
                    result += 8;
                }
            }
        }
        return result;
    }

    private int addBalanceSectionsOfCubs(int balanceOfCubs, int amountSectionsOfCubs) {
        int result = 0;

        if (amountSectionsOfCubs > 0 & amountSectionsOfCubs <= 3) {
            switch (balanceOfCubs) {
                case 1:
                    result += 8;
                    break;

                case 2:
                    result += 13;
                    break;

                default:
                    result = 0;
            }
        } else {
            switch (balanceOfCubs) {
                case 1:
                    result += 5;
                    break;

                case 2:
                    result += 3;
                    break;

                default:
                    result = 0;
            }
        }

 */
        return result;
    }
}