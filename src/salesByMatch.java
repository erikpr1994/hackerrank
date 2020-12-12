import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        AtomicReference<Integer> pairs = new AtomicReference<>(0);
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for(int i = 0; i<ar.length; i++){
            if(hashtable.containsKey(ar[i])){
                Integer value = hashtable.get(ar[i]);
                value += 1;
                hashtable.put(ar[i], value);
            } else {
                hashtable.put(ar[i], 1);
            }
        }

        hashtable.forEach((key, element) -> {
            if(element % 2 == 0) {
                pairs.updateAndGet(v -> v + element / 2);
            } else {
                pairs.updateAndGet(v -> v + (element -1 ) / 2);
            }
        });

        return pairs.get();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
