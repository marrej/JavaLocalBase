import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        CodeWorker code = new CodeWorker();
        code.fileInputReadStream();
        System.out.println("finished");
    }


}

class CodeWorker {
    public void fileInputReadStream() throws IOException {
        Scanner in = null;
        FileOutputStream out = null;

        try {
            in = new Scanner(new File("src/input.txt"));
            out = new FileOutputStream("output.txt");

            int amountOfCases = in.nextInt();
            for (var i=0;i<amountOfCases;i++) {
                Map<Integer, Integer> prefixSums = new HashMap<>();

                int amountOfNumbersInCase = in.nextInt();
                String yes = "yes\n";
                String no = "no\n";
                String output = no;
                int finalSum = 0;
                for (var j=0;j<amountOfNumbersInCase;j++) {
                    int nextNumber = in.nextInt();
                    finalSum += nextNumber;
                    var previousDifferencePrefixSum = prefixSums.get(finalSum);
                    if (previousDifferencePrefixSum != null) {
                        output = yes;
                    } else {
                        prefixSums.put(finalSum, 1);
                    }
                }
                if (finalSum == 0 || output == yes) output = yes;
                else output = no;

                out.write(output.getBytes()); // convert to bytes to be able to write
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public String testMethod() {
        return "method";
    }
}
