import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            // i es la posicion inicial, n el tamaño del array, d las posiciones que se mueve
            // Entonces dado i=0; n=5; d=4;
            // (0 + 5 - 4) % 4 = 1 % 4 = 1;
            a[(i + n - d) % n] = aItem;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        scanner.close();
    }
}
