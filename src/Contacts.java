import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */
        Trie trie = new Trie();

        List<Integer> results = new ArrayList<Integer>();

        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0].contains("add")) {
                trie.add(queries[i][1]);
            }

            if (queries[i][0].contains("find")) {
                results.add(trie.find(queries[i][1]));
            }
        }

        int[] returnData = results.stream().mapToInt(i -> i).toArray();

        return returnData;
    }

    /*  Using recursion (Didn't pass long tests)
    public static class Trie {
        private Map<Character, Trie> child = new HashMap<>();
        private int count = 0;

        public void add(String word) {
            count++;

            if (!word.isEmpty()) {
                char firstLetter = word.charAt(0);
                if (!child.containsKey(firstLetter)) {
                    child.put(firstLetter, new Trie());
                }

                String nextWord = word.substring(1);
                if (!nextWord.isEmpty()) {
                    child.get(firstLetter).add(word.substring(1));
                }
            }
        }

        public int find(String word) {
            char firstLetter = word.charAt(0);
            String nextWord = word.substring(1);
            int finalResult;

            if(!child.containsKey(firstLetter)){
                return 0;
            }

            if(nextWord.isEmpty()){
                return count;
            }

            return child.get(firstLetter).find(word.substring(1));
        }
    }
    */

    /*
    static class TrieNode {
        private HashMap<Character, TrieNode> child = new HashMap<>();
        public int count = 0;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public void add(String str){
            TrieNode currentTrieNode = root;
            for(char ch:str.toCharArray()){
                currentTrieNode.child.putIfAbsent(ch, new TrieNode());
                currentTrieNode = currentTrieNode.child.get(ch);
                currentTrieNode.count++;
            }
        }

        public int find(String prefix){
            TrieNode currentTrieNode = root;

            for(char ch: prefix.toCharArray()){
                currentTrieNode = currentTrieNode.child.get(ch);
                if(currentTrieNode == null){
                    return 0;
                }
            }

            return currentTrieNode.count;
        }
    }
    */

    public static class Trie {
        private Map<Character, Trie> child = new HashMap<>();
        private int count = 0;

        public void add(String word) {
            count++;
            if (!word.isEmpty()) {
                char firstLetter = word.charAt(0);
                Trie next = child.get(firstLetter);
                if (next == null) {
                    next = new Trie();
                    child.put(firstLetter, next);
                }
                String nextWord = word.substring(1);
                next.add(nextWord);
            }
        }

        public int find(String word) {
            char firstLetter = word.charAt(0);
            String nextWord = word.substring(1);
            Trie next = child.get(firstLetter);
            if (next == null) {
                return 0;
            }
            if (nextWord.isEmpty()) {
                return count;
            }
            return next.find(nextWord);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
