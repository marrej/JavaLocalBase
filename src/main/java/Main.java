import java.io.IOException;
import java.util.List;

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

    public Integer getAmountOfSips(Integer jumpStrength, List<Integer> hurdles) {
        var maxHurdle = hurdles.stream().max(Integer::compare).get();
        var maxSips = maxHurdle - jumpStrength;
        return maxSips < 0 ? 0 : maxSips;
    }
}
