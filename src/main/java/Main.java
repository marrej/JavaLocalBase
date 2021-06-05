import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {

    public String testIfPossible(List<List<Integer>> boxes) {
        var possible = "Possible";
        var impossible = "Impossible";

        var sizesAndAmounts = this.boxSizesAndBallAmounts(boxes);
        var boxSizes = sizesAndAmounts.get(0);
        var ballAmounts = sizesAndAmounts.get(1);

        if (boxSizes.equals(ballAmounts)) {
            return possible;
        } else {
            return impossible;
        }
    }

    public List<List<BigInteger>> boxSizesAndBallAmounts(List<List<Integer>> boxes) {
        List<BigInteger> sizes = new ArrayList<>();
        List<BigInteger> amounts = new ArrayList<>();
        for (var i = 0; i < boxes.size(); i++) {
            var boxSize = new BigInteger("0");
            var ballAmount = new BigInteger("0");
            for (var j = 0; j < boxes.size(); j++) {
                boxSize = boxSize.add(BigInteger.valueOf(boxes.get(i).get(j)));
                ballAmount = ballAmount.add(BigInteger.valueOf(boxes.get(j).get(i)));
            }
            sizes.add(boxSize);
            amounts.add(ballAmount);
        }
        var sortedSizes = sizes.stream().sorted(BigInteger::compareTo).collect(Collectors.toList());
        var sortedAmounts = amounts.stream().sorted(BigInteger::compareTo).collect(Collectors.toList());
        return new ArrayList<>(Arrays.asList(sortedSizes, sortedAmounts));
    }
}
