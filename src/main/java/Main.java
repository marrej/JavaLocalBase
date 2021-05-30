import java.util.*;

public class Main {
    public static void main(String[] args) {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {

    public String testMethod() {
        return "method";
    }

    public Integer getMaxSubArraylength(List<Integer> inputArray) {
        return this.getBreakdownMaxLength(this.getElementBreakdown(inputArray));
    }

    private boolean isNextNumberInRange(List<Integer> list, Integer counter , Integer actualNumber) {
        return list.size() > counter+1 && this.getNextNumberInRange(list, counter)-actualNumber <= 1;
    }

    private Integer getNextNumberInRange(List<Integer> list, Integer counter) {
        return list.get(counter+1);
    }

    public Integer getBreakdownMaxLength(ElementBreakdown elementBreakdown) {
        var maxlength = 0;
        var map = elementBreakdown.getBreakdownMap();
        var list = elementBreakdown.getBreakdownList();
        var counter = 0;
        for (var num: list) {

            var actualNumber = map.get(num);
            var nextNumber = 0;
            if (this.isNextNumberInRange(list, counter, num)) {
                nextNumber = map.get(this.getNextNumberInRange(list, counter));
            }
            var sum = actualNumber + nextNumber;
            maxlength = maxlength > sum ? maxlength : sum;
            counter++;
        }
        return maxlength;
    }

    public ElementBreakdown getElementBreakdown(List<Integer> inputArray) {
        List<Integer> breakdownList = new ArrayList<>();
        Map<Integer, Integer> breakdownMap = new HashMap<>();

        for (var element: inputArray) {
            var breakdownElement = breakdownMap.get(element);
            var isElementInMap = breakdownElement != null;
            if (isElementInMap) {
                breakdownMap.put(element, breakdownElement+1);
            } else {
                breakdownMap.put(element, 1);
                breakdownList.add(element);
            }
        }

        Collections.sort(breakdownList);
        ElementBreakdown elementBreakdown = new ElementBreakdown(breakdownList, breakdownMap);
        return elementBreakdown;
    }
}

class ElementBreakdown {
    private List<Integer> breakdownList;
    private Map<Integer, Integer> breakdownMap;

    public ElementBreakdown(List<Integer> breakdownList, Map<Integer, Integer> breakdownMap) {
        this.breakdownList = breakdownList;
        this.breakdownMap = breakdownMap;
    };

    public List<Integer> getBreakdownList() {
        return breakdownList;
    }

    public Map<Integer, Integer> getBreakdownMap() {
        return breakdownMap;
    }
}
