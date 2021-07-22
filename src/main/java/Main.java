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
    PlayerMove playerMove = null;

    public InputProcessor(Scanner inputStream, FileOutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        playerMove = new PlayerMove();
    }

    public FileOutputStream processAllCases() throws Exception {
        int amountOfCases = -1;
        do {
            try {
                amountOfCases = this.inputStream.nextInt();
                System.out.println(amountOfCases);
                this.outputStream.write(playerMove.getActualPlayer().getBytes());
            } catch (Exception e) {
                throw new Exception("End of Stream");
            }
        } while (amountOfCases != -1);
        return this.outputStream;
    }

}

class PlayerMove {
    final private String pat = "Pat\n";
    final private String mat = "Mat\n";
    private Integer playerCounter = 0;
    public PlayerMove() {
    }

    public void nextPlayerMove() {
        playerCounter++;
    }

    public String getActualPlayer() {
        var isSecondPlayer = playerCounter%2 == 1;
        return isSecondPlayer ? mat : pat;
    }
}
