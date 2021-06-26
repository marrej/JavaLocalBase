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

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, UUID> groupMap = new HashMap<>();
        Map<UUID, TreeSet<Integer>> groupSets = new HashMap<>();
        int[] res = null;
        for (var edge: edges) {
            var edge1 = edge[0];
            var group1 = groupMap.get(edge1);
            var edge2 = edge[1];
            var group2 = groupMap.get(edge2);
            if (group1 == null && group2 == null) {
                var newUuid = UUID.randomUUID();
                groupMap.put(edge1, newUuid);
                groupMap.put(edge2, newUuid);

                var newSet = new TreeSet<Integer>();
                newSet.add(edge1);
                newSet.add(edge2);
                groupSets.put(newUuid, newSet);
            } else if (group1 == null || group2 == null) {
                if (group1 != null) {
                    groupMap.put(edge2, group1);
                    groupSets.get(group1).add(edge2);
                } else {
                    groupMap.put(edge1, group2);
                    groupSets.get(group2).add(edge1);
                }
            } else if (group1 != null && group2 != null) {
                var set1 =groupSets.get(group1);
                var set2 =groupSets.get(group2);

                if (group1.equals(group2)) {
                    res = edge;
                } else {
                    if (set1.size() < set2.size()) {
                        var newSet = new TreeSet<>(set2);
                        for (var setElement: set1) {
                            newSet.add(setElement);
                            groupMap.put(setElement, group2);
                        }
                        groupSets.put(group2, newSet);
                        groupSets.remove(group1);
                    } else {
                        var newSet = new TreeSet<>(set1);
                        for (var setElement: set2) {
                            newSet.add(setElement);
                            groupMap.put(setElement, group1);
                        }
                        groupSets.put(group1, newSet);
                        groupSets.remove(group2);
                    }
                }
            }

//            System.out.println("----");
//            System.out.println(groupSets);
////            System.out.println(groupMap);
        }

//        System.out.println(res[0] + " " + res[1]);
        return res;
    }
}
