import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        CodeWorker code = new CodeWorker();
        System.out.println(code.testMethod());
    }


}

class CodeWorker {

    public String testMethod() {
        return "method";
    }

    public List<List<List<Integer>>> generateMagicSquares() {
        List<List<List<Integer>>> magicSquares = new ArrayList<>(Arrays.asList(
                Arrays.asList(Arrays.asList(6,1,8),Arrays.asList(7,5,3),Arrays.asList(2,9,4)),
                Arrays.asList(Arrays.asList(8,1,6),Arrays.asList(3,5,7),Arrays.asList(4,9,2)),
                Arrays.asList(Arrays.asList(2,9,4),Arrays.asList(7,5,3),Arrays.asList(6,1,8)),
                Arrays.asList(Arrays.asList(4,9,2),Arrays.asList(3,5,7),Arrays.asList(8,1,6)),
                Arrays.asList(Arrays.asList(4,3,8),Arrays.asList(9,5,1),Arrays.asList(2,7,6)),
                Arrays.asList(Arrays.asList(2,7,6),Arrays.asList(9,5,1),Arrays.asList(4,3,8)),
                Arrays.asList(Arrays.asList(8,3,4),Arrays.asList(1,5,9),Arrays.asList(6,7,2)),
                Arrays.asList(Arrays.asList(6,7,2),Arrays.asList(1,5,9),Arrays.asList(8,3,4))
        ));
        return magicSquares;
    }

    public Integer applyMagic(List<List<Integer>> square) {
        List<List<List<Integer>>> squares = this.generateMagicSquares();
        var minSum = 0;
        var isMinSumInitialized = false;
        for (var magicSquare: squares) {
            var newMagicDiff = this.getMagicDiff(magicSquare, square);
            if (!isMinSumInitialized) {
                minSum = newMagicDiff;
                isMinSumInitialized = true;
            } else {
                minSum = minSum < newMagicDiff ? minSum : newMagicDiff;
            }
        }
        return minSum;
    }

    public Integer getMagicDiff(List<List<Integer>> inputSquare, List<List<Integer>> magicSquare) {
        var sum = 0;
        for (var i = 0; i < inputSquare.size(); i++) {
            var inputRow = inputSquare.get(i);
            var magicRow = magicSquare.get(i);
            for (var j = 0; j < inputRow.size(); j++) {
                var inputCell = inputRow.get(j);
                var magicCell = magicRow.get(j);
                sum += this.getAbsoluteValue(inputCell - magicCell);
            }
        }
        return sum;
    }

    public Integer getAbsoluteValue (Integer input) {
        return input < 0 ? input * -1 : input;
    }
}
