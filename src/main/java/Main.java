import java.util.*;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    public String encrypt(String input) {
        var strip = this.strip(input);
        var rowAndColumn = this.getRowAndColumn(strip);
        var encryptionMatrix = this.getEncryptMatrix(strip,rowAndColumn);
        return this.getStringFromEncryptionMatrix(encryptionMatrix, rowAndColumn);
    }

    public String getStringFromEncryptionMatrix(List<List<String>> encryptionMatrix, List<Integer> rowAndColumn) {
        var finalString = "";
        var row = rowAndColumn.get(0);
        var col = rowAndColumn.get(1);

        for (var i = 0; i < col ;i ++) {
            var partialString = "";
            for (var j = 0; j < row; j ++) {
                var rowList = encryptionMatrix.get(j);
                if (rowList.size() > i) {
                    partialString += rowList.get(i);
                } else {
                    break;
                }
            }
            if (i != 0) {
                partialString = " " + partialString;
            }
            finalString += partialString;
        }

        return finalString;
    }

    public List<List<String>> getEncryptMatrix(String input, List<Integer> rowAndColumn) {
        List<List<String>> encryptMatrix = new ArrayList<>();
        var row = rowAndColumn.get(0);
        var col = rowAndColumn.get(1);
        var split = input.split("");
        var counter = 0;
        for (var i = 0; i < row; i ++) {
            var column = new ArrayList<String>();
            for (var j = 0; j < col; j ++) {
                if (split.length > counter) {
                    column.add(split[counter]);
                    counter++;
                }
            }
            encryptMatrix.add(column);
        }
        return encryptMatrix;
    }

    public String strip(String input) {
        return input.replaceAll(" ", "");
    }

    public List<Integer> getRowAndColumn(String input) {
        var length = input.length();
        var root = Math.sqrt(length);
        var lowRoot = (int) Math.floor(root);
        var highRoot = (int) Math.ceil(root);
        return this.getSmallestArea(this.getCombinationsBiggerOrEqualThanStringLength(length, lowRoot, highRoot));
    }

    public List<List<Integer>> getCombinationsBiggerOrEqualThanStringLength(Integer strLength, Integer low, Integer high) {
        List<List<Integer>> finalCombinations = new ArrayList<>();
        List<List<Integer>> areas = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(low,low)),
                new ArrayList<>(Arrays.asList(low,high)),
                new ArrayList<>(Arrays.asList(high,high))));
        for (var area: areas) {
            var sum = area.stream().reduce(1, (a, b) -> a * b);
            if (sum >= strLength) {
                finalCombinations.add(area);
            }
        }

        return finalCombinations;
    }

    public List<Integer> getSmallestArea(List<List<Integer>> combinations) {
        List<Integer> finalCombination = new ArrayList<>();
        var smallestSum = -1;
        for (var combination: combinations) {
            var sum = 1;
            for (var option: combination) {
                sum*=option;
            }
            if (smallestSum == -1) {
                finalCombination = combination;
                smallestSum = sum;
            } else {
                if (sum < smallestSum) {
                    finalCombination = combination;
                    smallestSum = sum;
                }
            }
        }
        return  finalCombination;
    }
}
