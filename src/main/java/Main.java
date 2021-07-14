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
            var inputProcessor = new InputProcessor(in,out);
            out = inputProcessor.processAllCases();
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
}

class InputProcessor {
    Scanner inputStream = null;
    FileOutputStream outputStream = null;
    Map<Integer, Integer> prefixSums;

    public InputProcessor(Scanner inputStream, FileOutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public FileOutputStream processAllCases() throws IOException {
        int amountOfCases = this.inputStream.nextInt();
        for (var i=0;i<amountOfCases;i++) findAnswerForCaseAndStoreInOuput();
        return this.outputStream;
    }

    private void findAnswerForCaseAndStoreInOuput() throws IOException {
        initializeNewPrefixMap();
        var answer = getAnswerForSequence();
        storeAnswerInOutput(answer);
    }

    private Answer getAnswerForSequence() {
        int amountOfNumbersInCase = this.inputStream.nextInt();
        return hasPrefixSequence(amountOfNumbersInCase);
    }

    private void storeAnswerInOutput(Answer answer) throws IOException {
        this.outputStream.write(answer.getBytes());
    }

    private Answer hasPrefixSequence(int amountOfNumbersInCase) {
        var answer = new Answer();
        answer.setNo();
        int finalSum = 0;

        for (var j = 0; j< amountOfNumbersInCase; j++) {
            int nextNumber = this.inputStream.nextInt();
            finalSum += nextNumber;
            var differentialPrefix = prefixSums.get(finalSum);
            if (hasAZeroSum(differentialPrefix)) answer.setYes();
            else storeActualSumAsPrefix(finalSum);

        }
        return answer;
    }

    private boolean hasAZeroSum(Integer differentialPrefix) {
        return differentialPrefix != null;
    }

    private Integer storeActualSumAsPrefix(int finalSum) {
        return prefixSums.put(finalSum, 1);
    }

    private void initializeNewPrefixMap() {
        prefixSums = new HashMap<>();
    }


}

class Answer {
    String yes = "yes\n";
    String no = "no\n";
    String finalAnswer = "";

    public void setYes() {
        finalAnswer = yes;
    }

    public void setNo() {
        finalAnswer = no;
    }

    public byte[] getBytes() {
        return finalAnswer.getBytes();
    };
}
