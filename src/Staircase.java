import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
        for(int i = 0; i<n;i++){
            int TrozosEnBlanco = n - i - 1;
            int pintado=0;
            // for(int j = n; j>i; j--){

            while(pintado<TrozosEnBlanco){
                System.out.print(" ");
                pintado++;
            }
            while(pintado<n) {
                System.out.print("#");
                pintado++;
            }
            // }
            System.out.print("\n");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}