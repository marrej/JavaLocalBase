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

    public Integer getPalindromeAmounts(String input) {
        var letters = input.split("");
        var sum = 0;

        Map<String, List<Integer>> letterPositions = new HashMap<>();
        SortedSet<Integer> closedPositions = new TreeSet<>(java.util.Collections.reverseOrder());
        Map<Integer, Integer> closedPositionAmounts = new HashMap<>();
        for (var i = 0; i< letters.length; i++) {
            var letter = letters[i];
            if (letterPositions.get(letter) == null) {
                letterPositions.put(letter, new ArrayList<>(Arrays.asList(i)));
            } else {
                sum += this.getClosedInbetween(letter, letterPositions, closedPositions, closedPositionAmounts);
                this.closePosition(letter,i, letterPositions, closedPositions, closedPositionAmounts);


                letterPositions.get(letter).add(i); // has to be always last so it won't close itself off
            }
        }

        return sum;
    }

    public Integer getClosedInbetween(String letter, Map<String, List<Integer>> letterPositions, SortedSet<Integer> closedPositions, Map<Integer, Integer> closedPositionAmounts) {
        var letterPosition = letterPositions.get(letter);
        var firstPosition = letterPosition.get(0);
        var closedPosition = closedPositions.headSet(firstPosition - 1);

        for (var position: closedPosition) {

        }

        return 0;
    }

    public void closePosition(String letter, Integer pos, Map<String, List<Integer>> letterPositions, SortedSet<Integer> closedPositions, Map<Integer, Integer> closedPositionAmounts) {
        var letterPosition = letterPositions.get(letter);
        for (var letterPos: letterPosition) {
            if (pos > letterPos) {
                closedPositions.add(letterPos);
                var closedAmount = closedPositionAmounts.get(letterPos);
                if (closedAmount != null) {
                    closedPositionAmounts.put(letterPos, closedAmount+1);
                } else {
                    closedPositionAmounts.put(letterPos, 1);
                }
            }
        }
    }
}
