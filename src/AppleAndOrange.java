import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int sumApples = 0;
        int sumOranges = 0;

        System.out.print("Array apples length is: " +apples.length +" and array orange length is: "+oranges.length + "\n");

        for(int i = 0; i<apples.length;i++){
            System.out.print("Apple nº "+i+" fall in "+apples[i]+a +"\n");
            if(apples[i]+a >= s && apples[i]+a<= t){
                System.out.print("Apple nº "+i+" fall in "+apples[i]+a +"\n");
                sumApples++;
            }
        }

        for(int j=0;j<oranges.length;j++){
            System.out.print("Orange nº "+j+" fall in "+oranges[j]+a+"\n");
            if(oranges[j]+b >= s && oranges[j]+b<=t){
                sumOranges++;
            }
        }

        System.out.print(sumApples +"\n");
        System.out.print(sumOranges);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}
