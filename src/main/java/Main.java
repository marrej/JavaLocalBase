import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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
    SquareMemory squareMemory = null;
    Integer actualCoins = 0;

    public InputProcessor(Scanner inputStream, FileOutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        playerMove = new PlayerMove();
        squareMemory = new SquareMemory();
    }

    public FileOutputStream processAllCases() throws Exception {
        int coins = -1;
        do {
            try {
                coins = this.inputStream.nextInt();
                actualCoins = coins;
                this.prepareSquaresForCoins(actualCoins);
                this.playGame();
                this.outputStream.write(playerMove.getActualPlayer().getBytes());
                this.resetPlayersMove();
            } catch (Exception e) {
                throw new Exception("End of Stream");
            }
        } while (coins != -1);
        return this.outputStream;
    }

    private void resetPlayersMove() {
        playerMove = new PlayerMove();
    }

    private void playGame() {
        var isNotEndOfGame = true;
        System.out.println("NEW GAME");
        while (isNotEndOfGame) {
            System.out.println(playerMove.getActualPlayer() + " " + actualCoins);
            this.tryToReduceToZero();
            if (actualCoins == 0) {
                break;
            }
            this.tryToBlockTheOtherPlayerFromWinning();
            System.out.println(playerMove.getActualPlayer() + " " + actualCoins);
            playerMove.nextPlayerMove();
        }
    }

    private void tryToReduceToZero() {
        var allCoinsTakes = squareMemory.getAllSquaresForNumber(actualCoins);
        if (allCoinsTakes.get(allCoinsTakes.size()-1) == actualCoins) {
            actualCoins = 0;
        }
    }

    private void tryToBlockTheOtherPlayerFromWinning() {
        var breakOut = false;
        var allCoinsTakes = squareMemory.getAllSquaresForNumber(actualCoins);

        for (var i = allCoinsTakes.size() -1; i >=0; i-- ) {
            var possibleBestTake = allCoinsTakes.get(i);
            var actualRest = actualCoins - allCoinsTakes.get(i);
            var hasPotential = this.hasPotentialToWin(1, actualRest);
            if (hasPotential) {
                actualCoins -= possibleBestTake;
                breakOut = true;
                break;
            }
        }
        if (!breakOut) {
            actualCoins -= allCoinsTakes.get(0);
        }
    }

    private boolean hasPotentialToWin(Integer step, Integer remainingCoins) {
        System.out.println(remainingCoins);
        var allCoinsTakes = squareMemory.getAllSquaresForNumber(remainingCoins);
        for (var j = allCoinsTakes.size() -1; j >=0; j-- ) {
            var possibleBestTake = allCoinsTakes.get(j);
            var actualRest = remainingCoins - possibleBestTake;
            if (actualRest == 0) {
                return step%2!=0 ? false : true;
            }
            if (actualRest > 0 &&  step%2!=0) {
                return this.hasPotentialToWin(step+1, actualRest);
            }
        }
        return step%2!=0 ? true : false;
    }



    private void prepareSquaresForCoins(Integer coins) {
        squareMemory.fillAllSquaresUntilInput(coins);
    }

}

class SquareMemory {
    private TreeSet<Integer> squares = null;
    private List<Integer> squareRoots = null;

    public SquareMemory () {
        squares = new TreeSet<>();
        squareRoots = new ArrayList<>();
    }

    public List<Integer> getAllSquaresForNumber(Integer input) {
        return squares.headSet(input, true).stream().collect(Collectors.toList());
    }

    public void fillAllSquaresUntilInput(Integer input) {
        if (squareRoots.size() > 0) {
            var isLastSquareSmallerThanInput = false;
            do {
                var lastSquareRoot = squareRoots.get(squareRoots.size()-1);
                var newSquareRoot = lastSquareRoot+1;
                squareRoots.add(newSquareRoot);
                var newSquare= newSquareRoot*newSquareRoot;
                squares.add(newSquare);
                var squareList = this.getAllSquaresForNumber(input);
                var lastSquare = squareList.get(squareList.size() - 1);
                isLastSquareSmallerThanInput = lastSquare < input;
                if (newSquare > input) break;
            } while (isLastSquareSmallerThanInput);
        } else {
            squareRoots.add(1);
            squares.add(1);
        }

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
