package problem11718;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String[] s = "mississippi".split("s");
        System.out.println(Arrays.toString(s));
        long count = s.length - 1;

        for (String s1 : s) {
            System.out.println(s1);
        }
        System.out.println("count = " + count);

    }
}