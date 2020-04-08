import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    // Metodo O(1) = Pasa todos los tests
    static long arrayManipulation(int n, int[][] queries) {
        long outputArray[] = new long[n + 2];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];

            outputArray[a] += k;
            outputArray[b + 1] -= k;
        }

        long max = Long.MIN_VALUE;
        long sum = 0;

        for (int i = 0; i < outputArray.length; i++) {
            System.out.println("El valor de outputArray[" + i + "] es: " + outputArray[i]);
            sum += outputArray[i];
            max = Math.max(max, sum);
        }

        return max;
    }


    // Metodo O(n^2) = Solo pasa los test que son cortos
    static long arrayManipulation(int n, int[][] queries) {
        long bigger = 0;
        int start, end, number;

        long[] helper = new long[n];

        for (int i = 0; i < n; i++) {
            helper[i] = 0;
        }

        for (int i = 0; i < queries.length; i++) {
            start = queries[i][0];
            end = queries[i][1];
            number = queries[i][2];

            for (int j = start - 1; j < end; j++) {
                helper[j] += number;
                if (helper[i] > bigger) {
                    bigger = helper[i];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (helper[i] > bigger) {
                bigger = helper[i];
            }
        }

        return bigger;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}