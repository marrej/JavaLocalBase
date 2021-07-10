import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        CodeWorker code = new CodeWorker();
    }


}

// has to add public for google
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            String s = in.next();
            var result = new CodeWorker().runSolution();
            System.out.println("Case #" + i + ": " + (result) + " " + (result));
        }
    }
}

class CodeWorker {
    public Integer runSolution() {
        return 0;
    }
}
