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

    public List<Integer> findClosestElements(int[] arr, Integer k, Integer x) {
        List<Integer> kClosestElements = new ArrayList<>();
        for (var element: arr) {
            var hasAllActualKClosestElements = kClosestElements.size() == k;
            if (!hasAllActualKClosestElements) {
                kClosestElements.add(element);
            } else {
                var firstKCloseElement = kClosestElements.get(0);
                var firstKCloseDistanceFromX = this.getClosenessBetween2Elements(firstKCloseElement, x);
                var elementDistanceFromX = this.getClosenessBetween2Elements(element, x);
                var isTheSameElement = firstKCloseElement == element;
                var isFirstElementFromKClosestCloserThanActualElement = firstKCloseDistanceFromX <= elementDistanceFromX;
                if (isFirstElementFromKClosestCloserThanActualElement && !isTheSameElement) {
                    break;
                } else {
                    kClosestElements.remove(0);
                    kClosestElements.add(element);
                }
            }
        }

        return kClosestElements;
    }

    private int getClosenessBetween2Elements (int el1, int el2) {
        return this.getAbsolute(el1 - el2);
    }

    private int getAbsolute(int val) {
        return val < 0 ? val * -1: val;
    }
}
