import java.util.List;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int sumIzq = 0;
        int anchoMatriz = arr.size();
        int altoMatriz = 0;
        System.out.println("alto matriz: "+anchoMatriz);
        for(int i = 0; i < anchoMatriz;i++){
            sumIzq += cell(arr, i, i);
           // altoMatriz = Math.max(arr.get(i).size(), altoMatriz);
        }
        System.out.println("ancho matriz: "+altoMatriz);
        int sumDer = 0;
        for(int i = 0; i < anchoMatriz;i++) {
            int x = anchoMatriz-1-i;
            int y = i;

            sumDer += cell(arr, x,y);
        }

        return Math.abs(sumIzq-sumDer);
    }

    public static int cell(List<List<Integer>> arr, int x, int y){
        System.out.println(x+" x "+y);
        List<Integer> row = arr.get(x);
        if (row.size() > x){
            return row.get(y);
        }
        return 0;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
