import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    public List<Integer> grayCode(int n) {
        List<String> grayCodes = new ArrayList<>();
        var binarySet = new HashSet<String>();
        var finalNumbers = new ArrayList<Integer>();
        if (n == 1) {
            this.fillTheFinalNumbers(this.getTwoNumberGrayCode(), n, binarySet, grayCodes, finalNumbers, 1);
            return finalNumbers;
        }

        System.out.println(grayCodes);
        for (var i=2; i<=n; i++) {
            var input = grayCodes;
            if (i == 2) {
                input = this.getTwoNumberGrayCode();
            }
            this.fillTheFinalNumbers(new ArrayList<>(input), n, binarySet, grayCodes, finalNumbers, i);
            System.out.println(grayCodes);
        }
        return finalNumbers;
    }

    public void fillTheFinalNumbers(List<String> iterable, Integer amount, Set<String> binarySet, List<String> grayCodes, List<Integer> finalNumbers, Integer position) {
        var counter = 0;
        if (position >= 3) {
            for (var i = iterable.size()-1; i >= 0; i--) {
                this.updateGrayCode(iterable.get(i), amount,position,binarySet,grayCodes,finalNumbers);
            }
        }
        for (var binary: iterable) {
            if (!(position > 2 && counter == 0)) {
                this.updateGrayCode(binary, amount,position,binarySet,grayCodes,finalNumbers);
            }
            counter++;
        }
    }

    public void updateGrayCode(String binary, Integer amount, Integer position, Set<String> binarySet, List<String> grayCodes, List<Integer> finalNumbers) {
        var inputBinary = binary;

        if (amount == 1) {
            inputBinary = binary.split("")[1];
        }

        var updatedBinary = this.getUpdatedBinary(inputBinary, amount, position, false);
        if (!binarySet.contains(updatedBinary)) {
            binarySet.add(updatedBinary);
            grayCodes.add(this.getUpdatedBinary(inputBinary, amount, position, true));
            finalNumbers.add(Integer.parseInt(updatedBinary, 2));
        }
    }

    public String getUpdatedBinary(String binary, Integer max, Integer position, boolean withoutLeadingZeros) {
        var amountOfZerosToAdd = max - binary.length();
        var finalString = "";
        var positionOffset = max - position;
        for (var i = 0; i< amountOfZerosToAdd; i++) {
            if (!withoutLeadingZeros) {
                if (i == positionOffset) {
                    finalString += "1";
                } else {
                    finalString += "0";
                }
            } else {
                if (i == positionOffset) {
                    finalString += "1";
                } else if (i > positionOffset) {
                    finalString += "0";
                }
            }
        }
        return finalString + binary;
    }

    public List<String> getTwoNumberGrayCode() {
        return new ArrayList<>(Arrays.asList(
                "00",
                "01",
                "11",
                "10",
                "00"
        ));
    }
}
