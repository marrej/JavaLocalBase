import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    public List<String> getPermutations (String input) {
        List<String> letters = Arrays.stream(input.split("")).collect(Collectors.toList());
        var letterPositionToSwap = 0;
        return this.getPermutationsOn(letters, letterPositionToSwap).stream().map(list -> list.stream().collect(Collectors.joining(""))).distinct().collect(Collectors.toList());
    }

    private List<List<String>> getPermutationsOn(List<String> letters, Integer leterPosition) {
        if (leterPosition >= letters.size()) return new ArrayList<>(Arrays.asList(letters));
        List<List<String>> collectionOfPermutations = new ArrayList<>();
        for (var i= leterPosition; i<letters.size(); i++) {
            var swappedLetters = new ArrayList<>(letters);
            var temp = swappedLetters.get(i);
            swappedLetters.set(i, swappedLetters.get(leterPosition));
            swappedLetters.set(leterPosition, temp);
            collectionOfPermutations.addAll(this.getPermutationsOn(swappedLetters, leterPosition+1));
        }
        return  collectionOfPermutations;
    }
}
