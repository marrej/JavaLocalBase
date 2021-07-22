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
            var inputProcessor = new InputProcessor(in,out);
            out = inputProcessor.processAllCases();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: make prettier
            System.err.println("End of stream");
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}

class InputProcessor {
    Scanner inputStream = null;
    FileOutputStream outputStream = null;

    public InputProcessor(Scanner inputStream, FileOutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public FileOutputStream processAllCases() throws Exception {
        int amountOfCases = -1;
        do {
            try {
                amountOfCases = this.inputStream.nextInt();
                System.out.println(amountOfCases);
                this.outputStream.write("Pat\n".getBytes());
            } catch (Exception e) {
                throw new Exception("End of Stream");
            }
        } while (amountOfCases != -1);
        return this.outputStream;
    }

}
