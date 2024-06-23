import java.util.Scanner;
public class Trips {
    int amountTr = 0;
    public int findMax(int[][] arr){
        Multiply(arr, 0);
        return amountTr;
    }
    public void Multiply(int[][] arr, int sum){
        if (arr.length >= 1){
            for(int i = 0; i < arr.length; i++){
                int[][] newAr = newArr(arr, i);
                Multiply(newAr, sum + arr[i][1] * arr[i][0]);
            }
        }
        if(sum > amountTr){
            amountTr = sum;
        }
    }
    private int[][] newArr(int[][] arr, int k){
        int zeroAmount = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i][0] == 1 && i != k){
                zeroAmount++;
            }
        }
        if(zeroAmount + 1 >= arr.length){
            return new int[0][0];
        }
        int[][] result = new int[arr.length - zeroAmount - 1][2];
        int j = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i][0] == 1 || i == k){
                continue;
            }
            result[j][0] = arr[i][0] - 1;
            result[j][1] = arr[i][1];
            j++;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner scann = new Scanner(System.in);
        int numberOfTrips = Integer.parseInt(scann.nextLine());
        int[][] trips = new int[numberOfTrips][2];
        for (int i = 0; i < numberOfTrips; i++){
            String[] pare = scann.nextLine().split(" ");
            trips[i][0] = Integer.parseInt(pare[0]);
            trips[i][1] = Integer.parseInt(pare[1]);
        }
        scann.close();
        Trips arr = new Trips();
        System.out.println(arr.findMax(trips));
    }
}
