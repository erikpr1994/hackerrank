import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the stepPerms function below.
    static int stepPerms(int n) {
        int [] number = new int [n+1];
        number[0] = 1;
        return calcs(n,number);
    }

    private static int calcs(int n, int[] number){
        // Cuando la N es más pequeño que 0, devuelve 0
        if(n<0){
            return 0;
        }
        // si la posicion de number n es diferente a 0, devuelve number y su posicion
        if(number[n]!=0){
            return number[n];
        }

        // si n es 1, devuelve 1
        if(n==1){
            return 1;
        }

        // Calcula la posicion 0 de number
        number[n]= calcs(n-3,number) + calcs(n-2,number) + calcs(n-1,number);
        return number[n];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
