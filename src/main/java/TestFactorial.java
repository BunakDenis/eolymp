public class TestFactorial {
    public static int factorial(int n) {
        int result;
        if(n <= 1)  // Базовый случай
        {
            return 1;
        }
        result = n * factorial(n - 1);
        return result; //рекурсивеый вызов с другим аргументом
    }

    public static void main(String[] args) {

        System.out.println("factorial(4) = " + factorial(4));

    }
}