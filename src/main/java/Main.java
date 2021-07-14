import java.io.*;
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
            System.out.println(amountOfCases);
            for (var i=0;i<amountOfCases;i++) {
                System.out.println(i);
                int amountOfNumbersInCase = in.nextInt();
                String output = "no\n";
                for (var j=0;j<amountOfNumbersInCase;j++) {
                    int nextNumber = in.nextInt();
                }
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
