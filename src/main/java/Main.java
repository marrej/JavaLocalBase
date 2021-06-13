import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {
    public String testMethod() {
        return "method";
    }
    
    public String getLexicographicOrder(String input) {
        char letterArray[] = input.strip().toCharArray();

        var start = this.getStartIndex(letterArray);
        if (start == -1) {
            return "no answer";
        }

        var end = this.getSwapIndex(letterArray, start);

        var startLetter = letterArray[start];
        var endLetter = letterArray[end];

        letterArray[start] = endLetter;
        letterArray[end] = startLetter;

        var rest = String.valueOf(letterArray).substring(start + 1).toCharArray();
        Arrays.sort(rest);

        for (var j = start + 1; j < letterArray.length; j++) {
            letterArray[j] = rest[j - start - 1];
        }

        return String.valueOf(letterArray);
    }

    public Integer getStartIndex(char letterArray[]) {

        var start = -1;
        for (var i = 0; i < letterArray.length - 1; i++) {
            if (letterArray[i] < letterArray[i + 1]) {
                start = i;
            }
        }
        return start;
    }

    public Integer getSwapIndex(char letterArray[], int start) {
        var end = -1;
        for (var j = start + 1; j < letterArray.length; j++) {
            if (letterArray[start] < letterArray[j]) {
                end = j;
            }
        }
        return end;
    }
}
