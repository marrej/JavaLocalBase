import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    public MapSet getMapSet(List<Integer> input) {
        return new MapSet();
    }

    public Integer getDiffSum(List<Integer> input, Integer diff) {
        return 0;
    }

    public Integer getDiff(MapSet mapSet, Integer diff, Integer forNumber) {
        return 0;
    }
}

class MapSet {
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public MapSet(Map<Integer, Integer> map, Set<Integer> set) {
        this.map = map;
        this.set = set;
    }
}
