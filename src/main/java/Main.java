import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CodeWorker code = new CodeWorker();
        System.out.println(code.testMethod());
    }
}

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    public Set<Integer> getRankedSet(List<Integer> ranked) {
        Set<Integer> targetSet = new HashSet<>(ranked);
        return targetSet;
    }

    public List<Integer> getSortedList(Set<Integer> rankedSet) {
        List<Integer> sortedSet = new ArrayList<>(rankedSet);
        Collections.sort(sortedSet, Collections.reverseOrder());
        return sortedSet;
    }

    public Integer getPlayerPositon(Integer playerScore, List<Integer> rankedScore) {
        var max = rankedScore.get(0);
        var min = rankedScore.get(rankedScore.size() -1);
        if (playerScore > max) {
            return 1;
        } else if (playerScore < min) {
            return rankedScore.size() + 1;
        }

        var position = new BST().binarySearch(rankedScore, playerScore);
        return position + 1;
    }

    public List<Integer> getPlayerPositons(List<Integer> playerScores, List<Integer> rankedScores) {
        List<Integer> playerPositions = new ArrayList<>();
        var sortedScores = this.getSortedList(this.getRankedSet(rankedScores));
        for (var score: playerScores) {
            playerPositions.add(this.getPlayerPositon(score, sortedScores));
        }
        return playerPositions;
    }


}

class BST {
    int binarySearch(List<Integer> arr, int x)
    {
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr.get(m) == x)
                return m;

            // If x greater, ignore left half
            if (arr.get(m) > x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return (l + (r - l) / 2) ;
    }
}
