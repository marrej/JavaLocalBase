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

    public MapSet getMapSet(List<Integer> input) {
        var set = new HashSet<Integer>();
        var map = new HashMap<Integer, Integer>();
        for (var number: input) {
            set.add(number);
            var mapObject = map.get(number);
            if (mapObject == null) {
                map.put(number, 1);
            } else {
                map.put(number, mapObject + 1);
            }
        }
        return new MapSet(map, set);
    }

    public Integer getDiffSum(List<Integer> input, Integer diff) {
        var mapSet = this.getMapSet(input);
        var diffSum = 0;
        for (var number: mapSet.getSet()) {
            diffSum += this.getDiff(mapSet, diff, number);
        }
        return diffSum;
    }

    public Integer getDiff(MapSet mapSet, Integer diff, Integer forNumber) {
        var map = mapSet.getMap();
        var numberCount = map.get(forNumber);
        var diffCount = map.get(forNumber + diff);

        if (diffCount != null) {
            return numberCount * diffCount;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapSet mapSet = (MapSet) o;
        return Objects.equals(map, mapSet.map) && Objects.equals(set, mapSet.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map, set);
    }

    public Map<Integer, Integer> getMap() {
        return map;
    }

    public Set<Integer> getSet() {
        return set;
    }
}
