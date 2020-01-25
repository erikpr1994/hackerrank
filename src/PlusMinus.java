import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        float pos = 0, neg = 0, zero = 0;
        int size = arr.length;
        for(int i = 0; i<size;i++){
            if(arr[i]<0){
                neg++;
            } else if(arr[i]>0){
                pos++;
            } else {
                zero++;
            }
        }
        float negPercentage = neg/size;
        float posPercentage = pos/size;
        float zeroPercentage = zero/size;

        System.out.printf("%.6f\n",posPercentage);
        System.out.printf("%.6f\n",negPercentage);
        System.out.printf("%.6f",zeroPercentage);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
