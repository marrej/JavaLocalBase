import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    public String removeDuplicates(String s) {
        var letters = new ArrayList<String>(Arrays.asList(s.split("")));
        for (var i = 0; i < letters.size(); i++) {
            var letter = letters.get(i);
//            System.out.println(letter + "  " + i);
            if (i+1 < letters.size()) {
                var nextLetter= letters.get(i+1);
                if (letter.equals(nextLetter)) {
                    letters.remove(i+1);
                    letters.remove(i);
                    i--;
                    if (i >= 0) {
                        i--;
                    }
                }
            }

        }
        return letters.stream().reduce("", (subtotal, element) -> subtotal + element);
    }
}
