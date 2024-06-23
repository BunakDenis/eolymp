public class TestMassive {

    public int sumSallary (int[][] sallary, int index) {
        int result = 0;
        int day = 0;
        for (int i = 0; i < sallary.length; i++) {

            result += (sallary[index][0] - day) * sallary [index][1];
            day++;
            index++;
            if (index == sallary.length) {
                index = 0;
            }

        }
        return result;
    }

    public int [][] checkArray (int [][] sallary) {
        int lengthOfArray = 0;


        for (int i = 0; i < sallary.length; i++) {
            if (sallary [i][0] != 1) {
                lengthOfArray++;
            }
        }

        int [][] result = new int[lengthOfArray][2];

        for (int i = 0; i < result.length; i++) {
            if (sallary [i][0] != 1) {
                result [i][0] = sallary[i][0];
                result [i][1] = sallary[i][1];
            }
        }
        return result;
    }

    public int amountAllSum (int [][] sallary) {

        int [][] arrForResult = checkArray(sallary);
        int index = sallary.length * sallary.length;
        int result = 0;

        for (int i = 0; i < index; i++) {
            for (int j = 0; j < sallary.length; j++) {
                int sum = sumSallary(sallary, j);
                if (result < sum) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TestMassive testMassive = new TestMassive();
        int [][] forSallary = new int[][] {{1,5} , {2,3} , {3,10}};
        System.out.println(testMassive.amountAllSum(forSallary));
    }


}
