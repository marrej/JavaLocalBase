import java.util.*;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {

    public Integer getPalindromeAmounts(String input) {
        var modulo = 1;
        for (var i=0;i<9;i++) {
            modulo *= 10;
        }
        modulo += 7;

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

        return sum % modulo;
    }

    public Integer getClosedInbetween(String letter, Map<String, List<Integer>> letterPositions, SortedSet<Integer> closedPositions, Map<Integer, Integer> closedPositionAmounts) {
        var letterPosition = letterPositions.get(letter);
        var sum = 0;

        for (var i = 0; i < letterPosition.size(); i ++) {
            var closedPosition = closedPositions.headSet(letterPosition.get(i));
            if (closedPosition.size() == 0) {break;}
            for (var cPosition: closedPosition) {
                sum += closedPositionAmounts.get(cPosition);
            }
        }
        return sum;
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
