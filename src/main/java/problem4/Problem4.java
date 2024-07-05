package problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String circles = scanner.nextLine();

        ArrayList<Circle> parse = CircleParser.parse(circles);

        int result = CircleIntersectionCalculation.calculate(parse);

        System.out.println(result);
    }
}

class CircleParser {

    static ArrayList<Circle> parse(String inputText) {
        List<Circle> result = new ArrayList<>();

        String[] digits = inputText.split(" ");

        for (int i = 0; i < digits.length; i++) {
            if (digits.length >= 3) {
                result.add(new Circle(Double.valueOf(digits[i]), Double.valueOf(digits[i + 1]), Double.valueOf(digits[i + 2])));
                i += 2;
            }
        }

        return (ArrayList<Circle>) result;
    }
}

class CircleIntersectionCalculation {

    static int calculate(ArrayList<Circle> circles) {
        double distance;
        int result;

        Circle circle1 = circles.get(0);
        Circle circle2 = circles.get(1);


        distance = Math.pow(circle2.getX() - circle1.getX(), 2) + Math.pow(circle2.getY() - circle1.getY(), 2);

        if (circle1.getX() == circle2.getX() &&
                circle1.getY() == circle2.getY() &&
                circle1.getR() == circle2.getR()) {

            result = -1;

        } else if ((Math.pow((circle1.getR() + circle2.getR()), 2)) < distance ||
                (Math.pow((circle1.getR() - circle2.getR()), 2)) > distance)
                 {

            result = 0;


        } else if ((Math.pow((circle1.getR() + circle2.getR()), 2)) == distance ||
                (Math.pow((circle1.getR() - circle2.getR()), 2)) == distance) {

            result = 1;

        } else {

            result = 2;

        }
        return result;
    }
}

class Circle {

    private double x;
    private double y;
    private double r;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.x, x) == 0 && Double.compare(circle.y, y) == 0 && Double.compare(circle.r, r) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, r);
    }
}