import java.util.*;

public class Main {
    public static void main(String[] args) {
        CodeWorker code = new CodeWorker();
        System.out.println(code.testMethod());
    }


}

class CodeWorker {

    public String testMethod() {
        return "method";
    }

    public Integer getPositionOfLetter(Character character) {
        final Integer LETTER_OFFSET = 10;
        return Character.getNumericValue(character) - LETTER_OFFSET;
    }

    public Integer getMaxHeightofWord(String word, List<Integer> heights) {
        var maxHeight = 0;
        for (String character: word.split("")) {
            var positionOfLetter = this.getPositionOfLetter(character.charAt(0));
            var letterHeight = heights.get(positionOfLetter);
            maxHeight = maxHeight < letterHeight ? letterHeight : maxHeight;
        }
        return maxHeight;
    }

    public Integer getRectanleSize(String word, List<Integer> heights) {
        Integer LETTER_WIDTH = 1;
        var maxHeight = this.getMaxHeightofWord(word, heights);
        return maxHeight * ( word.length() * LETTER_WIDTH );
    }
}
