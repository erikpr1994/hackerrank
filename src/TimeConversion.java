import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String[] hours = s.split(":");
        int hora, minutes;
        hora = Integer.parseInt(hours[0]);
        minutes = Integer.parseInt(hours[1]);

        if(hora == 12 && ((hours[2].contains("PM") && minutes == 0)||hours[2].contains("AM"))){
            hours[0] = "00";
        }

        if(hora < 12 && hours[2].contains("PM")){
            hora += 12;
            hours[0] = Integer.toString(hora);
        }

        hours[2]=hours[2].substring(0,2);
        return String.join(":",hours);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
